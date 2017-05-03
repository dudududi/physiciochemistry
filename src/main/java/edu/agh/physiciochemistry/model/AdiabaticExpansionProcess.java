package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 01.05.2017.
 */
public class AdiabaticExpansionProcess implements  Process {

    @Override
    public Result execute(Gas gas, Params params) {
        double W;
        double Q;
        double dU;
        double dH;
        double endTempeature;
        double n;

        //Adiabatical Process -> Q = 0
        Q = 0;
        if (params.startTemperature != 0 && params.endTemperature != 0) {
            endTempeature = this.calcEndTempUsingVolumes(params.startTemperature, params.startVolume, params.endVolume, gas.getHeatCapacityRatio());
        } else {
            endTempeature = this.calcEndTempUsingPressures(params.startTemperature, params.startPressure, params.endPressure, gas.getHeatCapacityRatio());
        }
        n = this.calcMoleNumber(params.mass, gas.getMoleMass());
        W = calcWork(n, gas.getMoleHeatWithConstVolume(), params.startTemperature, endTempeature);
        dU = W;
        dH = this.calcEnthalpy(params.startTemperature, endTempeature, n, gas.getMoleHeatWithConstPressure());
        System.out.print("params" + params);
        return new Result(W,Q,dH,dU);
    }

    private double calcWork(double n, double cv, double T1, double T2){
        return n*cv*(T1-T2);
    }

    private double calcEndTempUsingPressures(double T1, double p1, double p2, double k){
        double fraction = p1 / p2;
        double index = (1 - k) / k;
        return T1 * Math.pow(fraction, index);
    }

    private double calcEndTempUsingVolumes(double T1, double V1, double V2, double k){
        return T1 * Math.pow(V2, 1-k) / Math.pow(V1, 1-k);
    }

    private double calcMoleNumber(double m, double M){
        return m/M;
    }

    private double calcEnthalpy(double T1, double T2, double n, double cp){
        return n * cp * (T2 - T1);
    }
}
