(ns kit.test.core
  (:require [latte.chai :refer (expect)])
  (:require-macros [kit.core   :refer (! ?)]
                   [latte.core :refer (describe it)]))

(describe "aset/get wrappers"

  (it "allow access like aget/aset" []

    (let [foo (js-obj)]

      (! foo "a" :bar)
      (expect (? foo "a") :to.be.equal :bar)))

  (it "allow keywords for access" []

    (let [foo (js-obj)]

      (! foo :a 1)
      (expect (? foo :a)  :to.be.equal 1)
      (expect (? foo "a") :to.be.equal 1)))

  (it "allow path access while getting a value" []

    (let [foo (js-obj "a" (js-obj "b" :bar))]

      (expect (? foo "a" "b") :to.be.equal :bar)
      (expect (? foo :a :b)   :to.be.equal :bar)))

  (it "behave like aget when getting a value from nil" []

      (expect #(aget nil "bar") :to.throw js/TypeError)
      (expect #(? nil "bar")    :to.throw js/TypeError))

  (it "behave like aget when getting a nil key from an object" []

      (expect
        (aget (js-obj "a" 1) nil)
       :to.be.undefined)

      (expect
        (? (js-obj "a" 1) nil)
       :to.be.undefined)

      (expect
        #(aget (js-obj "a" (js-obj "b" 1)) nil "b")
        :to.throw
        js/TypeError)

      (expect
        #(? (js-obj "a" (js-obj "b" 1)) nil :b)
        :to.throw
        js/TypeError))

  (it "behave like aset when setting a value on nil" []

      (expect #(aset nil "baz" "bar") :to.throw js/TypeError)
      (expect #(! nil :baz "bar")     :to.throw js/TypeError)))
