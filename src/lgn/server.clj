(ns lgn.server
  (:use [compojure.core          :only [defroutes GET POST]]
        [ring.middleware.cookies :only [wrap-cookies]])
  (:require
    [lgn.util      :as u]
    [lgn.logic     :as logic]
    [clojure.java.io    :as io]
    [compojure.route    :as route]
    [org.httpkit.server :as httpkit]
    [ring.util.response :as response]
    )
  (:gen-class))


(defroutes routes
  (GET "/" [] (response/resource-response "public/index.html"))

  (GET "/start-test" [] (u/to-json (logic/new-sample)))
;  (GET "/start-test" [] "ku")

  (POST "/get-result" {body :body} (u/to-json (logic/get-result (u/from-json (slurp body)))))

  (route/resources "/" {:root "public"}))

(def app routes)

(defn -main [& {:as args}]
  (let [port (or (get args "--port") "8080")]
    (println "Starting server at port" port)
    (httpkit/run-server #'app {:port (Long/parseLong port)})))


