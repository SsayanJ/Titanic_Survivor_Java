package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Centroid;
import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;
import fr.epita.jfbenhaim.services.PassengerDataService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestTDS2 {

    public static void test() throws IOException {
        List<Passenger> passengerList= PassengerCSVDAO.readAll();
        Map<Integer, Centroid> Centroids= PassengerDataService.getSurvivedCentroids(passengerList);
        int survivorAge = Centroids.get(1).getAverageAge();
        int deceasedAge=Centroids.get(0).getAverageAge();
        Double survivorPClass=Centroids.get(1).getAveragePclass();
        Double deceasedPClass=Centroids.get(0).getAveragePclass();
        Double survivorSex=Centroids.get(1).getAverageSex();
        Double deceseadSex=Centroids.get(0).getAverageSex();
        for (Passenger passenger:passengerList){
            Double currAge=passenger.getAge();
            Double currPClass=passenger.PClassToDouble();
            Double currSex=passenger.SexToDouble();
            Double distanceSurvived=0.0;
            Double distanceDeceased=0.0;
            if (currAge!=null){
                distanceSurvived=+Math.pow((currAge- survivorAge)/survivorAge,2);
                distanceDeceased=+Math.pow((currAge- deceasedAge)/deceasedAge,2);
            }
            if (currPClass!=null){
                distanceSurvived+=Math.pow((currPClass- survivorPClass)/survivorPClass,2);
                distanceDeceased+=Math.pow((currPClass- deceasedPClass)/deceasedPClass,2);
            }
            if (currSex!=null){
                distanceSurvived+=Math.pow((currSex-survivorSex)/survivorSex,2);
                distanceDeceased+=Math.pow((currSex-deceseadSex)/deceseadSex,2);
            }

            distanceSurvived=Math.sqrt(distanceSurvived);
            distanceDeceased=Math.sqrt(distanceDeceased);

            if (distanceDeceased>distanceSurvived){
                passenger.setPredicted("true");
            } else {
                passenger.setPredicted("false");
            }



        }
        PassengerCSVDAO.writeAllPrediction(passengerList, "output_predicted.csv");


    }
}
