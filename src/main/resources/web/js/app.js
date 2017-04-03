(function () {
    window.jsAPI = {
        echo: function (msg) {
            document
                .getElementById('demo')
                .innerHTML += msg + " ";
        }
    };

    var app = angular
        .module('app', [])
        .controller('main', [
            '$scope',
            function ($scope) {

                $scope.sample = function () {
                    window
                        .JavaAPI
                        .count($scope.x, $scope.y);

                }

                $scope.test = "dupa";

            }
        ]);
}());