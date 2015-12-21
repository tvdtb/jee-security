<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html class="">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>login </title>
	<link href="static/main.css" rel="stylesheet" type="text/css">
	
	<meta http-equiv="refresh" content="0; URL=<c:out value='${param.referrer}'/>">
</head>
<body>

<div class="container">
	<div class="header">
		<img src="static/logo.png" alt="logo" class="header-logo">
		<h1 class="header-title">JEE login</h1>
	</div>
	<div class="main">

			<h2 class="main-title main-title-bold">Hallo, Sie sind angemeldet!</h2>
			<h2 class="main-title main-title-bold">Wir leiten Sie weiter ...</h2>
			<h2 class="main-title main-title-bold"><c:out value='${param.referrer}'/></h2>

			<noscript>&lt;p&gt;Your browser does not support JavaScript, you won't be able to use this website.&lt;/p&gt;</noscript>

	</div>
</div>

</body></html>