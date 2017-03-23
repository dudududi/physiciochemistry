package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 23.03.2017.
 */
public class Gas {
    private double moleNumber;
    private double properHeat;

    public Gas(double moleNumber, double properHeat){
        this.moleNumber = moleNumber;
        this.properHeat = properHeat;
    }


    public double getMoleNumber() {
        return moleNumber;
    }

    public void setMoleNumber(double moleNumber) {
        this.moleNumber = moleNumber;
    }

    public double getProperHeat() {
        return properHeat;
    }

    public void setProperHeat(double properHeat) {
        this.properHeat = properHeat;
    }
}
