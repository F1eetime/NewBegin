<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + path + "/";
%>
<html>
<head>
    <style>
        #mydiv {
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -200px;
            margin-top: -200px;
        }

        .mouseOver {
            background: #708090;
            color: #FFFAFA;
        }

        .mouseOut {
            background: #FFFAFA;
            color: #323360;
        }
    </style>
</head>
<script src=""></script>
<body>
<div id="mydiv">
    <input type="text" size="50" id="keywords" onkeyup="getTips()" onblur="tipsBlur()" onfocus="getTips()">
    <input type="button" value="百度一下，你就知道" width="50px">
    <div id="popTips">
        <table id="content_table" bgcolor="#FFFAFA" border="0" cellpadding="0" cellspacing="0">
            <tbody id="content_table_body">

            </tbody>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">
    function getTips() {
        var comment = document.getElementById('keywords');
        if (comment.value == '') {
            return;
        }
        xmlHttp = createXMLHttp();

        var url = "search?keyword=" + escape(comment.value);
        xmlHttp.open("GET", url, true);
        xmlHttp.onreadystatechange = callback;
        xmlHttp.send(null);
    }

    function callback() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                var result = xmlHttp.responseText;
                var json = eval("(" + result + ")");
                setTips(json);
            }
        }
    }

    function createXMLHttp() {
        var XMLHttp;
        if (window.XMLHttpRequest) {
            XMLHttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            XMLHttp = new ActiveXObject('Microsoft.XMLHTTP');
            if (!XMLHttp) {
                XMLHttp = new ActiveXObject('Msxml2.XMLHTTP');
            }
        }
        return XMLHttp;
    }

    function setTips(comment) {
        clearTips();
        setLocation();
        var size = comment.length;
        if (size == 0) {
            clearTips();
        } else {
            for (var i = 0; i < size; i++) {
                var nextNode = comment[i];
                var tr = document.createElement('tr');
                var td = document.createElement('td');
                td.setAttribute('border', '0');
                td.setAttribute('bgcolor', '#FFFAFA');
                td.onmouseover = function () {
                    this.className = 'mouseOver';
                };
                td.onmouseout = function () {
                    this.className = 'mouseOut';
                };
                td.onclick = function () {
                    var comment1 = this.innerText;
                    document.getElementById("keywords").value = comment1;
                };
                var text = document.createTextNode(nextNode);
                td.appendChild(text);
                tr.appendChild(td);
                document.getElementById('content_table_body').appendChild(tr);
            }
        }
    }

    function clearTips() {
        /*var comment = document.getElementById("content_table_body");
        var size = comment.childNodes.length;
        for (var i = size -1; i >= 0; i--){
            comment.removeChild(comment.childNodes[i]);
        }*/
        document.getElementById("content_table_body").innerHTML = "";

        document.getElementById("popTips").style.border = "none";
    }

    function tipsBlur() {
        setTimeout(clearTips, 200);
    }

    function setLocation() {
        var content = document.getElementById("keywords");
        var width = content.offsetWidth;
        var left = content["offsetLeft"];
        var top = content["offsetTop"] + content.offsetHeight;
        var popTips = document.getElementById("popTips");
        popTips.style.border = "black 1px solid";
        popTips.style.left = left + "px";
        popTips.style.top = top + "px";
        popTips.style.width = width + "px";
        document.getElementById("content_table").style.width = width + "px";
    }
</script>
</html>
