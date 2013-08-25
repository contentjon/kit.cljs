(ns kit.log)

(defn info
  "Log a message with a level of INFO"
  [& msg]
  (.info js/console (apply str msg)))

(defn error
  "Log a message with a level of ERROR"
  [& msg]
  (.error js/console (apply str msg)))

(defn info-x
  "Logs a value x with a level of INFO and returns that value"
  [x]
  (info x)
  x)

(defn info-fn
  "Takes a function of one parameter and logs that parameter
   every time the function gets called, with a level of INFO"
  [f]
  (fn [x]
    (info x)
    (f x)))
