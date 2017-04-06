window.JavaAPI = window.JavaAPI ||
    {
        /**
         * gas = {
         *          moleNumber: Number,
         *          properHeat: Number
         *       }
         *
         * params = {
         *              beginTemp: Number,
         *              endTemp: Number -> only for non-isothermal,
         *              beginVol: Number,
         *              endVol: Number,
         *              gasMass: Number
         *          }
         * callback = function()
         */

        invokeIsothermalExpansionProcess: function(gas, params, callback) { throw new Error("Not implemented");},
        invokeAdiabaticExpansionProcess: function(gas, params, callback) { throw new Error("Not implemented");},
        invokeIsothermalCompressProcess: function(gas, params, callback) { throw new Error("Not implemented");},
        invokeAdiabaticCompressProcess: function(gas, params, callback) { throw new Error("Not implemented");}
    };

function sample() {
    document.getElementById('demo').innerHTML += "hehe cwele ";


    window.JavaAPI.invokeIsothermalExpansionProcess(){

    }


}