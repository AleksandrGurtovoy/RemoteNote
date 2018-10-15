<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" ng-controller="MainCtrl">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

    var Validation = function() {
        var login = document.getElementById('login').value;
        var pass =  document.getElementById('password');
        $.ajax({
            url:'/authorizeUser?login='+login,
            type: 'GET',
            success: function (res) {
                var mas = JSON.parse(res)
                if(mas.password == pass.value){
                    alert("ok")
                } else{

                    alert(mas)
                }
            }
        });
    }

</script>
<style>body {
    font-family: 'Courier New';
}
.auth-form {
    background-color: lightblue;
}
.login-form {
    width: 20%;
    height: 25%;
    background-color: white;
    border: 1px solid #2b81af;
    margin-left: 40%;
    margin-right: 40%;
    margin-top: 10%;
    text-align: center;
}

.form-control {
}
.form-control:active {
    border: 1px solid green;
}
.form-group {

}
.form-group-auth {
     margin: 0px;
     height: 30px;
     background-color: #2b81af;
     text-align: center;
     vertical-align: center;
     color: white;
 }
.label-auth {
    margin-top: 5px;
}
.btn-login {
    width: 100px;
    height: 25px;
    background-color: #2b81af;
    color: white;
    border: none;
    font-family: 'Courier New';
}
.signIn {
    font-size: 20px;
}
</style>
<head>
    <meta charset="UTF-8">
    <title>RemoteNote</title>
</head>
<body class="auth-form">
    <div class="form-group" style="margin-top: 10px">
        <input type="text" name="login" id="login" class="form-control" placeholder="Login" style="font-family: 'Courier New';"
               ng-model="login">
    </div>

    <br>
    <div class="form-group">
        <input type="text" name="password" id="password" placeholder="Password" class="form-control" style="font-family: 'Courier New';"
               ng-model="password">

</div>
    <div class="button-form-row">
        <button class="btn btn-login" onclick="Validation()">
            LOGIN
        </button>
    </div>

</body>
</html>