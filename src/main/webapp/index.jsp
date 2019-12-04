<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ҽ��ƽ̨</title>
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
                <span style="font-size: 30px;color: red;"><i class="layui-icon layui-icon-face-smile"> ҽ��ƽ̨</i></span>
            </div>
            <div class="layui-col-md-offset5 ">
                <input type="text" name="hospital-name" placeholder="������ҽԺ����" value="" id="search-hospital" size="50px" style="height: 40px">
                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> </button>
            </div>
        </div>
    </div>
    <div class="layui-body">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="index.jsp">��ҳ</a></li>
            <li class="layui-nav-item layui-this"><a href="hospital.jsp">ҽԺ</a></li>
            <li class="layui-nav-item"><a href="doctor.jsp">ҽ��</a></li>
        </ul>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset2">
                <table id="hospital" lay-filter="test"></table>
            </div>
        </div>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset3">
                <table id="doctor" lay-filter="test"></table>
            </div>
        </div>
        <hr class="layui-bg-green">
        <div class="layui-row">
            <div class="layui-col-md-offset4">
                <table id="fauclty" lay-filter="test"></table>
            </div>
        </div>
    </div>
    <div class="layui-side layui-bg-black">
        <img src="img/logo.jpg" sizes="50px">
    </div>
</div>

<script src="layui/layui.all.js"></script>
<script>
    //����ģ�鶼һ���Լ��أ���˲���ִ�� layui.use() �����ض�Ӧģ�飬ֱ��ʹ�ü��ɣ�
    !function(){
        var layer = layui.layer
            ,form = layui.form;
    }();
</script>
<script>
    var table = layui.table;
    table.render({
        elem: '#hospital' //ָ��ԭʼ���Ԫ��ѡ�������Ƽ�idѡ������
        ,height: 315 //�����߶�
        ,width:800
        ,id:'table'
        ,url:"Hospital.action"
        ,cols: [[
            {field:'name',title:'ҽԺ��',width:200}
            ,{field:'address',title:'ҽԺ��ַ',width:200}
            ,{field:'class1',title:'ҽԺ�ȼ�',width:100}
            ,{field:'introduction',title:'ҽԺ���',width:300}
        ]] //���ñ�ͷ
        ,page:true
        ,method:"POST"
    });
</script>
<script>
    var $ = layui.$;
    $('#search').on('click',function () {
        console.log("22");
        var send_name = $('#search-hospital').val();
        table11.reload('table',{
            method:'post'
            ,where:{
                'name':send_name
            }
        })
    })
</script>
<script>
    var table11 = layui.table;
    table11.render({
       elem:'#doctor'
        ,height:315
        ,width:300
        ,url:"DoctorName.action"
        ,cols:[[
            {field:'name',title:'ҽ����',width:100}
            ,{field:'profession',title:'ְ��',width:200}
        ]]
        ,page:true
        ,method:'POST'
    });
</script>
<script>
    var table2 = layui.table;
    table2.render({
        elem:'#fauclty'
        ,height:315
        ,width:200
        ,cols:[[
            {field:'name',title:'������',width:100}
            ,{field:'level',title:'����',width:100}
        ]]
        ,page:true
    })
</script>
</body>
</html>