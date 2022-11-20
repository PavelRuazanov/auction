<%--
  Created by IntelliJ IDEA.
  User: Profi
  Date: 17.11.2022
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
</head>
<body>
Request from: ${pageContext.errorData.requestURI} is failed <br/>
Servlet name: ${pageContext.errorData.servletName} is failed <br/>
Status code: ${pageContext.errorData.statusCode} is failed <br/>
Exception: ${pageContext.exception}<br/>
Exception: ${pageContext.exception.message}<br/>
<br/><br/><br/>
Massage from exception: ${error_msg}
</body>
</html>
