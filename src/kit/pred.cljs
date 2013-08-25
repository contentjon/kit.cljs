(ns kit.pred
  "A collection of higher order predicates")

(defn eq? [x]
  #(= % x))

(defn is? [p x]
  (comp (eq? x) p))
