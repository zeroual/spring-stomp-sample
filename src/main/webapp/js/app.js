angular.module('zerosApp', [])
    .controller('ChatCtrl', function (CharService, $scope) {

        $scope.messagesList = [{body: 'hi'}];
        $scope.$on('receivedMessageEvent', function (event, message) {
            $scope.messagesList.push(message);
            $scope.$apply();
        });

        $scope.sendMessage = function () {
            CharService.sendMessage($scope.message);
            $scope.message = '';
        };

    })
    .service('CharService', function ($rootScope) {
        var socket = new SockJS("http://" + window.location.host + "/stomp");
        var stomp = Stomp.over(socket);
        stomp.connect('guest', 'guest', function () {
            stomp.subscribe("/topic/chat", function (payload) {
                $rootScope.$broadcast('receivedMessageEvent', JSON.parse(payload.body));
            });
        });
        this.sendMessage = function (message) {
            stomp.send("/app/chat", {}, JSON.stringify({body: message}));
        };
    });