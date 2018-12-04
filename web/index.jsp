    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html lang="en" ng-controller="MainCtrl">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript">
        var fullName = "";
        var birthdate = "";
        var student;
        var id;
        var Validation = function () {
        var login = document.getElementById('login').value;
        var pass = document.getElementById('password');
        $.ajax({
        url: '/authorizeUser?login=' + login,
        type: 'GET',
        success: function (res) {
        var mas = JSON.parse(res);
        fullName = mas.fullName;
        birthdate = mas.dateOfBirthday;
        student = mas.student;
        id = mas.id;

        if (mas.password == pass.value) {
        $.ajax({
        url: '/getPhoto?login=' + login,
        type: 'GET',
        success: function (res) {
        var source = "data:image/jpeg;base64," + res;
        document.getElementById("photo").value = res;
        document.getElementById("logForm").style.visibility = 'hidden';
        document.getElementById("profileBlock").style.visibility = 'visible';
        document.getElementById("fullName").value = fullName;
        document.getElementById("photo").src = source;
        document.getElementById("birthdate").value = birthdate;
        if (student == true) {
        document.getElementById("checkbox").checked = true;
        }
        }
        })

        } else {

        alert("Login or password is incorrect")
        }
        }
        });
        };

        var getUserPhoto = function () {
        $.ajax({
        url: '/getPhoto',
        type: 'GET',
        templateUrl: 'remoteNote.html'
        })
        };

        function editProfile () {
        document.getElementById("saveEdit").style.visibility = 'visible';
        document.getElementById("fullName").disabled = false;
        document.getElementById("birthdate").disabled = false;
        }

        function saveEdit () {
        var fullNameForm = document.getElementById('fullName').value;
        var birthdateForm = document.getElementById('birthdate').value;
        var myData = {
        "firstName": fullNameForm,
        "birthdate": birthdateForm
        };

        $.ajax({
        url: '/saveUserData?login=' + login '&fullName=' + fullName + '&date=' + birtdate,
        type: 'POST',
        data: 'json=' + JSON.stringify(myData)
        });
        }
            function toNotes () {
            var first = document.getElementById('createNoteForm');
            var second = document.getElementById('profileBlock');
            var third = document.getElementById('noteBody');

            first.style.visibility = 'hidden';
            second.style.visibility = 'hidden';
            if (third.style.visibility = 'hidden') {
            third.style.visibility = 'visible';
            }
            else third.style.visibility = 'hidden';
            }

            function createNote () {
            var first = document.getElementById('profileBlock');
            var second = document.getElementById('noteBody');
            first.style.visibility = 'hidden';
            second.style.visibility = 'hidden';
            }

            function save () {
            var noteName = document.getElementById('noteName');
            var noteText = document.getElementById('noteText');
            var noteData = {
            "noteName": noteName,
            "noteText": noteText
            };
            $.ajax({
            url: '/saveUserData?login=&fullName=&date=',
            type: 'POST',
            data: 'json=' + JSON.stringify(noteData)
            });
            }

            function goBack () {
            var first = document.getElementById('profileBlock');
            var second = document.getElementById('createNoteForm');
            first.style.visibility = 'visible';
            second.style.visibility = 'hidden';
            }



        </script>
        <style>
        @import url(https://fonts.googleapis.com/css?family=Open+Sans);

        .btn {
        display: inline-block;
        *display: inline;
        *zoom: 1;
        padding: 4px 10px 4px;
        margin-bottom: 0;
        font-size: 13px;
        line-height: 18px;
        color: #333333;
        text-align: center;
        text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
        vertical-align: middle;
        background-color: #f5f5f5;
        background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
        background-image: -ms-linear-gradient(top, #ffffff, #e6e6e6);
        background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));
        background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
        background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
        background-image: linear-gradient(top, #ffffff, #e6e6e6);
        background-repeat: repeat-x;
        filter: progid:dximagetransform.microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0);
        border-color: #e6e6e6 #e6e6e6 #e6e6e6;
        border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
        border: 1px solid #e6e6e6;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        cursor: pointer;
        *margin-left: .3em;
        }

        .btn:hover, .btn:active, .btn.active, .btn.disabled, .btn[disabled] {
        background-color: #e6e6e6;
        }

        .btn-large {
        padding: 9px 14px;
        font-size: 15px;
        line-height: normal;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        }

        .btn:hover {
        color: #333333;
        text-decoration: none;
        background-color: #e6e6e6;
        background-position: 0 -15px;
        -webkit-transition: background-position 0.1s linear;
        -moz-transition: background-position 0.1s linear;
        -ms-transition: background-position 0.1s linear;
        -o-transition: background-position 0.1s linear;
        transition: background-position 0.1s linear;
        }

        .btn-primary, .btn-primary:hover {
        text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
        color: #ffffff;
        }

        .btn-primary.active {
        color: rgba(255, 255, 255, 0.75);
        }

        .btn-primary {
        background-color: #4a77d4;
        background-image: -moz-linear-gradient(top, #6eb6de, #4a77d4);
        background-image: -ms-linear-gradient(top, #6eb6de, #4a77d4);
        background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6eb6de), to(#4a77d4));
        background-image: -webkit-linear-gradient(top, #6eb6de, #4a77d4);
        background-image: -o-linear-gradient(top, #6eb6de, #4a77d4);
        background-image: linear-gradient(top, #6eb6de, #4a77d4);
        background-repeat: repeat-x;
        filter: progid:dximagetransform.microsoft.gradient(startColorstr=#6eb6de, endColorstr=#4a77d4, GradientType=0);
        border: 1px solid #3762bc;
        text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.4);
        box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.5);
        }

        .btn-primary:hover, .btn-primary:active, .btn-primary.active, .btn-primary.disabled, .btn-primary[disabled] {
        filter: none;
        background-color: #4a77d4;
        }

        .btn-block {
        width: 100%;
        display: block;
        }

        * {
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        -ms-box-sizing: border-box;
        -o-box-sizing: border-box;
        box-sizing: border-box;
        }

        html {
        width: 100%;
        height: 100%;
        overflow: hidden;
        }

        body {
        width: 100%;
        height: 100%;
        font-family: 'Open Sans', sans-serif;
        background: #092756;
        background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4) 10%, rgba(138, 114, 76, 0)
        40%), -moz-linear-gradient(top, rgba(57, 173, 219, .25) 0%, rgba(42, 60, 87, .4) 100%),
        -moz-linear-gradient(-45deg, #670d10 0%, #092756 100%);
        background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4) 10%, rgba(138, 114, 76, 0)
        40%), -webkit-linear-gradient(top, rgba(57, 173, 219, .25) 0%, rgba(42, 60, 87, .4) 100%),
        -webkit-linear-gradient(-45deg, #670d10 0%, #092756 100%);
        background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4) 10%, rgba(138, 114, 76, 0) 40%),
        -o-linear-gradient(top, rgba(57, 173, 219, .25) 0%, rgba(42, 60, 87, .4) 100%), -o-linear-gradient(-45deg,
        #670d10 0%, #092756 100%);
        background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4) 10%, rgba(138, 114, 76, 0) 40%),
        -ms-linear-gradient(top, rgba(57, 173, 219, .25) 0%, rgba(42, 60, 87, .4) 100%), -ms-linear-gradient(-45deg,
        #670d10 0%, #092756 100%);
        background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4) 10%, rgba(138, 114, 76, 0)
        40%), linear-gradient(to bottom, rgba(57, 173, 219, .25) 0%, rgba(42, 60, 87, .4) 100%), linear-gradient(135deg,
        #670d10 0%, #092756 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#3E1D6D', endColorstr='#092756',
        GradientType=1);
        }

        .login {
        position: absolute;
        top: 50%;
        left: 50%;
        margin: -150px 0 0 -150px;
        width: 300px;
        height: 300px;
        }

        .login h1 {
        color: #fff;
        text-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        letter-spacing: 1px;
        text-align: center;
        }

        input {
        width: 100%;
        margin-bottom: 10px;
        background: rgba(0, 0, 0, 0.3);
        border: none;
        outline: none;
        padding: 10px;
        font-size: 13px;
        color: #fff;
        text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
        border: 1px solid rgba(0, 0, 0, 0.3);
        border-radius: 4px;
        box-shadow: inset 0 -5px 45px rgba(100, 100, 100, 0.2), 0 1px 1px rgba(255, 255, 255, 0.2);
        -webkit-transition: box-shadow .5s ease;
        -moz-transition: box-shadow .5s ease;
        -o-transition: box-shadow .5s ease;
        -ms-transition: box-shadow .5s ease;
        transition: box-shadow .5s ease;
        }

        input:focus {
        box-shadow: inset 0 -5px 45px rgba(100, 100, 100, 0.4), 0 1px 1px rgba(255, 255, 255, 0.2);
        }

        </style>

        <head>
        <meta charset="UTF-8">
        <title>RemoteNote</title>
        </head>
        <body>
        <div id="logForm" class="login">
        <h1>Login</h1>
        <input type="text" name="login" id="login" class="form-control" placeholder="Login"
        style="font-family: 'Courier New';"
        ng-model="login"/>
        <input type="text" name="password" id="password" placeholder="Password" class="form-control"
        style="font-family: 'Courier New';"
        ng-model="password"/>
        <button type="submit" class="btn btn-primary btn-block btn-large" onclick="Validation()">LOGIN</button>
        </div>

        <!--
        <div class="profileBlock" id="profileBlock" style="visibility: hidden;">
        <div class="text-left">
        <h4 translate>Your Profile</h4>
        </div>
        <img id="photo" src="" width="200" height="300"
        style="margin-left: -530px; position: absolute; border: 5px solid black;">
        <div class="form-group">
        <div class="userName" style="margin-left: -300px; margin-top: 30px;">
        <span style="font-size: 24px; color: black">Full name: </span>
        <input id="fullName" style="margin-left: 150px; margin-top:-38px; font-size: 24px; border-radius: 0px;
        box-shadow: none" readonly>
        </div>
        </div>
        </div>
        -->
        <div id="profileBlock" style="visibility: hidden; position: absolute; margin-top: 50px; width: 400px; height:
        300px;
        background-color: rgba(255,255,255, 0.5);
        border: 3px solid white; border-radius: 8px; text-align: center; color: white;
        font-size: 23px">
        <div>Your Profile</div>
        <img id="photo" src=""
        style="position: absolute; left: 20px; width: 50px; height: 50px; border-radius: 50%; vertical-align: middle;">
        <div class="form-group" style="position: absolute">
        <span style="position: absolute; top: 60px; width: 150px;">Full name: </span>
        <input id="fullName" style="position: absolute; top: 60px; background-color: rgba(255,255,255, 0.5);
        margin-left: 160px; border-radius: 8px; width: 220px;" disabled>
        <span style="position: absolute; top: 105px; width: 150px; margin-left: 15px">Birthdate: </span>
        <input id="birthdate" style="position: absolute; top: 105px; background-color: rgba(255,255,255, 0.5);
        margin-left: 177px; border-radius: 8px; width: 200px; height: 37px" disabled>
        <span style="position: absolute; top: 145px; width: 130px;">Student: </span>
        <input id="checkbox" type="checkbox" style="position: absolute; top: 145px; width: 30px; height: 30px;
        background-color: transparent;
        margin-left: 177px;" disabled>

        </div>
        <button id="toNotes" onclick="toNotes()"
        style="position: relative; margin-top: 200px; width: 150px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px; color: white">Go to my Notes
        </button>
        <button id="createNote" onclick="createNote()"
        style="position: relative; margin-top: 200px; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px; color: white">Create Note
        </button>
        <button id="editProfile" onclick="editProfile()"
        style="position: relative; margin-top: 200px; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px; color: white">Edit Profile
        </button>
        <button id="saveEdit" onclick="saveEdit()"
        style="visibility: hidden; position: relative; margin-top: 200px; width: 50px; height: 30px; background-color:
        rosybrown;
        border: 1px solid white; border-radius: 8px; color: white">Save Edit
        </button>
        </div>

        <div id="createNoteForm" style="visibility: hidden; position: absolute; width: 400px; height: 200px;
        background-color:
        rgba(255,255,255, 0.5);
        border: 3px solid white; border-radius: 8px; text-align: center; color: white;
        font-size: 23px">Create Note
        <div>
            <label>Name of notes:</label>
            <input id="noteName" style="opacity: 0.5; width: 94%; height: 25px;">
            <label>Text:</label>
            <input id="noteText" style="opacity: 0.5; width: 94%; height: 25px;">
        <button onclick="save()"
        style="position: relative; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px; color: white">Save</button>
        <button onclick="goBack()"
        style="position: relative; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px; color: white">Go back</button>
        </div>

        </div>

        <div id="noteBody"
        style="visibility: hidden; position: absolute; margin-left: 40%; color: white; font-size: 23px;
        z-index: 10; text-align: center">

        <div style="position: absolute; width: 300px; height: 600px; border: 3px solid white; border-radius: 6px;
        background-color: rgba(255,255,255, 0.4)">
        <div style="position: absolute;width: 100%; height: 50px; z-index: 1;
        border-bottom: 3px solid white;">Notes

        </div>

        </div>
        <div style="position: absolute; margin-left: 295px; width: 500px; height: 600px; border: 3px solid white;
        border-radius: 6px; background-color: rgba(255,255,255, 0.4)">
        <div style="position: relative; width: 100%; height: 50px;
        border-bottom: 3px solid white">Change your note
        </div>

        <div style="position: relative;width: 100%; height: 150px; border-bottom: 3px solid white; padding-top: 15px">
        <textarea id="textarea" style="opacity: 0.5; width: 94%; height: 75px"></textarea>
        <button onclick="edit()"
        style="position: relative; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px">Edit</button>
        <button style="position: relative; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px">Save</button>
        <button style="position: relative; width: 100px; height: 30px; background-color: rosybrown;
        border: 1px solid white; border-radius: 8px">Delete</button>
        </div>

        </div>
        <button onclick="goBack()"
        style="position: absolute; width: 100px; height: 30px; background-color: rosybrown;
        top: 650px;
        border: 1px solid white; border-radius: 8px; color: white">Go back</button>
        </div>

        </body>
        </html>