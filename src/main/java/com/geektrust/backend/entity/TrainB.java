package com.geektrust.backend.entity;

import com.geektrust.backend.helper.Pair;
import com.geektrust.backend.helper.StationAndDistanceHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainB implements Train {

    public List<String> trainList;
    HashMap<String, Integer> stationListBeforeHYB;
    private StationAndDistanceHelper stationAndDistanceHelper;

    public TrainB(List<String> trainList) {
        this.trainList = trainList;
        stationListBeforeHYB = getStationBeforeHYB();
        stationAndDistanceHelper = new StationAndDistanceHelper();
    }


    public List<Pair> getStationListAfterHYB() {
        List<Pair> stationListAfterHYB = new ArrayList<>();

        for (String s : trainList) {
            if (!stationListBeforeHYB.containsKey(s) && !s.equals("HYB")) {
                Integer distanceAfterHYD = stationAndDistanceHelper.getDistance(s) - stationAndDistanceHelper.getDistance("HYB");
                stationListAfterHYB.add(new Pair(s, distanceAfterHYD));
            }
        }
        return stationListAfterHYB;
    }

    public List<Pair> getStationListArrivalAtHYB() {
        List<Pair> stationListTillHYB = new ArrayList<>();

        for (String s : trainList) {
            if (!stationListBeforeHYB.containsKey(s)) {
                Integer distanceAfterHYD = stationAndDistanceHelper.getDistance(s) - stationAndDistanceHelper.getDistance("HYB");
                stationListTillHYB.add(new Pair(s, distanceAfterHYD));
            }
        }
        return stationListTillHYB;
    }

    @Override
    public HashMap<String, Integer> getStationBeforeHYB() {
        stationListBeforeHYB = new HashMap<>();
        stationListBeforeHYB.put("TVC", 0);
        stationListBeforeHYB.put("SRR", 300);
        stationListBeforeHYB.put("MAQ", 600);
        stationListBeforeHYB.put("MAO", 1000);
        stationListBeforeHYB.put("PNE", 1400);
        return stationListBeforeHYB;
    }

}
