<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" ng-controller="MainCtrl">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    var prefix = '/RemoteNote/user';
    var Validation = function() {
        var formData = {
            "login": $("login").val(),
            "password": $("password").val()
        };
        $.ajax({
            url: prefix + '/authorizeUser',
            type: 'POST',
            dataType: 'json',
            data: 'params=' + $.toJSON(formData),
            success: function (res) {
                alert(res);
            }
        });
    }

</script>
<head>
    <meta charset="UTF-8">
    <title>RemoteNote</title>
    <%--<link rel="stylesheet" href="main.css"/>--%>
</head>
<body class="auth-form">
<div>
    <form class="login-form" style="padding: 5px" id="form" method="post" action="#">
        <div class="form-group-auth">
            <label class="label-auth">Autorization</label>
        </div>

        <div class="form-group" style="margin-top: 10px">
            <input type="text" name="login" id="login" class="form-control" placeholder="Login" style="font-family: 'Courier New';"
                   ng-model="login">
        </div>

        <br>
        <div class="form-group">
            <input type="text" name="password" id="password" placeholder="Password" class="form-control" style="font-family: 'Courier New';"
                   ng-model="password">
        </div>

        <div class="has-error">
            <p class="help-block">Enter login and password</p>
        </div>

        <div class="button-form-row">
            <button class="btn btn-login" onclick="Validation()">
                LOGIN
            </button>
        </div>

    </form>
</div>
</body>
</html>