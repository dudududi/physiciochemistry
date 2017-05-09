package edu.agh.physiciochemistry.model;

import netscape.javascript.JSObject;


/**
 * Created by Szymon on 23.03.2017.
 */
public interface Process {

    double REYNOLDS_NUMBER = 8.314;

    Result execute(Gas gas, Params params);

    class Params {
        private static final String START_VOLUME = "startVolume";
        private static final String END_VOLUME = "endVolume";
        private static final String START_TEMPERATURE = "startTemp";
        private static final String END_TEMPERATURE = "endTemp";
        private static final String MASS = "mass";
        private static final String MOLE_NUMBER = "moleNumber";
        private static final String START_PRESSURE = "startPressure";
        private static final String END_PRESSURE = "endPressure";
        private static final String IS_REVERSIBLE = "isReversible";

        double startVolume;
        double endVolume;
        double startTemperature;
        double endTemperature;
        double startPressure;
        double endPressure;
        double mass;
        double moleNumber;
        boolean isReversible;

        Params(double startVolume, double endVolume, double startTemperature, double endTemperature, double mass, double startPressure, double endPressure, double moleNumber, boolean isReversible) {
            this.startVolume = startVolume;
            this.endVolume = endVolume;
            this.startTemperature = startTemperature;
            this.endTemperature = endTemperature;
            this.mass = mass;
            this.startPressure = startPressure;
            this.endPressure = endPressure;
            this.moleNumber = moleNumber;
            this.isReversible = isReversible;
        }


        public static Params fromJSObject(JSObject object) {
            double startVolume = object.getMember(START_VOLUME) instanceof Number ? ((Number) object.getMember(START_VOLUME)).doubleValue() : 0;
            double endVolume = object.getMember(END_VOLUME) instanceof Number ? ((Number) object.getMember(END_VOLUME)).doubleValue() : 0;
            double startTemperature = object.getMember(START_TEMPERATURE) instanceof Number ? ((Number) object.getMember(START_TEMPERATURE)).doubleValue() : 0;
            double endTemperature = object.getMember(END_TEMPERATURE) instanceof Number ? ((Number) object.getMember(END_TEMPERATURE)).doubleValue() : 0;
            double mass = object.getMember(MASS) instanceof Number ? ((Number) object.getMember(MASS)).doubleValue() : 0;
            double moleNumber = object.getMember(MOLE_NUMBER) instanceof Number ? ((Number) object.getMember(MOLE_NUMBER)).doubleValue() : 0;
            double startPressure = object.getMember(START_PRESSURE) instanceof Number ? ((Number) object.getMember(START_PRESSURE)).doubleValue() : 0;
            double endPressure = object.getMember(END_PRESSURE) instanceof Number ? ((Number) object.getMember(END_PRESSURE)).doubleValue() : 0;
            boolean isReversible = object.getMember(IS_REVERSIBLE) instanceof Boolean ? (boolean) object.getMember(IS_REVERSIBLE) : true;

            return new Params(startVolume, endVolume, startTemperature, endTemperature, mass, startPressure, endPressure, moleNumber, isReversible);
        }

        @Override
        public String toString(){
            return String.format("{%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %s%n}",
                    START_VOLUME, startVolume, END_VOLUME, endVolume, START_TEMPERATURE, startTemperature, END_TEMPERATURE, endTemperature,
                    MASS, mass, MOLE_NUMBER, moleNumber, START_PRESSURE, startPressure, END_PRESSURE, endPressure, IS_REVERSIBLE, isReversible);
        }
    }

    class Result {
        double W;
        double Q;
        double dH;
        double dU;
        double endTemp;

        Result(double w, double q, double dH, double dU, double endTemp) {
            W = w;
            Q = q;
            this.dH = dH;
            this.dU = dU;
            this.endTemp = endTemp;
        }

        public Object[] toJSArgs() {
            return endTemp == 0 ? new Object[]{W, Q, dH, dU} : new Object[]{W, Q, dH, dU, endTemp};
        }

        @Override
        public String toString(){
            return String.format("{%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f,%n\t%s: %f%n}",
                    "W", W, "Q", Q, "dH", dH, "dU", dU, "endTemp", endTemp);
        }

    }
}
