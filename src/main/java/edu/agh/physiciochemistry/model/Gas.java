package edu.agh.physiciochemistry.model;

import netscape.javascript.JSObject;

/**
 * Created by Szymon on 23.03.2017.
 */
public class Gas {
    private static final String MOLE_MASS = "moleMass";
    private static final String PROPER_HEAT = "properHeat";
    private double moleMass;
    private double properHeat;

    public Gas(double moleMass) {
        this.moleMass = moleMass;
    }

    public Gas(double moleMass, double properHeat){
        this.moleMass = moleMass;
        this.properHeat = properHeat;
    }


    public double getMoleMass() {
        return moleMass;
    }

    public double getProperHeat() {
        return properHeat;
    }

    public static Gas fromJSObject(JSObject object){
        double moleMass = object.getMember(MOLE_MASS) instanceof Number ? ((Number) object.getMember(MOLE_MASS)).doubleValue() : 0;
        double properHeat = object.getMember(PROPER_HEAT) instanceof Number ? ((Number) object.getMember(PROPER_HEAT)).doubleValue() : 0;
        return new Gas(moleMass, properHeat);
    }
}
