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

        //Adiabatical Process -> Q = 0
        Q = 0;
        W = calcWork(params.mass, gas.getMoleHeatWithConstVolume(), params.startTemperature, params.endTemperature);
        dU = -W;
        //???dH ????
        dH = 0;
        return new Result(W,Q,dH,dU);
    }

    private double calcWork(double m, double cv, double T1, double T2){
        return m*cv*(T1-T2);
    }
}
