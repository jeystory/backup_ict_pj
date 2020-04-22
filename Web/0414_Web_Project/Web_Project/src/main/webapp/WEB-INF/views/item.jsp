<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dessert Menu</title>
<link rel = "stylesheet"  href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script> 
<script type="text/javascript">
    
</script> 

<style type="text/css">
	.item_title{
		width:100%;
		margin:10px 0 3px 0; 
		text-align:center;
		font-size : 14px;
		color : black;
	}
	.item_price, .item_spec{
		width:100%;
		margin:0 0 10px 0; 
		text-align:center;
		font-size:12px;
		color: black;
	}
	
	ul.item_body {
  		list-style-type: none;
  		margin: 10px;
  		padding: 5px;
  		background-color: white;
  		
	}
	
	.item_body li{
		display:inline-block;
	}
	
	.item_body li img {
		width : 400px;
		height : 350px;
	}
	
</style>

</head>
<body>
 
 <%@ include file="menu_main.jsp"%>
	<hr>
 	
 	
		<div  align = "center">
		   	<ul class = "item_body">  
		   		<c:forEach var="k" items="${itemlist}" varStatus="vs">
		   			<li>
        			<a href="item_sub_detail.do?idx=${k.idx}">
          			<img src="resources/images/items/${k.file_name}">
                    <div class = "item_title">${k.item_name }</div>
                    <div class = "item_spec">${k.item_spec }</div>
                    <div class = "item_price">${k.item_price }</div> </a>
      			</li>
		   		
		   		</c:forEach>    

      		</ul>
      		
      		<hr>
      	</div>
      	
      	<div align="center">
      		<a href = #>[1]</a>
      	</div>
            
        		
	<%@ include file="bottom.jsp"%>
	
	
</body>
</html>