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

                var processFunction1 = function (data) {
                    console.log('dupa');
                    window
                        .JavaAPI
                        .invokeIsothermalExpansionProcess({
                            moleMass: data.gas.moleMass,
                            properHeat: data.gas.properHeat
                        }, {
                            mass: data.gas.mass,
                            startVolume: data.gas.startVolume,
                            endVolume: data.gas.endVolume,
                            startTemp: data.gas.startTemp,
                            endTemp: data.gas.endTemp
                        }, {onResult: callback});
                };

                var processFunction2 = function (data) {};

                var processFunction3 = function (data) {};

                var processFunction4 = function (data) {};

                $scope.processes = [
                    {
                        name: "Rozprężanie izotermincze",
                        id: 1,
                        data: {},
                        processFunction: processFunction1
                    }, {
                        name: "Rozprężanie adiabatyczne",
                        id: 2,
                        data: {},
                        processFunction: processFunction2
                    }, {
                        name: "Odwracalane sprężanie adiabatyczne",
                        id: 3,
                        data: {},
                        processFunction: processFunction3
                    }, {
                        name: "Odwracalane sprężanie izotermiczne",
                        id: 4,
                        data: {},
                        processFunction: processFunction4
                    }
                ];

                $scope.gases = [
                    {
                        name: "Argon",
                        moleMass: 39.948,
                        properHeat: 0.520

                    }, {
                        name: "Neon",
                        moleMass: 20.179,
                        properHeat: 0.904

                    }, {
                        name: "Krypton",
                        moleMass: 83.798,
                        properHeat: 0.248

                    }, {
                        name: "Hel",
                        moleMass: 4.0026,
                        properHeat: 5.193

                    }
                ];

                $scope.selectedProcess = $scope.processes[0];
                $scope.result = undefined;

                $scope.selectProcess = function (process) {
                    $scope.selectedProcess = process;
                };

                var callback = function (result) {
                    $scope.result = JSON.parse(result);
                };

            }
        ]);
}());