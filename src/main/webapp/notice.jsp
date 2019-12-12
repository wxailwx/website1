<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/12/11
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>notice</title>
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
        </div>
    </div>
    <div class="layui-body">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
            <li class="layui-nav-item layui-this"><a href="hospital.jsp">医院</a></li>
            <li class="layui-nav-item"><a href="doctor.jsp">医生</a></li>
            <li class="layui-nav-item"><a href="facultyDetail.jsp">科室</a></li>
            <li class="layui-nav-item"><a href="notice.jsp">医学小贴士</a></li>
        </ul>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset3">
                <input type="text" name="notice-name" placeholder="请输相关疾病名" value="" id="search-notice" size="50px" style="height: 40px">
                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="notice" lay-filter="test"></table>
            </div>
        </div>
    </div>
    <div class="layui-side layui-bg-black">
        <img src="img/img1.jpg" sizes="100%">
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
    table.render({
        elem:'#notice'
        ,id:'table1'
        ,height:315
        ,width:700
        ,url:"findTip.action"
        ,cols:[[
            {field:'id',title:'id',width:50}
            ,{field:'name',title:'标题名',width:150}
            ,{field:'tip',title:'贴士',width:500}
        ]]
        ,page:true
        ,method:'post'
    });
    var $ = layui.$;
    $('#search').on('click',function () {
        //console.log("11");
        var send_name = $('#search-notice').val();
        if(send_name != null)
            table.reload('table1',{
                method:'post'
                ,where:{
                    'name':send_name
                }
            })
    });
</script>
</body>
</html>
