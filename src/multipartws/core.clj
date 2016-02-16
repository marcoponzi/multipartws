(ns multipartws.core
  (:use [org.httpkit.server :only [run-server]])
  (:require [ring.middleware.reload :as reload]))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP! 3" })

(defn -main [& args]
    (run-server (reload/wrap-reload #'app) {:port 8080}))

