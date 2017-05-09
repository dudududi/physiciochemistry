package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 23.03.2017.
 */
public class IsothermalExpansionProcess implements  Process {

    // W = n*R*T*ln(V1/V2)
    @Override
    public Result execute(Gas gas, Params params) {
        double W;
        double n;
        double Q;
        double dU;
        double dH;
        //Isothermal Process -> dU = dH = 0
        dU = 0;
        dH = 0;

        n = params.moleNumber != 0 ? params.moleNumber : this.calcMoleNumber(params.mass, gas.getMoleMass());
        W = this.calcWork(n, params.startTemperature, params.startVolume, params.endVolume);
        Q = - W;

        return new Result(W, Q, dH, dU, 0);
    }

    private double calcWork(double n, double temperature, double startVolume, double endVolume){
        return n * REYNOLDS_NUMBER * temperature * Math.log(startVolume/endVolume);
    }

    private double calcMoleNumber(double mass, double moleMass){
        return mass/moleMass;
    }
}
