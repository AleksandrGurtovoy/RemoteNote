'use strict';

angular.module('RemoteNote')
    .config(function ($stateProvider) {
        $stateProvider.state('main', {
            url: "/login",
            templateURL: 'web/main/index.jsp',
            controller: 'MainCtrl'
        })
    })