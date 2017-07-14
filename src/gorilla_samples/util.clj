(ns gorilla-samples.util
  (:require
    [clj-time.core :as t]
    [clj-time.coerce :as c]))

(defn ->vn-time [t]
  (t/to-time-zone (c/from-long (* t 1000)) (t/time-zone-for-offset 7)))

(defn update-values [m f & args]
  (into {} (for [[k v] m] [k (apply f v args)])))