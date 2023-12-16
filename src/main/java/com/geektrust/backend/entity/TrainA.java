package com.geektrust.backend.entity;

import com.geektrust.backend.helper.Pair;
import com.geektrust.backend.helper.StationAndDistanceHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainA implements Train {

    public List<String> trainList;
    HashMap<String, Integer> stationListBeforeHYB;
    private StationAndDistanceHelper stationAndDistanceHelper;

    public TrainA(List<String> trainList) {
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
        stationListBeforeHYB.put("CHN", 0);
        stationListBeforeHYB.put("SLM", 350);
        stationListBeforeHYB.put("BLR", 550);
        stationListBeforeHYB.put("KRN", 900);
        return stationListBeforeHYB;
    }
}
