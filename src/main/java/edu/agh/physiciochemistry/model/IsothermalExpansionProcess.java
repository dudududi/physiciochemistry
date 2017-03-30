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
        n = params.mass / gas.getMoleMass();
        W = n * IsothermalExpansionProcess.REYNOLDS_NUMBER *
                params.temperature * Math.log(params.startVolume / params.endVolume);
        Q = - W;

        return new Result(W, Q, dH, dU);
    }


}
