<html>
<body>
<form action="/index/login"  method="post">
    <label>username:</label><input id="username" name="username"><br>
    <label>password:</label><input id="password" name="password" type="password"><br>
    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
    <button type="submit">login</button>
</form>
<img src="/image/aa.png" style="width: 100px;height: 200px">
</body>
</html>