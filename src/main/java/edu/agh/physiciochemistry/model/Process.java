package edu.agh.physiciochemistry.model;

/**
 * Created by Szymon on 23.03.2017.
 */
public interface Process {

    double REYNOLDS_NUMBER = 8.314;

    Result execute(Gas gas, Params params);

    class Params {
        double startVolume;
        double endVolume;
        double temperature;
        double mass;

        Params(double startVolume, double endVolume, double temperature, double mass) {
            this.endVolume = endVolume;
            this.startVolume = startVolume;
            this.temperature = temperature;
            this.mass = mass;
        }
    }

    class Result {
        double W;
        double Q;
        double dH;
        double dU;

        public Result(double w, double q, double dH, double dU) {
            W = w;
            Q = q;
            this.dH = dH;
            this.dU = dU;
        }
    }
}
