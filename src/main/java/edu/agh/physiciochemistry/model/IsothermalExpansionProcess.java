package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 23.03.2017.
 */
public class IsothermalExpansionProcess implements  Process {

    // W = n*R*T*ln(V1/V2)
    @Override
    public void execute(Gas gas, double startVolume, double endVolume, double temperature) {
        double W;
        W = gas.getMoleNumber() * IsothermalExpansionProcess.REYNOLDS_NUMBER * temperature * Math.log(startVolume / endVolume);
    }
}
