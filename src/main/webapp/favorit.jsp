<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2019/12/12
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏的医生或医院</title>
    <meta charset="UTF-8">
    <link rel="script" href="layui/layui.all.js">
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
            <li class="layui-nav-item"><a href="favorit.jsp">收藏</a></li>
        </ul>
        <hr class="layui-bg-green">
        <span>
            <%if (session.getAttribute("username")==null){%>游客,请先登陆或注册再使用收藏功能<%}else{%><%=session.getAttribute("username")%><%}%>
        </span>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="doctor" lay-filter="test"></table>
            </div>
        </div>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="hospital" lay-filter="test1"></table>
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
    var table11 = layui.table;
    var userid = <%=session.getAttribute("userid")%>
    table11.render({
        elem:'#doctor'
        ,id:'table1'
        ,height:315
        ,width:700
        ,url:"findUserFavDoc.action"
        ,where:{
            'userid':userid
        }
        ,cols:[[
            {field:'id',title:'id',width:50}
            ,{field:'name',title:'医生名',width:100}
            ,{field:'faculty',title:'科室',width:200}
            ,{field:'profession',title:'职称',width:200}
            ,{fixed: 'right', width:150, align:'center', toolbar: '#bar'}
        ]]
        ,page:true
        ,method:'POST'
    });
    var $ = layui.$;
    table11.on('tool(test)', function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
        console.log(data.id);
        var id=data.id;
        if (layEvent === 'detail'){
            $.ajax({
                url:"DoctorDetail.action",
                type:"post",
                data:{
                    'id':id
                },
                success:function (m) {
                    console.log(m.name);
                    var s = '简介:'+m.description;
                    var layer = layui.layer;
                    layer.open({
                        type:0,
                        title:m.name,
                        content:s
                    })
                }
            })
        }
        else if(layEvent === 'del'){
            $.ajax({
                url:"deleteUserFavDoc.action",
                type:"post",
                data:{
                    'DID':id,
                    'userid':userid
                },
                success:function (m) {
                    if(m===true){
                        console.log("删除成功！");
                        table11.reload('table1',{
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
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    var table = layui.table;
    var userid =<%=session.getAttribute("userid")%>
    var $ = layui.$;
    //执行渲染
    table.render({
        elem: '#hospital' //指定原始表格元素选择器（推荐id选择器）
        ,id:'table'
        ,height: 315 //容器高度
        ,width:950
        ,url:"findUserFavHos.action"
        ,where:{
            'userid':userid
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
    table.on('tool(test1)', function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
        console.log(data.id);
        var id=data.id;
        $.ajax({
            url:"deleteUserFavHos.action",
            type:"post",
            data:{
                'HID':id,
                'userid':userid
            },
            success:function (m) {
                if(m===true){
                    console.log("删除成功！");
                    table.reload('table',{
                        method:'post',
                        where:{
                            'userid':userid
                        }
                    })
                }
            }
        })
    });
</script>
<script type="text/html" id="bar2">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
