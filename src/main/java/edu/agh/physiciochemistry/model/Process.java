package edu.agh.physiciochemistry.model;

import netscape.javascript.JSObject;

import java.util.HashMap;
import java.util.Map;

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

        double startVolume;
        double endVolume;
        double startTemperature;
        double endTemperature;
        double mass;

        Params(double startVolume, double endVolume, double startTemperature, double endTemperature, double mass) {
            this.startVolume = startVolume;
            this.endVolume = endVolume;
            this.startTemperature = startTemperature;
            this.endTemperature = endTemperature;
            this.mass = mass;
        }

        public static Params fromJSObject(JSObject object) {
            double startVolume = object.getMember(START_VOLUME) instanceof Number ? ((Number) object.getMember(START_VOLUME)).doubleValue() : 0;
            double endVolume = object.getMember(END_VOLUME) instanceof Number ? ((Number) object.getMember(END_VOLUME)).doubleValue() : 0;
            double startTemperature = object.getMember(START_TEMPERATURE) instanceof Number ? ((Number) object.getMember(START_TEMPERATURE)).doubleValue() : 0;
            double endTemperature = object.getMember(END_TEMPERATURE) instanceof Number ? ((Number) object.getMember(END_TEMPERATURE)).doubleValue() : 0;
            double mass = object.getMember(MASS) instanceof Number ? ((Number) object.getMember(MASS)).doubleValue() : 0;

            return new Params(startVolume, endVolume, startTemperature, endTemperature, mass);
        }
    }

    class Result {
        double W;
        double Q;
        double dH;
        double dU;

        Result(double w, double q, double dH, double dU) {
            W = w;
            Q = q;
            this.dH = dH;
            this.dU = dU;
        }

        public Object[] toJSArgs() {
            return new Object[]{W, Q, dH, dU};
        }
    }
}
