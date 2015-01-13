<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cp" value="<%=request.getContextPath() %>"/>
<c:set var="rp" value='<%=request.getAttribute("javax.servlet.forward.request_uri")%>'/>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Upload</title>

	<link rel="stylesheet" type="text/css" href="${cp }/resources/css/default.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/css/layout.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

	<script>
		var contextPath = '<c:out value="${cp}"/>';
		var realPath = '<c:out value="${rp}"/>';
	</script>

</head>
<body>

	<section class="upload_wrap">
		<header>
			<a href="${cp}/"><h1>Spring 4.1.1 File upload example</h1></a>
		</header>

		<article class="http">
			
			<header>
				<h2>Content type - Http</h2>
			</header>
			
			<form:form commandName="upload" action="${cp}/http" method="post" enctype="multipart/form-data">
				<form:label path="file" cssClass="label label_default" cssErrorClass="label label_error">File Upload</form:label>
				<form:input path="file" type="file" cssClass="input input_default" cssErrorClass="input input_error"/>
				<form:errors path="file" cssClass="error"/>
				<button type="submit" class="btn">submit</button>
			</form:form>
			
		</article>
		
		<%--<article class="json">--%>
			<%----%>
			<%--<header>--%>
				<%--<h2>Content type - Json</h2>--%>
			<%--</header>--%>
			<%----%>
			<%--<form name="json" action="${cp}/json" method="post" enctype="multipart/form-data">--%>
				<%--<label for="file" class="label label_default">File Upload</label>--%>
				<%--<input type="file" name="file" class="input input_default"/>--%>
				<%--<button type="button" class="btn">submit</button>--%>
			<%--</form>--%>
			<%----%>
		<%--</article>--%>

		<footer>
			Copyright &copy; Francis.kim. All right reserved.
		</footer>
	</section>

	<script src="${cp}/resources/javascript/upload.js"></script>

</body>
</html>