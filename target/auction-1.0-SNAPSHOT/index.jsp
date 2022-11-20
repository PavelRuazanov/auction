<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>"First page"
</h1>
<br/>
<form action="controller">
    <input type="hidden" name="command" value="login"/>
    Login: <input type="text" name="login" value=""/>
    <br/>
    Password: <input type="text" name="pass" value=""/>
    <br/>
    <input type="submit" name="sub" value="Enter to auction"/>
    <br/>
    ${failEnter}
</form>

</body>
</html>