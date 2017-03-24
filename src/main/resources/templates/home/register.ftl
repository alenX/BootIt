<html>
<head>
    <script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        function check_user_name() {
            var username = $('#username').val();
            $.ajax({
                url: '/home/register/check_user_name',
                data: {'username': username,"${_csrf.parameterName}":"${_csrf.token}"},
                method: 'POST',
                success: function (rs) {
                    if (rs.succ) {
                        $('#username').val('');
                        alert('请重新输入用户名!');
                    }
                }
            });
        }
    </script>
</head>
<body>
<form action="/index/register" method="post">
    <label>username:</label><input id="username" name="username" onblur="check_user_name()"><br>
    <label>password:</label><input id="password" name="password" type="password"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">register</button>
</form>
</body>
</html>