<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>校园周边主页</title>
  <link rel="stylesheet" type="text/css" href="res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <script type="text/javascript" src="res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
  <meta name="description" content="overview &amp; stats" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
  <!-- bootstrap & fontawesome -->
  <link rel="stylesheet" href="wx/assets/css/bootstrap.min.css" />
  <link rel="stylesheet" href="wx/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
  <!-- page specific plugin styles -->
  <!-- text fonts -->
  <link rel="stylesheet" href="wx/assets/css/fonts.googleapis.com.css" />
  <!-- ace styles -->
  <link rel="stylesheet" href="wx/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
  <!--[if lte IE 9]>
  <link rel="stylesheet" href="wx/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
  <![endif]-->
  <link rel="stylesheet" href="wx/assets/css/ace-skins.min.css" />
  <link rel="stylesheet" href="wx/assets/css/ace-rtl.min.css" />
  <!--[if lte IE 9]>
  <link rel="stylesheet" href="wx/assets/css/ace-ie.min.css" />
  <![endif]-->
  <!-- inline styles related to this page -->
  <!-- ace settings handler -->
  <script src="wx/assets/js/ace-extra.min.js"></script>
  <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
  <!--[if lte IE 8]>
  <script src="wx/assets/js/html5shiv.min.js"></script>
  <script src="wx/assets/js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
  <div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
      <div class="navbar-header pull-left">
        <a href="index.jsp" class="navbar-brand">
          <small>
            <i class="fa fa-leaf"></i>
            首页
          </small>
        </a>
      </div>
      <div class="navbar-buttons navbar-header pull-right" role="navigation">
        <ul class="nav ace-nav">
          <li class="grey dropdown-modal">
          <a class="dropdown-toggle" href="login.html">
            <i class="ace-icon fa fa-tasks"></i>
            <span>登陆&注册</span>
          </a>
          </li>
          <li class="purple dropdown-modal">
          <a  class="dropdown-toggle" href="contactus2.html">
            <i class="ace-icon fa fa-bell icon-animated-bell"></i>
            <span>联系我们</span>
          </a>
        </li>
          <li class="light-blue dropdown-modal">
            <a data-toggle="dropdown" href="#" class="dropdown-toggle">
              <img class="nav-user-photo" src="wx/assets/images/avatars/user.jpg" alt="Jason's Photo" />
              <span class="user-info" id="welcome">
                <small>Welcome</small>
                <%if (session.getAttribute("username")==null){%>
                游客
                <%}else{%>
                <%=session.getAttribute("username")%>
                <%}%>
              </span>
              <i class="ace-icon fa fa-caret-down"></i>
            </a>
            <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
              <li>
              <a href="profile.jsp" >
                <i class="ace-icon fa fa-user"></i>
                Profile
              </a>
            </li>
              <li class="divider"></li>
              <li>
              <a href="#" id="logout">
                <i class="ace-icon fa fa-power-off"></i>
                Logout
              </a>
            </li>
            </ul>
          </li>
        </ul>
    </div>
    </div><!-- /.navbar-container -->
  </div>
  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="校园经济平台">
            <img src="res/static/img/sculogo.png">
          </a>
        </h1>
        <div class="mallSearch">
          <form action="" class="layui-form" novalidate>
            <input id="shopname" type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入店铺名称">
            <button type="button" id="search" class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
<!--            <input type="hidden" name="" value="">-->
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="content content-nav-base commodity-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="#" class="active">所有商品</a>
            <a href="#">可扩充部分</a>
          </div>
        </div>
      </div>
    </div>
    <div class="commod-cont-wrap">
      <div class="commod-cont w1200 layui-clear">
        <div class="left-nav">
          <div class="title">所有分类</div>
          <div class="list-box">
            <dl>
             <dt>美食</dt>
             <dd><a href="javascript:">火锅</a></dd>
             <dd><a href="javascript:">自助</a></dd>
             <dd><a href="javascript:">家常菜</a></dd>
			 <dd><a href="javascript:">烧烤</a></dd>
            </dl>
            <dl>
             <dt>休闲娱乐</dt>
             <dd><a href="javascript:">酒吧</a></dd>
             <dd><a href="javascript:">KTV</a></dd>
             <dd><a href="javascript:">轰趴馆</a></dd>
             <dd><a href="javascript:">影院</a></dd>
             <dd><a href="javascript:">网吧/网咖</a></dd>
            </dl>
            <dl>
             <dt>酒店住宿</dt>
             <dd><a href="javascript:">经济型</a></dd>
             <dd><a href="javascript:">舒适/三星</a></dd>
             <dd><a href="javascript:">豪华/四星/五星</a></dd>
            </dl>
            <dl>
             <dt>生活服务</dt>
             <dd><a href="javascript:">美发/美容</a></dd>
             <dd><a href="javascript:">运动/健身</a></dd>
             <dd><a href="javascript:">培训</a></dd>
            </dl>
            <dl>
             <dt>其他</dt>
             <dd><a href="javascript:">医院</a></dd>
             <dd><a href="javascript:">药店</a></dd>
             <dd><a href="javascript:">驾校</a></dd>
            </dl>
          </div>
        </div>
        <div class="right-cont-wrap">
          <div class="right-cont">
            <div class="sort layui-clear">
              <a class="active" href="javascript:" event = 'volume'>销量</a>
              <a href="javascript:" event = 'price'>价格</a>
              <a href="javascript:" event = 'newprod'>新品</a>
              <a href="javascript:" event = 'collection'>收藏</a>
            </div>
<!--            <div class="prod-number">-->
<!--              <span>200个</span>-->
<!--            </div>-->
            <div class="cont-list layui-clear" id="list-cont">
            </div>
            <!-- 模版引擎导入 -->
            <script type="text/html" id="demo">
              {{# layui.each(d,function(index,item){}}
                <div class="item">
                  <div class="img">
                    <a href="javascript:" id="{{item.id}}" onclick="jump(this.id)">
                      <img src="{{item.picture}}" width="280px" height="280px">
                    </a>
                  </div>
                  <div class="text">
                    <p class="title">{{item.shopname}}</p>
                    <p class="price">
                      <span class="pri">人均价格{{item.price}}</span>
                      <span class="nub">已评价人数{{item.people}}</span>
                    </p>
                  </div>
                </div>
              {{# }); }}
            </script>
            <div id="demo0" style="text-align: center;"></div>
          </div>
        </div>
      </div>
    </div>
  </div>


<!--[if !IE]> -->
<script src="wx/assets/js/jquery-2.1.4.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="wx/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
  if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="wx/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="wx/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="wx/assets/js/jquery-ui.custom.min.js"></script>
<script src="wx/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="wx/assets/js/jquery.easypiechart.min.js"></script>
<script src="wx/assets/js/jquery.sparkline.index.min.js"></script>
<script src="wx/assets/js/jquery.flot.min.js"></script>
<script src="wx/assets/js/jquery.flot.pie.min.js"></script>
<script src="wx/assets/js/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="wx/assets/js/ace-elements.min.js"></script>
<script src="wx/assets/js/ace.min.js"></script>
  <script src="js/jquerysession.js"></script>
  <script>
    function jump(id) {
      window.location.href="shopimf3.jsp?id="+id;
    }
  </script>
<script>

  layui.config({
    base: 'res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage','jquery'],function(){
      var laypage = layui.laypage,$ = layui.$,
     mm = layui.mm;
       laypage.render({
        elem: 'demo0'
        ,count: 100 //数据总数
      });
    var num={};
    num.type=1;
    // 模版引擎导入
    var html = demo.innerHTML;
    var listCont = document.getElementById('list-cont');

    $.ajax({
        url:"shops.action",
        type:"post",
        async:false,
        data:num,
        success:function (res) {
          listCont.innerHTML=mm.renderHtml(html,res);
        },
        error:function (res) {
          console.log(res);
        }
    });
    $('.sort a').on('click',function(){
      $(this).addClass('active').siblings().removeClass('active');
    });
    $('.list-box dt').on('click',function(){
      if($(this).attr('off')){
        $(this).removeClass('active').siblings('dd').show()
        $(this).attr('off','')
      }else{
        $(this).addClass('active').siblings('dd').hide()
        $(this).attr('off',true)
      }
    });
    $('#search').click(function () {
      var shop={};
      shop.shopname=$('#shopname').val();
      console.log(shop.shopname);
      $.ajax({
        url:"searchshop.action",
        type:"post",
        data:shop,
        success:function (res) {
          console.log("2");
          listCont.innerHTML=mm.renderHtml(html,res);
        },
        error:function (res) {
          console.log(res);
        }
      });
    });
    $('#logout').click(function () {
      $.ajax({
        url:"logout.action",
        success:function () {
          console.log("success!");
          location.reload();
        },
        error:function (res) {
          console.log(res);
        }
      });
    });
});
</script>
</body>
</html>