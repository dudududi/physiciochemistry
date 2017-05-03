package edu.agh.physiciochemistry.model;

import netscape.javascript.JSObject;

/**
 * Created by Szymon on 23.03.2017.
 */
public class Gas {
    private static final String MOLE_MASS = "moleMass";
    private static final String PROPER_HEAT = "properHeat";
    private static final String MOLE_HEAT_WITH_CONST_PRESSURE = "moleHeatWithConstPressure";
    private static final String MOLE_HEAT_WITH_CONST_VOLUME = "moleHeatWithConstVolume";
    private double moleMass;
    private double properHeat;
    private double moleHeatWithConstPressure; //cp
    private double moleHeatWithConstVolume; //cv
    private double heatCapacityRatio; // k

    public Gas(double moleMass) {
        this.moleMass = moleMass;
    }

    public Gas(double moleMass, double properHeat, double moleHeatWithConstPressure, double moleHeatWithConstVolume) {
        this.moleMass = moleMass;
        this.properHeat = properHeat;
        this.moleHeatWithConstPressure = moleHeatWithConstPressure;
        this.moleHeatWithConstVolume = moleHeatWithConstVolume;
        this.heatCapacityRatio = this.moleHeatWithConstPressure / this.moleHeatWithConstVolume;
        System.out.println("params " +  this.moleHeatWithConstPressure + ", " +  this.moleHeatWithConstVolume + ", " +  this.heatCapacityRatio);
    }

    public double getMoleMass() {
        return moleMass;
    }

    public double getProperHeat() {
        return properHeat;
    }

    public double getMoleHeatWithConstPressure() {
        return moleHeatWithConstPressure;
    }

    public double getMoleHeatWithConstVolume() {
        return this.moleHeatWithConstVolume;
    }

    public double getHeatCapacityRatio() {
        return this.heatCapacityRatio;
    }

    public static Gas fromJSObject(JSObject object) {
        double moleMass = object.getMember(MOLE_MASS) instanceof Number ? ((Number) object.getMember(MOLE_MASS)).doubleValue() : 0;
        double properHeat = object.getMember(PROPER_HEAT) instanceof Number ? ((Number) object.getMember(PROPER_HEAT)).doubleValue() : 0;
        double moleHeatWithConstPressure = object.getMember(MOLE_HEAT_WITH_CONST_PRESSURE) instanceof Number ? ((Number) object.getMember(MOLE_HEAT_WITH_CONST_PRESSURE)).doubleValue() : 0;
        double moleHeatWithConstVolume = object.getMember(MOLE_HEAT_WITH_CONST_VOLUME) instanceof Number ? ((Number) object.getMember(MOLE_HEAT_WITH_CONST_VOLUME)).doubleValue() : 0;
        return new Gas(moleMass, properHeat, moleHeatWithConstPressure, moleHeatWithConstVolume);
    }
}
