package com.geektrust;

import com.geektrust.backend.dto.TrainPrinting;
import com.geektrust.backend.entity.Train;
import com.geektrust.backend.entity.TrainA;
import com.geektrust.backend.entity.TrainB;
import com.geektrust.backend.helper.MergeTrain;
import com.geektrust.backend.helper.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> commandLineArguments = new LinkedList<>(Arrays.asList(args));
        run(commandLineArguments);

        List<String> trainAList = new ArrayList<>(Arrays.asList("NDL", "NDL", "KRN", "GHY", "SLM", "NJP", "NGP", "BLR"));
        List<String> trainBList = new ArrayList<>(Arrays.asList("NJP", "GHY", "AGA", "PNE", "MAO", "BPL", "PTA"));

        Train trainA = new TrainA(trainAList);
        Train trainB = new TrainB(trainBList);

        List<Pair> trainAAfterHYB = trainA.getStationListAfterHYB();
        List<Pair> trainBAfterHYB = trainB.getStationListAfterHYB();

        System.out.println(trainAAfterHYB);
        System.out.println(trainBAfterHYB);
        List<Pair> mergeredList = MergeTrain.getMergeredStationList(trainAAfterHYB, trainBAfterHYB);

        System.out.println(mergeredList);
        List<Pair> orderedList = MergeTrain.getOrderedStationList(mergeredList);
        System.out.println(orderedList);
    }

    public static void run(List<String> commandLineArgs) {
        BufferedReader bufferedReader;
        String inputFileName = commandLineArgs.get(0);

        try
        {
            bufferedReader = new BufferedReader(new FileReader(inputFileName));
            String line = bufferedReader.readLine();
            Train trainA=null;
            Train trainB=null;


            // TRAIN_A ENGINE SLM BLR KRN HYB SLM NGP ITJ
            if(line!=null) {
                List<String> listOfTokens = Arrays.asList(line.split(" "));
                trainA=new TrainA(listOfTokens.subList(2,listOfTokens.size()));
            }

            line = bufferedReader.readLine();

//            TRAIN_B ENGINE SRR MAO NJP PNE PTA
            if (line!=null)
            {
                List<String> listOfTokens = Arrays.asList(line.split(" "));
                trainB=new TrainB(listOfTokens.subList(2,listOfTokens.size()));
            }

            // Printing Arrival At HYB
            //ARRIVAL TRAIN_A ENGINE HYB NGP ITJ
            TrainPrinting.printArrivalOfTrain(trainA.getStationListArrivalAtHYB(),"A");
            TrainPrinting.printArrivalOfTrain(trainB.getStationListArrivalAtHYB(),"B");

            List<Pair> mergeredList = MergeTrain.getMergeredStationList(trainA.getStationListAfterHYB(), trainB.getStationListAfterHYB());
            List<Pair> orderedList = MergeTrain.getOrderedStationList(mergeredList);
            TrainPrinting.printDepartureOfTrain(orderedList);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}