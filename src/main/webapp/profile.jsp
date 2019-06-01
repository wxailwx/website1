<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>用户信息界面</title>

		<meta name="description" content="3 styles with inline editable feature" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="wx/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="wx/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="wx/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="wx/assets/css/jquery.gritter.min.css" />
		<link rel="stylesheet" href="wx/assets/css/select2.min.css" />
		<link rel="stylesheet" href="wx/assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="wx/assets/css/bootstrap-editable.min.css" />

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

	<body class="no-skin">
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
							<%--              <li>--%>
							<%--              <a href="#">--%>
							<%--                <i class="ace-icon fa fa-cog"></i>--%>
							<%--                Settings--%>
							<%--              </a>--%>
							<%--            </li>--%>

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
	<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							
							<li>
								<a href="index.jsp">主页面</a>
							</li>
							<li class="active">用户信息</li>
						</ul><!-- /.breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">

						<!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="hr dotted"></div>

								<div>
									<div id="user-profile-1" class="user-profile row">
										<div class="col-xs-12 col-sm-3 center">
											<div>
												<span class="profile-picture">
													<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="wx/assets/images/avatars/profile-pic.jpg" />
												</span>

												<div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
													<div class="inline position-relative">
														<a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
															<i class="ace-icon fa fa-circle light-green"></i>
															&nbsp;
															<span class="white">
																<%if (session.getAttribute("username")==null){%>
																游客
																<%}else{%>
																<%=session.getAttribute("username")%>
																<%}%>
															</span>
														</a>

														
													</div>
												</div>
											</div>

											<div class="space-6"></div>

											<div class="profile-contact-info">
												<div class="profile-contact-links align-left">
													

													<a href="#" class="btn btn-link">
														<i class="ace-icon fa fa-envelope bigger-120 pink"></i>
														私信
													</a>

													
												</div>

												<div class="space-6"></div>

												<div class="profile-social-links align-center">
													<a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
														<i class="middle ace-icon fa fa-facebook-square fa-2x blue"></i>
													</a>

													<a href="#" class="tooltip-info" title="" data-original-title="Visit my Twitter">
														<i class="middle ace-icon fa fa-twitter-square fa-2x light-blue"></i>
													</a>

													<a href="#" class="tooltip-error" title="" data-original-title="Visit my Pinterest">
														<i class="middle ace-icon fa fa-pinterest-square fa-2x red"></i>
													</a>
												</div>
											</div>

											<div class="hr hr12 dotted"></div>

								

											<div class="hr hr16 dotted"></div>
										</div>

										<div class="col-xs-12 col-sm-9">
										

											<div class="space-12"></div>

											<div class="profile-user-info profile-user-info-striped">
												<div class="profile-info-row">
													<div class="profile-info-name"> 姓名 </div>

													<div class="profile-info-value">
														<span class="editable" id="username">
															<%if (session.getAttribute("username")==null){%>
																游客
																<%}else{%>
																<%=session.getAttribute("username")%>
																<%}%>
														</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> 加入社区时间 </div>

													<div class="profile-info-value">
														<span class="editable" id="date">
															<%if (session.getAttribute("username")!=null){%>
															<%=session.getAttribute("date")%>
															<%}%>
														</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name"> 邮箱 </div>
													<div class="profile-info-value">
														<span class="editable" id="email">
															<%if (session.getAttribute("username")!=null){%>
															<%=session.getAttribute("email")%>
															<%}%>
														</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name"> 学院 </div>
													<div class="profile-info-value">
														<span class="editable" id="college">
															<%if (session.getAttribute("username")!=null){%>
															<%=session.getAttribute("college")%>
															<%}%>
														</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name"> 密码 </div>
													<div class="profile-info-value">
														<span class="editable" id="password">
															<%if (session.getAttribute("username")!=null){%>
															<%=session.getAttribute("password")%>
															<%}%>
														</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name"> 提交更新 </div>
													<div class="profile-info-value">
														<button class="btn btn-info" type="button" id="submit">
															<i class="ace-icon fa fa-check bigger-110"></i>
															Submit
														</button>
<%--														<button class="btn" type="reset">--%>
<%--															<i class="ace-icon fa fa-undo bigger-110"></i>--%>
<%--															Reset--%>
<%--														</button>--%>
													</div>
												</div>
											</div>

											<div class="space-20"></div>

											<div class="hr hr2 hr-double"></div>

											<div class="space-6"></div>

											<div class="center"> </div>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

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
		<script src="wx/assets/js/jquery.gritter.min.js"></script>
		<script src="wx/assets/js/bootbox.js"></script>
		<script src="wx/assets/js/jquery.easypiechart.min.js"></script>
		<script src="wx/assets/js/bootstrap-datepicker.min.js"></script>
		<script src="wx/assets/js/jquery.hotkeys.index.min.js"></script>
		<script src="wx/assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="wx/assets/js/select2.min.js"></script>
		<script src="wx/assets/js/spinbox.min.js"></script>
		<script src="wx/assets/js/bootstrap-editable.min.js"></script>
		<script src="wx/assets/js/ace-editable.min.js"></script>
		<script src="wx/assets/js/jquery.maskedinput.min.js"></script>

		<!-- ace scripts -->
		<script src="wx/assets/js/ace-elements.min.js"></script>
		<script src="wx/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			
				//editables on first profile page
				$.fn.editable.defaults.mode = 'inline';
				$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
			    $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'+
			                                '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';
				//text editable
			    $('#username')
				.editable({
					type: 'text',
					name: 'username'		
			    });

			    $('#email').editable({
					type:"text",
					name:'email'
				});
				$('#college').editable({
					type:"text",
					name:'college'
				});
				//custom date editable
				$('#date').editable({
					type: 'adate',
					date: {
						//datepicker plugin options
						    format: 'yyyy/mm/dd',
						viewformat: 'yyyy/mm/dd',
						 weekStart: 1
						 
						//,nativeUI: true//if true and browser support input[type=date], native browser control will be used
						//,format: 'yyyy-mm-dd',
						//viewformat: 'yyyy-mm-dd'
					}
				});

				$('#password').editable({
					type:"password",
					name:'password'
				});
				// *** editable avatar *** //
				try {//ie8 throws some harmless exceptions, so let's catch'em
			
					//first let's add a fake appendChild method for Image element for browsers that have a problem with this
					//because editable plugin calls appendChild, and it causes errors on IE at unpredicted points
					try {
						document.createElement('IMG').appendChild(document.createElement('B'));
					} catch(e) {
						Image.prototype.appendChild = function(el){}
					}
			
					var last_gritter
					$('#avatar').editable({
						type: 'image',
						name: 'avatar',
						value: null,
						//onblur: 'ignore',  //don't reset or hide editable onblur?!
						image: {
							//specify ace file input plugin's options here
							btn_choose: 'Change Avatar',
							droppable: true,
							maxSize: 110000,//~100Kb
			
							//and a few extra ones here
							name: 'avatar',//put the field name here as well, will be used inside the custom plugin
							on_error : function(error_type) {//on_error function will be called when the selected file has a problem
								if(last_gritter) $.gritter.remove(last_gritter);
								if(error_type == 1) {//file format error
									last_gritter = $.gritter.add({
										title: 'File is not an image!',
										text: 'Please choose a jpg|gif|png image!',
										class_name: 'gritter-error gritter-center'
									});
								} else if(error_type == 2) {//file size rror
									last_gritter = $.gritter.add({
										title: 'File too big!',
										text: 'Image size should not exceed 100Kb!',
										class_name: 'gritter-error gritter-center'
									});
								}
								else {//other error
								}
							},
							on_success : function() {
								$.gritter.removeAll();
							}
						},
					    url: function(params) {
							// ***UPDATE AVATAR HERE*** //
							//for a working upload example you can replace the contents of this function with 
							//examples/profile-avatar-update.js
			
							var deferred = new $.Deferred
			
							var value = $('#avatar').next().find('input[type=hidden]:eq(0)').val();
							if(!value || value.length == 0) {
								deferred.resolve();
								return deferred.promise();
							}
			
			
							//dummy upload
							setTimeout(function(){
								if("FileReader" in window) {
									//for browsers that have a thumbnail of selected image
									var thumb = $('#avatar').next().find('img').data('thumb');
									if(thumb) $('#avatar').get(0).src = thumb;
								}
								
								deferred.resolve({'status':'OK'});
			
								if(last_gritter) $.gritter.remove(last_gritter);
								last_gritter = $.gritter.add({
									title: 'Avatar Updated!',
									text: 'Uploading to server can be easily implemented. A working example is included with the template.',
									class_name: 'gritter-info gritter-center'
								});
								
							 } , parseInt(Math.random() * 800 + 800))
			
							return deferred.promise();
							
							// ***END OF UPDATE AVATAR HERE*** //
						},
						
						success: function(response, newValue) {
						}
					})
				}catch(e) {}
				
				/**
				//let's display edit mode by default?
				var blank_image = true;//somehow you determine if image is initially blank or not, or you just want to display file input at first
				if(blank_image) {
					$('#avatar').editable('show').on('hidden', function(e, reason) {
						if(reason == 'onblur') {
							$('#avatar').editable('show');
							return;
						}
						$('#avatar').off('hidden');
					})
				}
				*/

				//////////////////////////////
				$('#profile-feed-1').ace_scroll({
					height: '250px',
					mouseWheelLock: true,
					alwaysVisible : true
				});
			
				$('a[ data-original-title]').tooltip();
			});
		</script>
	<script type="text/javascript" src="js/profile.js"></script>
	</body>
</html>
