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
<%--            <div class="layui-col-md-offset5 ">--%>
<%--                <input type="text" name="hospital-name" placeholder="请输入医院名称" value="" id="search-hospital" size="50px" style="height: 40px">--%>
<%--                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>--%>
<%--            </div>--%>
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
    table11.render({
        elem:'#doctor'
        ,id:'table1'
        ,height:315
        ,width:700
        ,url:"DoctorName.action"
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
    $('#search1').on('click',function () {
        console.log("11");
        var send_name = $('#search-doctor').val();
        if(send_name != null)
        table11.reload('table1',{
            method:'post'
            ,where:{
                'name':send_name
            }
        })
    });
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
</body>
</html>
