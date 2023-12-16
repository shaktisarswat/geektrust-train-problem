package com.geektrust.backend.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTrain {

    public static List<Pair> getMergeredStationList(List<Pair> trainAList, List<Pair> trainBList) {
        List<Pair> mergerStationList = new ArrayList<>();
        mergerStationList.addAll(trainAList);
        mergerStationList.addAll(trainBList);
        return mergerStationList;
    }

    public static List<Pair> getOrderedStationList(List<Pair> list) {
        Collections.sort(list);
        return list;
    }
}
