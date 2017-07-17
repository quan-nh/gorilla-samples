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
     :edges {:arrows "to"}
     :width  "900px"
     :height "800px"})
;; @@
;; =>
;;; {"type":"html","content":"<div id='c5c0e751-f16c-42f0-9062-67bee64e8349'></div>\n<script type='text/javascript'>\n$(function () {\n  var cachedScript = function(url, options) {\n    // Allow user to set any option except for dataType, cache, and url\n    options = $.extend( options || {}, {\n      dataType: 'script',\n      cache: true,\n      url: url\n    });\n    // Use $.ajax() since it is more flexible than $.getScript\n    // Return the jqXHR object so we can chain callbacks\n    return jQuery.ajax(options);\n  };\n  var createNetwork = function() {\n    // create an array with nodes\n    var nodes = new vis.DataSet([{\"id\":\"Nguyễn Nhạc\",\"label\":\"Nguyễn Nhạc\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/4/4c/NguyenNhac.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Quang Trung\",\"label\":\"Quang Trung\",\"image\":\"http://vietnamdefence.com/web/Uploaded/vnd/20091014/QTrung-cd2.gif\",\"group\":\"Tây Sơn\"},{\"id\":\"Nguyễn Lữ\",\"label\":\"Nguyễn Lữ\",\"image\":\"https://upload.wikimedia.org/wikipedia/vi/thumb/3/3c/NguyenLu.jpg/174px-NguyenLu.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Trần Quang Diệu\",\"label\":\"Trần Quang Diệu\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Bùi Thị Xuân\",\"label\":\"Bùi Thị Xuân\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Ngô Thì Nhậm\",\"label\":\"Ngô Thì Nhậm\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Ngô Thì Sĩ\",\"label\":\"Ngô Thì Sĩ\",\"image\":\"\",\"group\":\"Lê\"},{\"id\":\"Phan Huy Ích\",\"label\":\"Phan Huy Ích\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/5/5a/Phan_Huy_%C3%8Dch_%281751_-_1822%29.jpg\",\"group\":\"Tây Sơn\"},{\"id\":\"Ngô Văn Sở\",\"label\":\"Ngô Văn Sở\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Vũ Văn Dũng\",\"label\":\"Vũ Văn Dũng\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Trần Văn Kỷ\",\"label\":\"Trần Văn Kỷ\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Nguyễn Hữu Chỉnh\",\"label\":\"Nguyễn Hữu Chỉnh\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Vũ Văn Nhậm\",\"label\":\"Vũ Văn Nhậm\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Bùi Đắc Tuyên\",\"label\":\"Bùi Đắc Tuyên\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Bùi Thị Nhạn\",\"label\":\"Bùi Thị Nhạn\",\"image\":\"\",\"group\":\"Tây Sơn\"},{\"id\":\"Quang Toản\",\"label\":\"Quang Toản\",\"image\":\"Tây Sơn\"},{\"id\":\"Gia Long\",\"label\":\"Gia Long\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/8/86/Emperor_Gia_Long.jpg\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Thừa Thiên\",\"label\":\"Thừa Thiên\",\"image\":\"\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Hoàng tử Cảnh\",\"label\":\"Hoàng tử Cảnh\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Prince_Canh_MEP.jpg/154px-Prince_Canh_MEP.jpg\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Thuận Thiên\",\"label\":\"Thuận Thiên\",\"image\":\"\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Minh Mạng\",\"label\":\"Minh Mạng\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Minh_Mang.gif/154px-Minh_Mang.gif\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Nguyễn Phúc Đài\",\"label\":\"Nguyễn Phúc Đài\",\"image\":\"\",\"group\":\"nhà Nguyễn\"},{\"id\":\"Đặng Trần Thường\",\"label\":\"Đặng Trần Thường\",\"image\":\"\",\"group\":\"nhà Nguyễn\"}]);\n\n    // create an array with edges\n    var edges = new vis.DataSet([{\"from\":\"Nguyễn Nhạc\",\"to\":\"Quang Trung\",\"label\":\"anh em\"},{\"from\":\"Quang Trung\",\"to\":\"Nguyễn Lữ\",\"label\":\"anh em\"},{\"from\":\"Quang Trung\",\"to\":\"Trần Quang Diệu\",\"label\":\"boss\"},{\"from\":\"Quang Trung\",\"to\":\"Bùi Thị Xuân\",\"label\":\"boss\"},{\"from\":\"Trần Quang Diệu\",\"to\":\"Bùi Thị Xuân\",\"label\":\"vợ chồng\"},{\"from\":\"Gia Long\",\"to\":\"Trần Quang Diệu\",\"label\":\"kill\"},{\"from\":\"Gia Long\",\"to\":\"Bùi Thị Xuân\",\"label\":\"kill\"},{\"from\":\"Quang Trung\",\"to\":\"Ngô Thì Nhậm\",\"label\":\"boss\"},{\"from\":\"Ngô Thì Sĩ\",\"to\":\"Ngô Thì Nhậm\",\"label\":\"cha con\"},{\"from\":\"Quang Trung\",\"to\":\"Phan Huy Ích\",\"label\":\"boss\"},{\"from\":\"Ngô Thì Sĩ\",\"to\":\"Phan Huy Ích\",\"label\":\"bố vợ\"},{\"from\":\"Quang Trung\",\"to\":\"Ngô Văn Sở\",\"label\":\"boss\"},{\"from\":\"Quang Trung\",\"to\":\"Vũ Văn Dũng\",\"label\":\"boss\"},{\"from\":\"Vũ Văn Dũng\",\"to\":\"Ngô Văn Sở\",\"label\":\"kill\"},{\"from\":\"Gia Long\",\"to\":\"Vũ Văn Dũng\",\"label\":\"kill\"},{\"from\":\"Quang Trung\",\"to\":\"Trần Văn Kỷ\",\"label\":\"boss\"},{\"from\":\"Gia Long\",\"to\":\"Trần Văn Kỷ\",\"label\":\"kill\"},{\"from\":\"Vũ Văn Nhậm\",\"to\":\"Nguyễn Hữu Chỉnh\",\"label\":\"kill\"},{\"from\":\"Quang Trung\",\"to\":\"Vũ Văn Nhậm\",\"label\":\"kill\"},{\"from\":\"Nguyễn Nhạc\",\"to\":\"Vũ Văn Nhậm\",\"label\":\"bố vợ\"},{\"from\":\"Bùi Đắc Tuyên\",\"to\":\"Bùi Thị Nhạn\",\"label\":\"anh em\"},{\"from\":\"Quang Trung\",\"to\":\"Bùi Thị Nhạn\",\"label\":\"hoàng hậu\"},{\"from\":\"Bùi Thị Nhạn\",\"to\":\"Quang Toản\",\"label\":\"mẹ con\"},{\"from\":\"Gia Long\",\"to\":\"Quang Toản\",\"label\":\"kill\"},{\"from\":\"Vũ Văn Dũng\",\"to\":\"Bùi Đắc Tuyên\",\"label\":\"kill\"},{\"from\":\"Quang Trung\",\"to\":\"Gia Long\",\"label\":\"kẻ thù\",\"arrows\":\"from, to\"},{\"from\":\"Gia Long\",\"to\":\"Thừa Thiên\",\"label\":\"hoàng hậu\"},{\"from\":\"Thừa Thiên\",\"to\":\"Hoàng tử Cảnh\",\"label\":\"mẹ con\"},{\"from\":\"Gia Long\",\"to\":\"Thuận Thiên\",\"label\":\"hoàng hậu\"},{\"from\":\"Thuận Thiên\",\"to\":\"Minh Mạng\",\"label\":\"mẹ con\"},{\"from\":\"Thuận Thiên\",\"to\":\"Nguyễn Phúc Đài\",\"label\":\"mẹ con\"},{\"from\":\"Gia Long\",\"to\":\"Đặng Trần Thường\",\"label\":\"boss\"},{\"from\":\"Đặng Trần Thường\",\"to\":\"Ngô Thì Nhậm\",\"label\":\"kill\"}]);\n\n    // create a network\n    var container = document.getElementById('c5c0e751-f16c-42f0-9062-67bee64e8349');\n\n    // provide the data in the vis format\n    var data = {nodes: nodes, edges: edges};\n    var options = {\"width\":\"900px\",\"height\":\"800px\",\"edges\":{\"arrows\":\"to\"}};\n\n    // initialize your network!\n    var network = new vis.Network(container, data, options);\n  };\n  if (!document.getElementById('vis-css')) {\n    $('<link>')\n      .attr('rel', 'stylesheet')\n      .attr('href', 'https://cdnjs.cloudflare.com/ajax/libs/vis/4.20.0/vis.min.css')\n      .attr('id', 'vis-css')\n      .appendTo('head');\n  }\n  if (!window.visJsLoaded) {\n    if (!window.visJsIsLoading) {\n      window.visJsLoadedCallbacks = [createNetwork];\n      window.visJsIsLoading = true;\n      cachedScript('https://cdnjs.cloudflare.com/ajax/libs/vis/4.20.0/vis.min.js')\n        .done(function() {\n          window.visJsIsLoading = false;\n          window.visJsLoaded = true;\n          _.each(window.visJsLoadedCallbacks, function(cb) { cb(); });\n          window.visJsLoadedCallbacks = [];\n        })\n        .fail(function() { console.log('failed'); });\n    } else {\n      window.visJsLoadedCallbacks.push(createNetwork);\n    }\n  } else {\n    createNetwork();\n  }\n});\n</script>","value":-2130982971}
;; <=

;; @@

;; @@
