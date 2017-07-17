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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;enigmatic-brook/read-csv</span>","value":"#'enigmatic-brook/read-csv"}
;; <=

;; @@
(def nodes (read-csv "history/nodes.csv"))
(def edges (read-csv "history/edges.csv"))

(graph/view
    {:nodes nodes :edges edges}
    ;; Options
    {;:nodes {:shape "image"}
     :edges {:arrows "to"}})
;; @@
;; =>
;;; {"type":"html","content":"<div id='2f1ad965-19a0-4d54-8d86-986e26a3a674'></div>\n<script type='text/javascript'>\n$(function () {\n  var cachedScript = function(url, options) {\n    // Allow user to set any option except for dataType, cache, and url\n    options = $.extend( options || {}, {\n      dataType: 'script',\n      cache: true,\n      url: url\n    });\n    // Use $.ajax() since it is more flexible than $.getScript\n    // Return the jqXHR object so we can chain callbacks\n    return jQuery.ajax(options);\n  };\n  var createNetwork = function() {\n    // create an array with nodes\n    var nodes = new vis.DataSet([{\"id\":\"Nguyễn Nhạc\",\"label\":\"Nguyễn Nhạc\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/4/4c/NguyenNhac.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Quang Trung\",\"label\":\"Quang Trung\",\"image\":\"http://vietnamdefence.com/web/Uploaded/vnd/20091014/QTrung-cd2.gif\",\"group\":\"Tây Sơn\"},{\"id\":\"Nguyễn Lữ\",\"label\":\"Nguyễn Lữ\",\"image\":\"https://upload.wikimedia.org/wikipedia/vi/thumb/3/3c/NguyenLu.jpg/174px-NguyenLu.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Gia Long\",\"label\":\"Gia Long\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/8/86/Emperor_Gia_Long.jpg\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Thừa Thiên\",\"label\":\"Thừa Thiên\",\"image\":\"\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Hoàng tử Cảnh\",\"label\":\"Hoàng tử Cảnh\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Prince_Canh_MEP.jpg/154px-Prince_Canh_MEP.jpg\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Thuận Thiên\",\"label\":\"Thuận Thiên\",\"image\":\"\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Minh Mạng\",\"label\":\"Minh Mạng\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Minh_Mang.gif/154px-Minh_Mang.gif\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Nguyễn Phúc Đài\",\"label\":\"Nguyễn Phúc Đài\",\"image\":\"\",\"group\":\"nhà Nguyễn\"}]);\n\n    // create an array with edges\n    var edges = new vis.DataSet([{\"from\":\"Nguyễn Nhạc\",\"to\":\"Quang Trung\",\"label\":\"anh em\"},{\"from\":\"Quang Trung\",\"to\":\"Nguyễn Lữ\",\"label\":\"anh em\"},{\"from\":\"Quang Trung\",\"to\":\"Gia Long\",\"label\":\"kẻ thù\",\"arrows\":\"from, to\"},{\"from\":\"Gia Long\",\"to\":\"Thừa Thiên\",\"label\":\"hoàng hậu\"},{\"from\":\"Thừa Thiên\",\"to\":\"Hoàng tử Cảnh\",\"label\":\"mẹ con\"},{\"from\":\"Gia Long\",\"to\":\"Thuận Thiên\",\"label\":\"hoàng hậu\"},{\"from\":\"Thuận Thiên\",\"to\":\"Minh Mạng\",\"label\":\"mẹ con\"},{\"from\":\"Thuận Thiên\",\"to\":\"Nguyễn Phúc Đài\",\"label\":\"mẹ con\"}]);\n\n    // create a network\n    var container = document.getElementById('2f1ad965-19a0-4d54-8d86-986e26a3a674');\n\n    // provide the data in the vis format\n    var data = {nodes: nodes, edges: edges};\n    var options = {\"width\":\"600px\",\"height\":\"400px\",\"edges\":{\"arrows\":\"to\"}};\n\n    // initialize your network!\n    var network = new vis.Network(container, data, options);\n  };\n  if (!document.getElementById('vis-css')) {\n    $('<link>')\n      .attr('rel', 'stylesheet')\n      .attr('href', 'https://cdnjs.cloudflare.com/ajax/libs/vis/4.20.0/vis.min.css')\n      .attr('id', 'vis-css')\n      .appendTo('head');\n  }\n  if (!window.visJsLoaded) {\n    if (!window.visJsIsLoading) {\n      window.visJsLoadedCallbacks = [createNetwork];\n      window.visJsIsLoading = true;\n      cachedScript('https://cdnjs.cloudflare.com/ajax/libs/vis/4.20.0/vis.min.js')\n        .done(function() {\n          window.visJsIsLoading = false;\n          window.visJsLoaded = true;\n          _.each(window.visJsLoadedCallbacks, function(cb) { cb(); });\n          window.visJsLoadedCallbacks = [];\n        })\n        .fail(function() { console.log('failed'); });\n    } else {\n      window.visJsLoadedCallbacks.push(createNetwork);\n    }\n  } else {\n    createNetwork();\n  }\n});\n</script>","value":-411473135}
;; <=
