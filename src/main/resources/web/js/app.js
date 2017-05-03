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
                            moleHeatWithConstVolume: parseFloat(data.gas.moleHeatWithConstVolume)

                        }, {
                            startVolume:  data.isVolumeChecked ? parseFloat(data.startVolume) : 0,
                            endVolume: data.isVolumeChecked ? parseFloat(data.endVolume) : 0,
                            mass: parseFloat(data.mass),
                            startTemp: parseFloat(data.startTemp),
                            startPressure: data.isVolumeChecked ? 0 : parseFloat(data.startPressure),
                            endPressure: data. isVolumeChecked ? 0 : parseFloat(data.endPressure)
                        }, {onResult: callback});
                };


                $scope.processes = [
                    {
                        name: "izotermincza",
                        id: 1,
                        data: {},
                        processFunction: invokeIsothermalExpansionProcess
                    }, {
                        name: "adiabatyczna",
                        id: 2,
                        data: {},
                        processFunction: invokeAdiabaticExpansionProcess
                    }];

                $scope.clearData = function(process){
                    process.data.startVolume = undefined;
                    process.data.endVolume = undefined;
                    process.data.startPressure = undefined;
                    process.data.endPressure = undefined;
                };

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
                    $scope.selectedProcess.data = {};
                    $scope.result = {};
                    $scope.selectedProcess = process;
                };

                var callback = function (W, Q, dH, dU, endTemperature) {
                    $scope.result = {
                        W: W,
                        Q: Q,
                        dH: dH,
                        dU: dU
                    };
                    endTemperature ? $scope.result.endTemperature = endTemperature: '';
                };
            }
        ]);
}());