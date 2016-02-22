(ns multipartws.core
  (:use [org.httpkit.server :only [run-server]])
  (:require [clojure.tools.logging :as log]
            [clojure.java.io :as io]
            [ring.middleware.reload :as reload]
            [ring.middleware.params :as params]
            [ring.middleware.multipart-params :as multipart-params]))

(use 'ring.middleware.params
     'ring.middleware.multipart-params)

; TODO configuration via property file
; copy via ssh

(defn handler [{params :params}] 
  
  (log/info "handler start")
  (log/info (str "para name:" (params "name")))
  (log/info (str "para file:" (params "file")))

(let [{:keys [tempfile filename]} (get params "file")]
  (io/copy tempfile (java.io.File. (str  "./" "RECEIVED" filename))) 
  (log/info "copied:" filename))

  (log/info "handler end")
 
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello 1706"}

)

  (defn wrap-spy [handler]
    (fn [request]
      (println "-------------------------------")
      (println "Incoming Request:")
      (clojure.pprint/pprint request)
      (let [response (handler request)]
        (println "Outgoing Response Map:")
        (clojure.pprint/pprint response)
        (println "-------------------------------")
        response)))


(def app
  (-> handler
      params/wrap-params
      multipart-params/wrap-multipart-params
      (wrap-spy)))


(defn -main [& args]
    (run-server (reload/wrap-reload #'app) {:port 8080}))

