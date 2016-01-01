(ns lgn.app
  (:require
    [lgn.util :as u]
    [cljs-http.client :as http]
    [reagent.core :as r]
    [cljs.core.async :refer [<!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(enable-console-print!)

(declare refresh)

(defonce *persons (r/atom []))
(defonce *pick (r/atom {})) ;pick map of id to [name correct?]
(defonce *selected-name (r/atom nil)) ;[id name]
(defonce *result (r/atom nil)) ;[total correct description]


(add-watch *pick :results
  (fn [key atom old new]
    (if (= (count @*persons) (count new))
      (let [data (map (fn [[id [name _]]] [id name]) new)]
        (println data)
        (go (let [response (<! (http/post (str "http://" js/location.host "/get-result") {:body (u/to-json data)}))]
          (reset! *result (u/from-json (:body response)))))))))

(defn mouse-over [over id name]
  (reset! *selected-name (if over [id name] nil)))

(defn on-click-name [id correct-name pick-name]
  (if (nil? (@*pick id))
    (swap! *pick assoc id [pick-name (= pick-name correct-name)])))

(defn calc-span-class [id correct-name name]
  (let [pick-name (first (@*pick id))]
    (cond
      (nil? pick-name) (if (= [id name] @*selected-name) "name selected" "name")
      (and (not= pick-name name) (not= correct-name name)) "name"
      (= pick-name name correct-name) "name correct"
      (= correct-name name) "name right_answer"
      :else "name incorrect")))

(defn person-view [person]
  [:div.person
   [:div.photo [:img {:src (str "/champs/" (:id person) ".png")}]]
   (doall (for [name (:names person)]
     ^{:key (str "name_" (:id person) name)} [:span {
                                                      :class (calc-span-class (:id person) (:name person) name)
                                                      :on-click #(on-click-name (:id person) (:name person) name)
                                                      :on-mouse-over #(mouse-over true (:id person) name)
                                                      :on-mouse-out #(mouse-over false (:id person) name)
                                                      } name]))
   ])

(defn results-view []
  (if-let [result @*result]
    (let [[total correct desc] result]
      [:div.results
       [:span.results (str "Your result: " correct "/" total)]
       [:span.results desc]
       [:span.again {:on-click refresh} "Again"]
       ])))

(defn main-view []
  [:div.outer
   [:div.inner
    [:div.header [:h1 "Guess champion name"]]
    (for [person @*persons] ^{:key (str "person_" (:id person))} [person-view person])
    [results-view]
   ]])

(defn start-page [mount]
  (go (let [response (<! (http/get (str "http://" js/location.host "/start-test")))]
        (let [data (u/from-json (:body response))]
          (reset! *persons (take 10 data))
          (reset! *pick {})
          (reset! *result nil)
          (reset! *selected-name nil)
          (r/render-component [main-view] mount)))))

(defn ^:export refresh []
  (start-page (js/document.getElementById "app")))
