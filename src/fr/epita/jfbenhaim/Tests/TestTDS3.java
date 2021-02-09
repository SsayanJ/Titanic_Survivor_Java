package fr.epita.jfbenhaim.Tests;

import fr.epita.jfbenhaim.model.Passenger;
import fr.epita.jfbenhaim.services.PassengerCSVDAO;

import java.io.IOException;
import java.util.List;

public class TestTDS3 {

    public static void test() {
        try {
            List<Passenger> passengerList= PassengerCSVDAO.readAllPredictions();
            int TruePositive = 0;
            int TrueNegative = 0;
            int FalsePositive = 0;
            int FalseNegative = 0;

            for (Passenger passenger:passengerList){
                if(passenger.getSurvived() && passenger.getPredicted()){
                    TruePositive+=1;
                } else if (!passenger.getPredicted() && !passenger.getSurvived()){
                    TrueNegative+=1;
                }else if (!passenger.getPredicted() && passenger.getSurvived()){
                    FalseNegative+=1;
                }else{
                    FalsePositive+=1;
                }
            }

            System.out.println("True Positives: "+TruePositive);
            System.out.println("True Negatives: "+TruePositive);
            System.out.println("False Positives: "+FalsePositive);
            System.out.println("False Negatives: "+FalseNegative);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
