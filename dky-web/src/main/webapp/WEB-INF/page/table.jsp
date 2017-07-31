<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Pragma" contect="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>大货下单</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <%--<link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="http://cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">--%>
    <%--<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>--%>

    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/animate.css/3.5.2/animate.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body style="">
<h3 style="text-align: center !important;">大货款下单</h3>
<div class="input-group" style="width: 100%">
    <input type="text" id="productName" value="16-A008" class="form-control"placeholder="请输入款号" />
    <span class="input-group-btn">
       <button class="btn btn-info btn-search" onclick="queryData()">搜索</button>
    </span>
</div>
<table class="table table-bordered" id="productTable">

</table>

<script>
    function queryData(){
        $.ajax({
            type:'post',
            url:'${ctx}/product/queryColorSizeList',
            data:{'productName':$("#productName").val()},
            cache:false,
            dataType:'json',
            success:function(data){
                console.log(data);
                var html = "<thead><tr><th>#</th>";
                for(var i = 0;i<data.data.sizeList.length;i++){
                    html += "<th>"+data.data.sizeList[i]+"</th>";
                }
                html += "</tr></thead><tbody>";
                for(var i = 0;i<data.data.colorList.length;i++){
                    html += "<tr><th scope='row'>"+data.data.colorList[i]+"</th>";
                    for(var j = 0;j<data.data.sizeList.length;j++){
                        html += '<td><input type="text" class="form-control"></td>';
                    }
                    html += "</tr>";
                }
                html += "</tbody>";
                $("#productTable").html(html);
            }
        });
    }
</script>
</body>
</html>
