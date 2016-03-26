<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<style>
			.box{width:1000px;height:200px;margin:100px auto;text-align: center;}
			.box select{width:200px;height:30px;}
		</style>
		<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="box">
			省份：<select id="province" onchange="changeCity(this.value)"></select>
			城市：<select id="city" onchange="changeArea(this.value)"><option value=''>--请选择城市--</option></select>
			区域：<select id="area"><option value=''>--请选择区域--</option></select>
		</div>
	</body>
	<script type="text/javascript">
		//封装
		function getHtml(id,data,mes){
			var html = "<option value=''>--请选择"+mes+"--</option>";
			for(var i=0;i<data.length;i++){
				html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
			}
			$("#"+id).html(html);
		};
		
	/* //在json文件中查询出province
		function loadProvince(){
			$.get("json/province.json",function(data){
				getHtml("province",data,"省份");
			});
		};
		loadProvince(); */
		
		//在后台查询出province
		function loadProvince(){
			$.get("Province",function(data){
				//第一种方式  ie678不支持
				var json = JSON.parse(data);
				//第二种方式  都支持但性能差
				//var json = eval("("+data+")");
				getHtml("province",json,"省份");
			});
		};
		loadProvince();
		
		
		//加载城市
		function changeCity(pid){
			if(!pid)return;
			//避免再次选择省份时区域不改变的问题
			$("#area").html("<option value=''>--请选择区域--</option>");
			$.ajax({
				type:"post",
				data:{pid:pid},
				url:"city",
				success:function(data){
					//第一种方式  ie678不支持
					var json = JSON.parse(data);
					//第二种方式  都支持但性能差
					//var json = eval("("+data+")");
					getHtml("city",json,"城市");
				}
			});
		};
		//加载区域
		function changeArea(cid){
			if(!cid)return;
			$.ajax({
				type:"post",
				data:{cid:cid},
				url:"area",
				success:function(data){
					//第一种方式  ie678不支持
					var json = JSON.parse(data);
					//第二种方式  都支持但性能差
					//var json = eval("("+data+")");
					getHtml("area",json,"区域");
				}
			});
		};
	</script>
</html>

