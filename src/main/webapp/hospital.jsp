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
            <li class="layui-nav-item"><a href="facultyDetail.jsp">科室</a></li>
            <li class="layui-nav-item"><a href="notice.jsp">医学小贴士</a></li>
            <li class="layui-nav-item"><a href="favorit.jsp">收藏</a></li>
        </ul>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="hospital" lay-filter="test"></table>
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
    var $ = layui.$;
    //执行渲染
    table.render({
        elem: '#hospital' //指定原始表格元素选择器（推荐id选择器）
        ,id:'table'
        ,height: 315 //容器高度
        ,width:950
        ,url:"Hospital.action"
        ,where:{
            'name':$('#search-hospital').val()||''
        }
        ,cols: [[
            {field:'id',title:'id',width:50}
            ,{field:'name',title:'医院名',width:200}
            ,{field:'address',title:'医院地址',width:200}
            ,{field:'city',title:'城市',width:100}
            ,{field:'class1',title:'医院等级',width:100}
            ,{field:'introduction',title:'医院简介',width:150}
            ,{fixed: 'right', width:150, align:'center', toolbar: '#bar2'}
        ]] //设置表头
        ,page:true
        ,method:"POST"
    });
    $('#search').on('click',function () {
        console.log("22");
        var send_name = $('#search-hospital').val();
        table.reload('table',{
            method:'post'
            ,where:{
                'name':send_name
            }
        })
    });
    table.on('tool(test)', function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
        console.log(data.id);
        var id=data.id;
        var userid =<%=session.getAttribute("userid")%>
        if(userid === null){
            alert("请先注册或登陆！");
        }else {
            $.ajax({
                url:"insertUserFavHos.action",
                type:"post",
                data:{
                    'HID':id,
                    'userid':userid
                },
                success:function (m) {
                    if(m===true){
                        console.log("收藏成功！");
                        table.reload('table',{
                            method:'post',
                            where:{
                                'userid':userid
                            }
                        })
                    }
                }
            })
        }
    });
</script>
<script type="text/html" id="bar2">
    <a class="layui-btn layui-btn-xs" lay-event="add">收藏</a>
</script>
</body>
</html>
