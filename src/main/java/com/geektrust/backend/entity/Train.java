package com.geektrust.backend.entity;

import com.geektrust.backend.helper.Pair;

import java.util.HashMap;
import java.util.List;

public interface Train {
    List<Pair> getStationListAfterHYB();
    List<Pair> getStationListArrivalAtHYB();

    HashMap<String, Integer> getStationBeforeHYB();
}

