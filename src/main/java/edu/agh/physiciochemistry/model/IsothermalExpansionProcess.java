package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 23.03.2017.
 */
public class IsothermalExpansionProcess implements  Process {

    // W = n*R*T*ln(V1/V2)
    @Override
    public void execute(Gas gas, Params params) {
        double W;
        W = IsothermalExpansionProcess.REYNOLDS_NUMBER *
                params.temperature * Math.log(params.startVolume / params.endVolume);
        double Q = -W;


    }


}
