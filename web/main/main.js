'use strict';

angular.module('RemoteNote')
    .config(function ($stateProvider) {
        $stateProvider.state('main', {
            url: "/login",
            templateURL: 'web/main/main.html',
            controller: 'MainCtrl'
        })
    })