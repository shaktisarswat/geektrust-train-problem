package com.geektrust.backend.helper;

import java.util.HashMap;

public class StationAndDistanceHelper {
    private HashMap<String, Integer> mappingStationAndDistAfterHYD;

    public StationAndDistanceHelper() {
        mappingStationAndDistAfterHYD = getMapping();
    }

    private HashMap<String, Integer> getMapping() {
        mappingStationAndDistAfterHYD = new HashMap<>();
        mappingStationAndDistAfterHYD.put("HYB", 0);
        mappingStationAndDistAfterHYD.put("NGP", 400);
        mappingStationAndDistAfterHYD.put("ITJ", 700);
        mappingStationAndDistAfterHYD.put("BPL", 800);
        mappingStationAndDistAfterHYD.put("AGA", 1300);
        mappingStationAndDistAfterHYD.put("NDL", 1500);
        mappingStationAndDistAfterHYD.put("PTA", 1800);
        mappingStationAndDistAfterHYD.put("NJP", 2200);
        mappingStationAndDistAfterHYD.put("GHY", 2700);
        return mappingStationAndDistAfterHYD;
    }

    public Integer getDistance(String station) {
        return mappingStationAndDistAfterHYD.get(station);
    }
}
