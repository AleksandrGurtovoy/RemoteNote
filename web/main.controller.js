'use strict';

var app = angular.module('RemoteNote');
    app.controller('MainCtrl', function($scope) {
        $(function () {
            $("#form").submit(function () {
                var formData = {
                    "login": $("login").val(),
                    "password": $("password").val()
                };
                $.ajax({
                    url: 'authorizeUser',
                    type: 'POST',
                    data: 'jsonData=' + $.toJSON(formData),
                    success: function (res) {
                        alert(res);
                    }
                });
                return false;

            })
        })
        });