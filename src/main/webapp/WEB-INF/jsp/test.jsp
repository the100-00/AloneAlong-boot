<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${resId} 번 식당.
<ul>
	<li>ID: ${resId}</li>
	<li>이름: ${restaurant.resName}</li>
	<li>분류: ${restaurant.categoryId}</li>
	<li>위치 :${restaurant.resAddress}</li>
</ul>

</body>
</html>