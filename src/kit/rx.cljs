(ns kit.rx
  (:refer-clojure :exclude (filter))
  (:require [cljs.core.async :refer [>! <! chan close!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn map [f in]
  (let [out (chan)]
    (loop []
      (go (if-let [x (<! in)]
            (do
              (>! out (f x))
              (recur))
            (close! out))))
    out))

(defn filter [pred in]
  (let [out (chan)]
    (loop []
      (go (if-let [x (<! in)]
            (do
              (when (pred x)
                (>! out x))
              (recur))
            (close! out))))
    out))
