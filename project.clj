(defproject aaaa "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;;:dependencies [[org.clojure/clojure "1.7.0"]]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-devel "1.4.0"]
                 [ring/ring-core "1.4.0"]
[javax.servlet/servlet-api "2.5"]
                 [org.clojure/tools.logging "0.3.1"]
[org.slf4j/slf4j-log4j12 "1.7.1"]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jmdk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 [http-kit "2.1.19"]]

  :main ^:skip-aot multipartws.core
  :target-path "target/%s"
  :resource-paths ["src/main/resource"] 

  :profiles {:uberjar {:aot :all}})
