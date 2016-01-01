(defproject lol-guess-name "0.1.0-SNAPSHOT"
  :dependencies [
    [org.clojure/clojure        "1.7.0"]
    [org.clojure/clojurescript  "1.7.189"]
    [org.clojure/core.async     "0.2.374"]
    [http-kit                   "2.1.19"]
    [compojure                  "1.4.0" :exclusions [commos-codec]]
    [com.cognitect/transit-clj  "0.8.285"]
    [com.cognitect/transit-cljs "0.8.232"]
    [com.lucasbradstreet/instaparse-cljs "1.4.1.0"]
    [cljs-http "0.1.39"]
    [reagent "0.6.0-alpha"]
  ]

  :clean-targets ^{:protect false} ["resources/public/js" "target"]

  :plugins [
    [lein-cljsbuild       "1.1.1"]
    [tonsky/lein-figwheel "0.5.0-4"]
  ]

  :aliases      { "package"   ["do" "cljsbuild" "once" "advanced," "uberjar"]
                  "build-run" ["do" "cljsbuild" "once," "run"]}

  :aot [lgn.server ]
  :uberjar-name "lol-guess-name.jar"
  :uberjar-exclusions [#"public/js/out"]


  :main         lgn.server
  :figwheel     { :ring-handler  "lgn.server/app"
                  :css-dirs     ["resources/public"]
                  :server-port   8080
                  :repl          false }

  :cljsbuild {
    :builds [
      { :id           "none"
        :source-paths ["src"]
        :figwheel     { :on-jsload      "lgn.app/refresh" }
        :compiler     { :optimizations  :none
                        :main           lgn.app
                        :asset-path     "/js/out"
                        :output-to      "resources/public/js/main.js"
                        :output-dir     "resources/public/js/out"
                        :source-map     true
                        :compiler-stats true } }

      { :id           "advanced"
        :source-paths ["src"]
        :compiler     { :optimizations  :advanced
                        :main           lgn.app
                        :output-to      "resources/public/js/main.js"
                        :compiler-stats true
                        :pretty-print   false
                        :pseudo-names   false } }
  ]}
)
