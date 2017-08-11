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
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .table td, .table th{ padding:0px;text-align:center;vertical-align:middle;}
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="${ctx}/assets/css/jquery-confirm.css?22" rel="stylesheet" />
    <script src="${ctx}/assets/js/jquery-confirm.js?11"></script>
</head>
<body>
<!-- <div class="input-group" style="width:50%;margin:0 auto;margin-top:20px;">
    <input  type="text"  id="no" maxlength="3"  placeholder="请输入1-3位的数字编号 " class="form-control input-lg" onkeyup="this.value=this.value.replace(/\D/g,'')" />
    <input type="text" id="customer" class="form-control input-lg" placeholder="请输入客户" style="margin-top:20px;"/>
</div> -->
<div class="input-group" style="width:50%;margin:0 auto;margin-top:20px;">
    <input type="text" id="productName" value="" onblur="queryData()" class="form-control input-lg" placeholder="请输入款号" />
    <span class="input-group-btn">
       <button class="btn btn-info btn-search" onclick="queryData()">搜索</button>
    </span>
</div>
<table class="table table-bordered" id="productTable" style="margin-top:20px;"></table>
<div class="modal-footer" id="addBtn"></div>
<input type="hidden" id="pdtId" value="" >
<input type="hidden" id="accessToken" value="${param.accessToken}" >
<script>
    var objJson = [];
    //查询颜色尺寸矩阵
    function queryData(){
        $.ajax({
            type:'post',
            url:'${ctx}/product/queryColorSizeList',
            data:{'accessToken':$('#accessToken').val(),'productName':$("#productName").val()},
            cache:false,
            dataType:'json',
            success:function(data){
                console.log(data);
                var result = data.data;
                var html = "<thead><tr><th>#</th>";
                for(var i = 0;i<result.sizeList.length;i++){
                    html += "<th>"+result.sizeList[i].value+"</th>";
                }
                html += "</tr></thead><tbody>";
                for(var i = 0;i<result.colorList.length;i++){
                    html += "<tr><th scope='row'>"+result.colorList[i].value1Code+"</th>";
                    for(var j = 0;j<result.sizeList.length;j++){
                        html += '<td><input type="text" onblur="changeData(this);" cl="'+result.colorList[i].colorId+'" sz="'+result.sizeList[j].sizeId+'" x="'+j+'" y="'+i+'" class="form-control"></td>';
                    }
                    html += "</tr>";
                }
                html += "</tbody>";
                $("#productTable").html(html);
                html ='<button class="btn btn-success" onclick="save()">保存订单</button>'+
                        '&nbsp;&nbsp;<button class="btn" onclick="location.reload();">重新填写</button>';
                $("#addBtn").html(html);
                $("#pdtId").val(result.mProductId);
            }
        });
    }
    //修改矩阵数量
    function changeData(inp){
        if(inp){
            //var x=parseInt($(inp).attr("x"),10);
            //var y=parseInt($(inp).attr("y"),10);
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
    //保存下单
    function save(){
        console.log(eval(objJson));
        if(objJson.length == 0){
            $.alert({
                title: '警告！',
                content: "请输入数量！",
                closeIcon: true,
                animationSpeed: 200,
                type:'red'
            });
            return;
        }
        jQuery.post("${ctx}/productApprove/tableApproveSave",{accessToken:$('#accessToken').val(),pdtId:$("#pdtId").val(),productName:$("#productName").val(),jgNo:$("#customer").val(),itemDatas:JSON.stringify(objJson)},function(data){
            if(data.success){
                $.alert({
                    title: '恭喜！',
                    content: "数据保存成功！",
                    theme: 'dark'
                });
                $("#pdtId").val("");
                $("#productName").val("");
                //$("#customer").val("");
                //$("#no").val("");
                $("#productTable :input[type='text']").each(function(i){
                    this.value = "";
                });
                objJson = {};
            }else{
                //alert(data.msg);
                $.dialog({
                    title: '警告!',
                    content: data.msg,
                    type:'red'
                });
            }
        });
    }
</script>
</body>
</html>
