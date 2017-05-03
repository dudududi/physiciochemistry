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

                var invokeIsothermalExpansionProcess = function (data) {
                    window
                        .JavaAPI
                        .invokeIsothermalExpansionProcess({
                            moleMass: data.gas.moleMass,
                            properHeat: data.gas.properHeat
                        }, {
                            mass: parseFloat(data.mass),
                            startVolume: parseFloat(data.startVolume),
                            endVolume: parseFloat(data.endVolume),
                            startTemp: parseFloat(data.startTemp),
                            endTemp: parseFloat(data.endTemp)
                        }, {onResult: callback});
                };

                var invokeAdiabaticExpansionProcess = function (data) {
                    window
                        .JavaAPI
                        .invokeAdiabaticExpansionProcess({
                            moleMass: parseFloat(data.gas.moleMass),
                            properHeat: parseFloat(data.gas.properHeat),
                            moleHeatWithConstPressure: parseFloat(data.gas.moleHeatWithConstPressure),
                            moleHeatWIthConstVolume: parseFloat(data.gas.moleHeatWIthConstVolume)

                        }, {
                            startTemp: parseFloat(data.startTemp),
                            startPressure: parseFloat(data.startPressure),
                            endPressure: parseFloat(data.endPressure)
                        }, {onResult: callback});
                };

                var processFunction3 = function (data) {};

                var processFunction4 = function (data) {};

                $scope.processes = [
                    {
                        name: "Rozprężanie izotermincze",
                        id: 1,
                        data: {},
                        processFunction: invokeIsothermalExpansionProcess
                    }, {
                        name: "Rozprężanie adiabatyczne",
                        id: 2,
                        data: {},
                        processFunction: invokeAdiabaticExpansionProcess
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
                        properHeat: 0.520,
                        moleHeatWithConstPressure: 20.8,
                        moleHeatWithConstVolume: 12.5
                    }, {
                        name: "Neon",
                        moleMass: 20.179,
                        properHeat: 0.904,
                        moleHeatWithConstPressure: 20.8,
                        moleHeatWithConstVolume: 12.5

                    }, {
                        name: "Krypton",
                        moleMass: 83.798,
                        properHeat: 0.248,
                        moleHeatWithConstPressure: 20.8,
                        moleHeatWithConstVolume: 12.5

                    }, {
                        name: "Hel",
                        moleMass: 4.0026,
                        properHeat: 5.193,
                        moleHeatWithConstPressure: 20.8,
                        moleHeatWithConstVolume: 12.5
                    }
                ];

                $scope.selectedProcess = $scope.processes[0];
                $scope.result = undefined;

                $scope.selectProcess = function (process) {
                    $scope.selectedProcess = process;
                };

                var callback = function (W, Q, dH, dU) {
                    $scope.result = {
                        W: W,
                        Q: Q,
                        dH: dH,
                        dU: dU
                    };
                };
            }
        ]);
}());