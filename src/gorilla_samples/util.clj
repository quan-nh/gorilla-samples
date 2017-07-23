(ns gorilla-samples.util
  (:require
    [clj-time.core :as t]
    [clj-time.coerce :as c]
    [clojure.data.csv :as csv]
    [clojure.java.io :as io]))
    
(defn ->vn-time [t]
  (t/to-time-zone (c/from-long (* t 1000)) (t/time-zone-for-offset 7)))

(defn ->int [s]
  (try (Integer/parseInt s) (catch Exception _ 0)))
  
(defn update-values [m f & args]
  (into {} (for [[k v] m] [k (apply f v args)])))

(defn read-csv [f]
  (with-open [reader (io/reader (io/resource f))]
    (doall
      (csv/read-csv reader))))

(defn read-csv-with-header [f]
  (with-open [reader (io/reader (io/resource f))]
    (doall
      (let [[header & data] (csv/read-csv reader)
            header-kw       (map keyword header)]
        (map #(zipmap header-kw %) data)))))
