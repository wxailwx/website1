<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ҽ��ƽ̨</title>
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
                <span style="font-size: 30px;color: red;"><i class="layui-icon layui-icon-face-smile"> ҽ��ƽ̨</i></span>
            </div>
            <div class="layui-col-md5">
                <input type="text" name="hospital-name" placeholder="������ҽԺ����" value="" id="search-hospital" size="40px" style="height: 40px">
                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>
            </div>
            <div class="layui-col-md5">
                <a class="dropdown-toggle" href="login.html">
                    <i class="ace-icon fa fa-tasks"></i>
                    <span>��½&ע��</span>
                </a>
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    <img class="nav-user-photo" src="img/user.jpg" alt="Jason's Photo" />
                    <span class="user-info" id="welcome">
                <small>Welcome</small><%if (session.getAttribute("username")==null){%>�ο�<%}else{%><%=session.getAttribute("username")%><%}%>
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
            <li class="layui-nav-item"><a href="index.jsp">��ҳ</a></li>
            <li class="layui-nav-item"><a href="hospital.jsp">ҽԺ</a></li>
            <li class="layui-nav-item"><a href="doctor.jsp">ҽ��</a></li>
            <li class="layui-nav-item"><a href="facultyDetail.jsp">����</a></li>
            <li class="layui-nav-item"><a href="notice.jsp">ҽѧС��ʿ</a></li>
            <li class="layui-nav-item"><a href="favorit.jsp">�ղ�</a></li>
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
    //����ģ�鶼һ���Լ��أ���˲���ִ�� layui.use() �����ض�Ӧģ�飬ֱ��ʹ�ü��ɣ�
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
        elem: '#hospital' //ָ��ԭʼ���Ԫ��ѡ�������Ƽ�idѡ������
        ,height: 315 //�����߶�
        ,width:950
        ,id:'table'
        ,url:"Hospital.action"
        ,where:{
            'name':$('#search-hospital').val()||''
        }
        ,cols: [[
            {field:'id',title:'id',width:50}
            ,{field:'name',title:'ҽԺ��',width:200}
            ,{field:'address',title:'ҽԺ��ַ',width:200}
            ,{field:'city',title:'����',width:100}
            ,{field:'class1',title:'ҽԺ�ȼ�',width:100}
            ,{field:'introduction',title:'ҽԺ���',width:150}
            ,{fixed: 'right', width:150, align:'center', toolbar: '#bar2'}
        ]] //���ñ�ͷ
        ,page:true
        ,method:"post"
    });
    table.on('tool(test1)', function(obj){
        var data = obj.data; //��õ�ǰ������
        var layEvent = obj.event; //��� lay-event ��Ӧ��ֵ��Ҳ�����Ǳ�ͷ�� event ������Ӧ��ֵ��
        var tr = obj.tr; //��õ�ǰ�� tr �� DOM ��������еĻ���
        console.log(data.id);
        var id=data.id;
        var userid =<%=session.getAttribute("userid")%>
        if(userid === null){
            alert("����ע����½��");
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
                        console.log("�ղسɹ���");
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
            ,{field:'name',title:'ҽ����',width:100}
            ,{field:'faculty',title:'����',width:200}
            ,{field:'profession',title:'ְ��',width:200}
            ,{fixed: 'right', width:150, align:'center', toolbar: '#bar'}
        ]]
        ,page:true
        ,method:'post'
    });
    table11.on('tool(test2)', function(obj){
        var data = obj.data; //��õ�ǰ������
        var layEvent = obj.event; //��� lay-event ��Ӧ��ֵ��Ҳ�����Ǳ�ͷ�� event ������Ӧ��ֵ��
        var tr = obj.tr; //��õ�ǰ�� tr �� DOM ��������еĻ���
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
                    var s = '���:'+m.description;
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
                alert("���ȵ�½");
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
                            console.log("��ӳɹ�");
                    }
                })
            }
        }
    });
</script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="detail">�鿴</a>
    <a class="layui-btn layui-btn-xs" lay-event="add">�ղ�</a>
</script>
<script type="text/html" id="bar2">
    <a class="layui-btn layui-btn-xs" lay-event="add">�ղ�</a>
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
            ,{field:'name',title:'������',width:100}
            ,{field:'class1',title:'����',width:100}
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