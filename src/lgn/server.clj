(ns lgn.server
  (:use
    [compojure.core     :only [defroutes GET POST routes]])
  (:require
    [lgn.util           :as u]
    [lgn.data           :as d]
    [compojure.route    :as route]
    [ring.util.response :as response]
    [compojure.handler  :as handler]
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

(defroutes app-routes
  (GET "/" [] (response/resource-response "public/index.html"))

  (GET "/start-test" [] (u/to-json (new-sample)))

  (POST "/get-result" [result] (u/to-json (get-result (u/from-json result))))

  (route/resources "/" {:root "public"}))


(def app (handler/site (routes app-routes)))