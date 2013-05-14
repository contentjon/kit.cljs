(ns kit.core)

(defmacro ?
  "A shorthand for aget"
  [a & ks]
  `(aget ~a ~@(map #(if (keyword? %) (name %) %) ks)))

(defmacro !
  "A shorthand for aset"
  [a k v]
  `(aset ~a ~(if (keyword? k) (name k) k) ~v))

(defmacro undefined?
  "cljs.core undefined? is broken when no inlining is done.
   we define a new version here to work around that until
   the bug is fixed upstream"
  [x]
  (list 'js* "typeof ~{} === 'undefined'" x))

(defmacro exists?
  "cljs.core undefined? is broken when no inlining is done.
   we define a new version here to work around that until
   the bug is fixed upstream"
  [x]
  (list 'js* "typeof ~{} !== 'undefined'" x))
