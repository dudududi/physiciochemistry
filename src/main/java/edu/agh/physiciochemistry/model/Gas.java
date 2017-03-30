package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 23.03.2017.
 */
public class Gas {
    private double moleMass;
    private double properHeat;

    public Gas(double moleMass) {
        this.moleMass = moleMass;
    }

    public Gas(double moleMass, double properHeat){
        this.moleMass = moleMass;
        this.properHeat = properHeat;
    }


    public double getMoleNumber() {
        return moleMass;
    }

    public void setMoleNumber(double moleNumber) {
        this.moleMass = moleNumber;
    }

    public double getProperHeat() {
        return properHeat;
    }

    public void setProperHeat(double properHeat) {
        this.properHeat = properHeat;
    }
}
