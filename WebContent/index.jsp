<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>手机应用测试</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jQuery/themes/metro/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jQuery/themes/mobile.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jQuery/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/jQuery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jQuery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jQuery/jquery.easyui.mobile.js"></script>
    <script type="text/javascript">
        $(document).ready(function (){
            $.ajax({
                type : 'get',
                url : 'http://localhost:8080/RestApp/get/4E6FC96D-FC3D-4DF5-B394-9364CA324897',
                dataType: 'jsonp',
                success : function(json) {
                	var s = '<div class="m-title">'+json['roleName']+'</div>';
                    $('.m-toolbar').append(s);                
                },
                error:function() {
                	alert('fail');
                }
            });
        });
</script>

</head>
<body>

	<div class="easyui-navpanel" style="padding:10px">
		<header>
			<div class="m-toolbar">
			</div>
		</header>
		<ul class="easyui-tree" data-options="animate:true">
			<li>
				<span>我的手机</span>
				<ul>
					<li data-options="state:'closed'">
						<span>照片</span>
						<ul>
							<li>张三</li>
							<li>李四</li>
							<li>王武</li>
							<li>赵六</li>
						</ul>
					</li>
					<li>
						<span>文件</span>
						<ul>
							<li>Java</li>
							<li>JavaScript</li>
							<li>Scrum</li>
							<li>IOS</li>
						</ul>
					</li>
					<li>索引</li>
					<li>关于</li>
					<li>欢迎页</li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>