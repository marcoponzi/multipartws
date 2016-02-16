(ns multipartws.core
  (:use [org.httpkit.server :only [run-server]])
  (:require [clojure.tools.logging :as log]
            [ring.middleware.reload :as reload]))

(defn handler [request]
  (println "bef")
  (log/info "TESTLOG")
  (println "aft")
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello Worldfdsafsafadsf"})


(def app 
 handler
)

(defn -main [& args]
    (run-server (reload/wrap-reload #'app) {:port 8080}))

