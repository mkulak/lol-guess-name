(ns lgn.util
  (:require
    [cognitect.transit :as t]))

(defn from-json [s]
  #?(:clj
      (-> s
        (.getBytes "UTF-8")
        (java.io.ByteArrayInputStream.)
        (t/reader :json)
        (t/read))
      :cljs
      (t/read (t/reader :json) s)))


(defn to-json [o]
  #?(:clj
      (let [os (java.io.ByteArrayOutputStream.)]
        (t/write (t/writer os :json) o)
        (String. (.toByteArray os) "UTF-8"))
      :cljs
      (t/write (t/writer :json ) o)))
