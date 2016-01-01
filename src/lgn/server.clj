(ns lgn.server
  (:use
    [compojure.core     :only [defroutes GET POST]])
  (:require
    [lgn.util           :as u]
    [lgn.data           :as d]
    [compojure.route    :as route]
    [org.httpkit.server :as httpkit]
    [ring.util.response :as response]
    )
  (:gen-class))


(def sample-size 10)

(defn get-result [answers] ;list of [id:String name:String]
  (let [correct (count (filter (fn [[id name]] (= name (:name (d/champs id)))) answers))
        correct-percent (quot (* correct 10) sample-size)]
    (println answers)
    [sample-size correct (d/result-desc correct-percent)]))

(defn get-random-names-except [gender name n]
  (take n (shuffle (seq (into #{} (map :name (filter #(and (= gender (:gender %)) (not= name (:name %))) (vals d/champs))))))))

(defn new-sample []
  (map #(assoc % :names (shuffle (conj (get-random-names-except (:gender %) (:name %) 3) (:name %)))) (take sample-size (shuffle (vals d/champs)))))

(defroutes routes
  (GET "/" [] (response/resource-response "public/index.html"))

  (GET "/start-test" [] (u/to-json (new-sample)))

  (POST "/get-result" {body :body} (u/to-json (get-result (u/from-json (slurp body)))))

  (route/resources "/" {:root "public"}))

(defn -main [& {:as args}]
  (let [port (or (get args "--port") "8080")]
    (println "Starting server at port" port)
    (httpkit/run-server #'routes {:port (Long/parseLong port)})))


