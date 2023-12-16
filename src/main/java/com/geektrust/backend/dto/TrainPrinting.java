package com.geektrust.backend.dto;

import com.geektrust.backend.helper.Pair;

import java.util.ArrayList;
import java.util.List;

public class TrainPrinting {

    public static void printArrivalOfTrain(List<Pair> stationList, String type) {
        List<String> stationListName = getStationListName(stationList);
        List<String> result = new ArrayList<>();
        if (type.equals("A")) {
            result.add("ARRIVAL");
            result.add("TRAIN_A");
            result.add("ENGINE");
            result.addAll(stationListName);
        } else {
            result.add("ARRIVAL");
            result.add("TRAIN_B");
            result.add("ENGINE");
            result.addAll(stationListName);
        }
        print(result);
    }

    private static List<String> getStationListName(List<Pair> stationList) {
        List<String> stationListName = new ArrayList<>();

        for (Pair pair : stationList) {
            stationListName.add(pair.stationName);
        }
        return stationListName;
    }

    public static void printDepartureOfTrain(List<Pair> stationList) {
        List<String> stationListName = getStationListName(stationList);

        List<String> result = new ArrayList<>();
        if (stationList.size() == 0) {
            result.add("JOURNEY_ENDED");
        } else {
            result.add("DEPARTURE");
            result.add("TRAIN_AB");
            result.add("ENGINE");
            result.add("ENGINE");
            result.addAll(stationListName);
        }
        print(result);
    }

    private static void print(List<String> result) {

        StringBuilder resultant = new StringBuilder();
        for (String s : result) {
            resultant.append(s);
            resultant.append(" ");
        }
        System.out.println(resultant.toString().trim());
    }
}
