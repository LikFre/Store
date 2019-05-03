<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
	d = new dTree('d');
	d.add('01',-1,'系统菜单树');
	//1.当前节点的id,2.父节点id,3.节点上的文字,4.跳转路径,5.当鼠标移动在节点上时提示信息
	//6.要跳转的frameset框架
	d.add('0102','01','分类管理','','','mainFrame');
	d.add('010201','0102','分类管理','${pageContext.request.contextPath}/category_adminFind.action','','mainFrame');
	d.add('0104','01','商品管理');
	d.add('010401','0104','商品管理','${pageContext.request.contextPath}/product_adminFind.action?num=1','','mainFrame');
	d.add('010402','0104','已下架商品管理','${pageContext.request.contextPath}/product_adminFindByPflag.action','','mainFrame');
	d.add('0105','01','订单管理');
	d.add('010501','0105','订单管理','${pageContext.request.contextPath}/order_adminFind.action','','mainFrame');
	d.add('010502','0105','未付款的订单','${pageContext.request.contextPath}/order_adminFind.action?state=1','','mainFrame');
	d.add('010503','0105','已付款订单','${pageContext.request.contextPath}/order_adminFind.action?state=2','','mainFrame');
	d.add('010504','0105','已发货的订单','${pageContext.request.contextPath}/order_adminFind.action?state=3','','mainFrame');
	d.add('010505','0105','已完成的订单','${pageContext.request.contextPath}/order_adminFind.action?state=4','','mainFrame');
	
	d.add('0106','01','用户管理');
	d.add('010601','0106','普通用户管理','${pageContext.request.contextPath}/User_adminFind.action','','mainFrame');
	d.add('010602','0106','管理员账户','${pageContext.request.contextPath}/User_adminFind.action','','mainFrame');
	
	document.write(d);
	
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
