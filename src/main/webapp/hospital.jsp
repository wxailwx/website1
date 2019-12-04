<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/12/4
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hospital</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="layui/layui.all.js">
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-layout-admin">
    <div class="layui-header layui-bg-blue">
        <div class="layui-row">
            <div class="layui-col-md-offset1 layui-col-md3">
                <i class="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #1E9FFF;"></i>
                <span style="font-size: 30px;color: red;"><i class="layui-icon layui-icon-face-smile"> 医疗平台</i></span>
            </div>
            <div class="layui-col-md-offset5 ">
                <input type="text" name="hospital-name" placeholder="请输入医院名称" value="" id="search-hospital" size="50px" style="height: 40px">
                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>
            </div>
        </div>
    </div>
    <div class="layui-body">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
            <li class="layui-nav-item layui-this"><a href="hospital.jsp">医院</a></li>
            <li class="layui-nav-item"><a href="doctor.jsp">医生</a></li>
        </ul>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="hospital" lay-filter="test"></table>
            </div>
        </div>
    </div>
    <div class="layui-side layui-bg-black">
        <img src="img/logo.jpg" sizes="50px">
    </div>
</div>
<script src="layui/layui.all.js"></script>
<script>
    //由于模块都一次性加载，因此不用执行 layui.use() 来加载对应模块，直接使用即可：
    !function(){
        var layer = layui.layer
            ,form = layui.form;
    }();
</script>
<script>
    var table = layui.table;

    //执行渲染
    table.render({
        elem: '#hospital' //指定原始表格元素选择器（推荐id选择器）
        ,height: 315 //容器高度
        ,width:800
        ,url:"Hospital.action"
        ,cols: [[
            {field:'name',title:'医院名',width:200}
            ,{field:'address',title:'医院地址',width:200}
            ,{field:'class1',title:'医院等级',width:100}
            ,{field:'introduction',title:'医院简介',width:300}
        ]] //设置表头
        ,page:true
        ,method:"POST"
    });
</script>
</body>
</html>
