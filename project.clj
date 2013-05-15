(defproject contentjon/kit.cljs "0.1.0"
  :description      "A ClojureScript support library for other projects"
  :url              "https://github.com/contentjon/kit.cljs"
  :license          {:name         "EPL"
                     :url          "http://www.eclipse.org/legal/epl-v10.html"
                     :distribution :repo
                     :comments     "Same as Clojure"}
  :min-lein-version "2.0.0"
  :plugins          [[lein-cljsbuild "0.3.1"]]
  :dependencies     [[org.clojure/clojure "1.5.1"]]
  :profiles         {:dev {:dependencies [[mocha-latte "0.1.0"]
                                          [chai-latte  "0.1.0"]]}}
  :cljsbuild
  {:builds
   [{:source-paths ["src" "test"],
     :id "unit",
     :compiler
     {:pretty-print  true,
      :output-to     "test/unit.js",
      :optimizations :simple}}]})
