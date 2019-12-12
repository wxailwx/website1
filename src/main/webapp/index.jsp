<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>医疗平台</title>
    <meta charset="UTF-8">
    <link rel="script" href="layui/layui.all.js">
    <link rel="stylesheet" href="layui/css/layui.css">
<%--    BOOTSTRAP && font-awesome--%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/ace-ie.min.css">
    <link rel="stylesheet" href="css/ace-part2.min.css">
    <link rel="stylesheet" href="css/ace-rtl.min.css">
    <link rel="stylesheet" href="css/ace-skins.min.css">
    <link rel="stylesheet" href="css/ace.min.css">
</head>
<body>
<div class="layui-layout-admin">
    <div class="layui-header layui-bg-blue">
        <div class="layui-row">
            <div class="layui-col-md2">
                <i class="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #1E9FFF;"></i>
                <span style="font-size: 30px;color: red;"><i class="layui-icon layui-icon-face-smile"> 医疗平台</i></span>
            </div>
            <div class="layui-col-md5">
                <input type="text" name="hospital-name" placeholder="请输入医院名称" value="" id="search-hospital" size="40px" style="height: 40px">
                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>
            </div>
            <div class="layui-col-md5">
                <a class="dropdown-toggle" href="login.html">
                    <i class="ace-icon fa fa-tasks"></i>
                    <span>登陆&注册</span>
                </a>
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    <img class="nav-user-photo" src="img/user.jpg" alt="Jason's Photo" />
                    <span class="user-info" id="welcome">
                <small>Welcome</small><%if (session.getAttribute("username")==null){%>游客<%}else{%><%=session.getAttribute("username")%><%}%>
              </span><i class="ace-icon fa fa-caret-down"></i></a>
                <ul class="user-menu dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                    <li>
                        <a href="profile.jsp" >
                            <i class="ace-icon fa fa-user"></i>
                            Profile
                        </a>
                    </li>
                    <li>
                        <a href="#" id="logout">
                            <i class="ace-icon fa fa-power-off"></i>
                            Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="layui-body">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
            <li class="layui-nav-item"><a href="hospital.jsp">医院</a></li>
            <li class="layui-nav-item"><a href="doctor.jsp">医生</a></li>
            <li class="layui-nav-item"><a href="facultyDetail.jsp">科室</a></li>
            <li class="layui-nav-item"><a href="notice.jsp">医学小贴士</a></li>
            <li class="layui-nav-item"><a href="favorit.jsp">收藏</a></li>
        </ul>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="hospital" lay-filter="test1"></table>
            </div>
        </div>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset3">
                <table id="doctor" lay-filter="test2"></table>
            </div>
        </div>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset4">
                <table id="fauclty" lay-filter="test3"></table>
            </div>
        </div>
    </div>
    <div class="layui-side layui-bg-gray">
        <img src="img/img1.jpg" sizes="100%">
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="layui/layui.all.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/ace.min.js"></script>
<script src="js/ace-elements.min.js"></script>
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
    //var name = $('#search-hospital').val();
    //console.log(name);
    table.render({
        elem: '#hospital' //指定原始表格元素选择器（推荐id选择器）
        ,height: 315 //容器高度
        ,width:950
        ,id:'table'
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
        ,method:"post"
    });
    table.on('tool(test1)', function(obj){
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
<script>
    var $ = layui.$;
    $('#search').on('click',function () {
        console.log("22");
        //var send_name = $('#search-hospital').val();
        table11.reload('table',{
            method:'post'
            ,where:{
                'name':$('#search-hospital').val()||''
            }
        })
    })
</script>
<script>
    var table11 = layui.table;
    table11.render({
       elem:'#doctor'
        ,height:315
        ,width:500
        ,url:"DoctorName.action"
        ,cols:[[
            {field:'id',title:'id',width:50}
            ,{field:'name',title:'医生名',width:100}
            ,{field:'faculty',title:'科室',width:200}
            ,{field:'profession',title:'职称',width:200}
            ,{fixed: 'right', width:150, align:'center', toolbar: '#bar'}
        ]]
        ,page:true
        ,method:'post'
    });
    table11.on('tool(test2)', function(obj){
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
        else if (layEvent === 'add'){
            var userid =<%=session.getAttribute("userid")%>
            if(userid === null){
                alert("请先登陆");
            }else {
                $.ajax({
                    url:"insertUserFavDoc.action",
                    type:"post",
                    data:{
                        'userid':userid,
                        'DID':id
                    },
                    success:function (m) {
                        if (m)
                            console.log("添加成功");
                    }
                })
            }
        }
    });
</script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="add">收藏</a>
</script>
<script type="text/html" id="bar2">
    <a class="layui-btn layui-btn-xs" lay-event="add">收藏</a>
</script>
<script>
    var table2 = layui.table;
    table2.render({
        elem:'#fauclty'
        ,height:315
        ,width:250
        ,url:"findOffice.action"
        ,cols:[[
            {field:'id',title:'id',width:50}
            ,{field:'name',title:'科室名',width:100}
            ,{field:'class1',title:'级别',width:100}
        ]]
        ,page:true
        ,method:'POST'
    });
</script>
<script>
    // var $ = layui.$;
    // $(".layui-nav-item li").click(function () {
    //     $(this).siblings().removeClass('layui-this');
    //     $(this).addClass('layui-this');
    // });
    // $(".layui-nav").render();
</script>
</body>
</html>