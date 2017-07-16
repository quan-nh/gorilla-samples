;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit ctrl+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns enigmatic-brook
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [gorilla-graph.core :as graph]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn- read-csv [f]
  (with-open [reader (io/reader (io/resource f))]
	(doall
      (let [[header & data] (csv/read-csv reader)
            header-kw (map keyword header)]
        (map #(zipmap header-kw %) data)))))

(def nodes (read-csv "history/nodes.csv"))
(def edges (read-csv "history/edges.csv"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;enigmatic-brook/edges</span>","value":"#'enigmatic-brook/edges"}
;; <=

;; @@
(graph/view
    {:nodes nodes :edges edges}
    ;; Options
    #_{:nodes {:shape "image"}})
;; @@
;; =>
;;; {"type":"html","content":"<div id='eda7d1ff-9e58-4257-acbe-978fe046f060'></div>\n<script type='text/javascript'>\n$(function () {\n  var cachedScript = function(url, options) {\n    // Allow user to set any option except for dataType, cache, and url\n    options = $.extend( options || {}, {\n      dataType: 'script',\n      cache: true,\n      url: url\n    });\n    // Use $.ajax() since it is more flexible than $.getScript\n    // Return the jqXHR object so we can chain callbacks\n    return jQuery.ajax(options);\n  };\n  var createNetwork = function() {\n    // create an array with nodes\n    var nodes = new vis.DataSet([{\"id\":\"Nguyễn Nhạc\",\"label\":\"Nguyễn Nhạc\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/4/4c/NguyenNhac.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Nguyễn Huệ\",\"label\":\"Nguyễn Huệ\",\"image\":\"http://vietnamdefence.com/web/Uploaded/vnd/20091014/QTrung-cd2.gif\",\"group\":\"Tây Sơn\"},{\"id\":\"Nguyễn Lữ\",\"label\":\"Nguyễn Lữ\",\"image\":\"https://upload.wikimedia.org/wikipedia/vi/thumb/3/3c/NguyenLu.jpg/174px-NguyenLu.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Nguyễn Ánh\",\"label\":\"Nguyễn Ánh\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/8/86/Emperor_Gia_Long.jpg\",\"group\":\"nhà Nguyễn\"}]);\n\n    // create an array with edges\n    var edges = new vis.DataSet([{\"from\":\"Nguyễn Huệ\",\"to\":\"Nguyễn Nhạc\",\"label\":\"anh-em\"},{\"from\":\"Nguyễn Huệ\",\"to\":\"Nguyễn Lữ\",\"label\":\"anh-em\"},{\"from\":\"Nguyễn Huệ\",\"to\":\"Nguyễn Ánh\",\"label\":\"ke-thu\"}]);\n\n    // create a network\n    var container = document.getElementById('eda7d1ff-9e58-4257-acbe-978fe046f060');\n\n    // provide the data in the vis format\n    var data = {nodes: nodes, edges: edges};\n    var options = {\"width\":\"600px\",\"height\":\"400px\"};\n\n    // initialize your network!\n    var network = new vis.Network(container, data, options);\n  };\n  if (!document.getElementById('vis-css')) {\n    $('<link>')\n      .attr('rel', 'stylesheet')\n      .attr('href', 'https://cdnjs.cloudflare.com/ajax/libs/vis/4.20.0/vis.min.css')\n      .attr('id', 'vis-css')\n      .appendTo('head');\n  }\n  if (!window.visJsLoaded) {\n    if (!window.visJsIsLoading) {\n      window.visJsLoadedCallbacks = [createNetwork];\n      window.visJsIsLoading = true;\n      cachedScript('https://cdnjs.cloudflare.com/ajax/libs/vis/4.20.0/vis.min.js')\n        .done(function() {\n          window.visJsIsLoading = false;\n          window.visJsLoaded = true;\n          _.each(window.visJsLoadedCallbacks, function(cb) { cb(); });\n          window.visJsLoadedCallbacks = [];\n        })\n        .fail(function() { console.log('failed'); });\n    } else {\n      window.visJsLoadedCallbacks.push(createNetwork);\n    }\n  } else {\n    createNetwork();\n  }\n});\n</script>","value":"#gorilla_graph.core.GraphView{:graph-data {:nodes ({:id \"Nguyễn Nhạc\", :label \"Nguyễn Nhạc\", :image \"https://upload.wikimedia.org/wikipedia/commons/4/4c/NguyenNhac.jpg\", :group \"Tây Sơn\"} {:id \"Nguyễn Huệ\", :label \"Nguyễn Huệ\", :image \"http://vietnamdefence.com/web/Uploaded/vnd/20091014/QTrung-cd2.gif\", :group \"Tây Sơn\"} {:id \"Nguyễn Lữ\", :label \"Nguyễn Lữ\", :image \"https://upload.wikimedia.org/wikipedia/vi/thumb/3/3c/NguyenLu.jpg/174px-NguyenLu.jpg\", :group \"Tây Sơn\"} {:id \"Nguyễn Ánh\", :label \"Nguyễn Ánh\", :image \"https://upload.wikimedia.org/wikipedia/commons/8/86/Emperor_Gia_Long.jpg\", :group \"nhà Nguyễn\"}), :edges ({:from \"Nguyễn Huệ\", :to \"Nguyễn Nhạc\", :label \"anh-em\"} {:from \"Nguyễn Huệ\", :to \"Nguyễn Lữ\", :label \"anh-em\"} {:from \"Nguyễn Huệ\", :to \"Nguyễn Ánh\", :label \"ke-thu\"})}, :options {}}"}
;; <=

;; @@

;; @@
