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
                            mass: data.isMassChecked ? parseFloat(data.mass) : 0,
                            moleNumber: data.isMassChecked ? 0 : parseFloat(data.moleNumber),
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
                            mass: data.isMassChecked ? parseFloat(data.mass) : 0,
                            moleNumber: data.isMassChecked ? 0 : parseFloat(data.moleNumber),
                            startTemp: parseFloat(data.startTemp),
                            startPressure: data.isVolumeChecked ? 0 : parseFloat(data.startPressure),
                            endPressure: data.isVolumeChecked ? data.isReversible? parseFloat(data.endPressure) : 0 : parseFloat(data.endPressure),
                            isReversible: data.isReversible
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

                $scope.clearMassData = function(process){
                    process.data.moleNumber = undefined;
                    process.data.mass = undefined;
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
                        moleHeatWithConstPressure: 20.785,
                        moleHeatWithConstVolume: 12.471
                    }, {
                        name: "Tlen",
                        moleMass: 16,
                        properHeat: 0.916,
                        moleHeatWithConstPressure: 29.43,
                        moleHeatWithConstVolume: 21.06
                    }
                ];

                $scope.selectedProcess = $scope.processes[0];
                $scope.result = undefined;
                $scope.selectedProcess.data.isReversible = true;

                $scope.selectProcess = function (process) {
                    $scope.selectedProcess.data = {};
                    $scope.result = undefined;
                    $scope.selectedProcess = process;
                    $scope.selectedProcess.data.isReversible = true;
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