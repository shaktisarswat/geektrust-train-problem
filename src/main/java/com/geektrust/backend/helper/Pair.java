package com.geektrust.backend.helper;

public class Pair implements Comparable<Pair> {
    public String stationName;
    public Integer distance;

    public Pair(String stationName, Integer distance) {
        this.distance = distance;
        this.stationName = stationName;
    }


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
//        return "Pair{" +
//                "stationName='" + stationName + '\'' +
//                ", distance=" + distance +
//                '}';

        return stationName;
    }

    @Override
    public int compareTo(Pair pair) {
        return pair.getDistance() - this.getDistance();
    }
}
