package eu.mrndeign.matned.data.use;

import static eu.mrndeign.matned.data.use.ConstantValues.*;


public class Measure {


    public static double distance(MatrixCoordinates a, MatrixCoordinates b){
        int aX = a.getX();
        int aY = a.getY();
        int aZ = a.getZ();
        int bX = b.getX();
        int bY = b.getY();
        int bZ = b.getZ();
        return Math.abs(Math.sqrt(((bX-aX)*(bX-aX))+((bY-aY)*(bY-aY))+((bZ-aZ)*(bZ-aZ))));
    }

    public static double drivingTime(double distance_cm, int botSpeed_kmH){
        double distance_km = distance_cm / 100000;
        return distance_km/botSpeed_kmH * getRandom(SPEED_RANDOM_END, SPEED_RANDOM_BEGIN);
    }

    public static double loadUnloadOperationTime(int botSpeed){
        return LOAD_TIME_MINUTES / botSpeed * getRandom(LOAD_RANDOM_END, LOAD_RANDOM_BEGIN);
    }

    public static double loadUnloadOperationTime(int botSpeed, double distance_cm){
        int distance_m = (int) (distance_cm/100);
        if (distance_m < 2) distance_m = 1;
        return LOAD_TIME_MINUTES / botSpeed * getRandom(LOAD_RANDOM_END, LOAD_RANDOM_BEGIN) * distance_cm;
    }

    private static double getRandom(double end, double begin) {
        return (Math.random()*end)+begin;
    }

}
