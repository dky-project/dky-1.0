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
    <style type="text/css">
        .table td, .table th{ padding:0px;text-align:center;vertical-align:middle;}
    </style>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body style="">
<div class="input-group" style="width:50%;margin:0 auto;margin-top:20px;">
    <input type="text" id="productName" value="16-A008" class="form-control input-lg" placeholder="请输入款号" />
    <span class="input-group-btn">
       <button class="btn btn-info btn-search" onclick="queryData()">搜索</button>
    </span>
</div>
<table class="table table-bordered" id="productTable" style="margin-top:20px;">

</table>
<div class="modal-footer" id="addBtn"></div>
<script>
    var objJson = [];
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
                        html += '<td><input type="text" onblur="changeData(this);" cl="'+data.data.colorList[i]+'" sz="'+data.data.sizeList[j]+'" x="'+j+'" y="'+i+'" class="form-control"></td>';
                    }
                    html += "</tr>";
                }
                html += "</tbody>";
                $("#productTable").html(html);
                html ='<button class="btn btn-success" onclick="queryData()">保存订单</button>'+
                        '&nbsp;&nbsp;<button class="btn" onclick="queryData()">重新填写</button>';
                $("#addBtn").html(html);
            }
        });
    }
    function changeData(inp){
        if(inp){
            var x=parseInt($(inp).attr("x"),10);
            var y=parseInt($(inp).attr("y"),10);
            var cl=$(inp).attr("cl");
            var sz=$(inp).attr("sz");
            var count=parseInt($(inp).val(),10);
            count=isNaN(count)?0:count;
            if(objJson.length == 0){
                objJson.push(eval('({"color":"' + cl + '","size":"' + sz + '","num":' + count + '})'));
                return;
            }
            for(var i=0;i<objJson.length;i++){
                if(objJson[i].color==cl&&objJson[i].size==sz){
                    objJson[i].num = count;
                    break;
                }else{
                    objJson.push(eval('({"color":"' + cl + '","size":"' + sz + '","num":' + count + '})'));
                    break;
                }
            }
        }
    }
    function save(){
    			jQuery("#loadingToast").css("display","block");
    			console.log(eval(cell_datas));
    			jQuery.post("${ctx}/product/queryColorSizeList",{pdtId:$("#pdtId").val(),itemdatas:JSON.stringify(cell_datas)},function(data){
    				jQuery("#loadingToast").css("display","none");
    				var result = eval("(" + data + ")");
    				if(result.isSuccess){
    					alert('数据保存成功!!!');
    					$("#pdtId").val("");
    					$("#productValue").val("");
    					$("#customer").val("");
    					$("#num").val("");
    					window.location.reload();
    				}else{
    					alert(result.message);
    				}
    			});
    		}
</script>
</body>
</html>
