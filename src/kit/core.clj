(ns kit.core)

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
