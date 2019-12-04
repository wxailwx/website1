<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/12/3
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
            <div class="layui-col-md-offset3">
                <input type="text" name="hospital-name" placeholder="请输医生名称" value="" id="search-doctor" size="50px" style="height: 40px">
                <button id="search1" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="doctor" lay-filter="test"></table>
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
    var table11 = layui.table;
    table11.render({
        elem:'#doctor'
        ,height:315
        ,width:300
        ,id:'table1'
        ,url:"DoctorName.action"
        ,cols:[[
            {field:'name',title:'医生名',width:100}
            ,{field:'profession',title:'职称',width:200}
        ]]
        ,page:true
        ,method:'POST'
    });
    var $ = layui.$;
    $('#search1').on('click',function () {
        console.log("11");
        var send_name = $('#search-doctor').val();
        table11.reload('table1',{
            method:'post'
            ,where:{
                'name':send_name
            }
        })
    })

</script>
</body>
</html>
