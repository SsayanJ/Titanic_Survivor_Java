package fr.epita.jfbenhaim.services;

import fr.epita.jfbenhaim.model.Centroid;
import fr.epita.jfbenhaim.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerDataService {
    public static List<Passenger> filterSurvived(List<Passenger> passengers, Boolean survived){
        List<Passenger> filteredList=new ArrayList<>();
        for(Passenger passenger :passengers){
            if(passenger.getSurvived().equals(survived)){
                filteredList.add(passenger);
            }
        }
        return filteredList;
    }

    public static int averageAge(List<Passenger> passengers){
        Double averageAge=0.0;
        int count=0; // used to count the number of passenger with valid age in the data
        for (Passenger passenger:passengers){
            Double currAge=passenger.getAge();
            if (currAge>=0){
                averageAge+=currAge;
                count+=1;
            }
        }
        averageAge=averageAge/count;
        return (int) Math.round(averageAge);

    }

    public static Double averagePClass(List<Passenger> passengers){
        Double averagePClass=0.0;
        int count=0; // used to count the number of passenger with valid Pclass in the data
        for (Passenger passenger:passengers){
            Double currPClass=passenger.PClassToDouble();
            if (currPClass!=null){
                averagePClass+=currPClass;
                count+=1;
            }
        }
        averagePClass=averagePClass/count;
        return averagePClass;

    }

    public static Double averageSex(List<Passenger> passengers){
        Double averageSex=0.0;
        int count=0; // used to count the number of passenger with valid Pclass in the data
        for (Passenger passenger:passengers){
            Double currPClass=passenger.SexToDouble();
            if (currPClass!=null){
                averageSex+=currPClass;
                count+=1;
            }
        }
        averageSex=averageSex/count;
        return averageSex;

    }

    public static Map<String,Double> calculateAgeDistribution(List<Passenger> passengers){
        Map<String,Double> distrib= new HashMap<>();
        String currentAge;
        for(Passenger passenger:passengers){
            currentAge= String.valueOf((int) Math.floor(passenger.getAge()));
            Double actualCount = distrib.get(currentAge);
            distrib.put(currentAge , actualCount == null ? 1 : actualCount + 1);

        }
        return distrib;
    }

    public static Map<Passenger.PassengerClass,Double> calculatePClassDistribution(List<Passenger> passengers){
        Map<Passenger.PassengerClass,Double> distribPClass= new HashMap<>();
        Passenger.PassengerClass currentPClass;
        for(Passenger passenger:passengers){
            currentPClass= passenger.getPassengerClass();
            Double actualCount = distribPClass.get(currentPClass);
            distribPClass.put(currentPClass , actualCount == null ? 1 : actualCount + 1);

        }
        return distribPClass;
    }

    public static Map<Integer, Centroid> getSurvivedCentroids(List<Passenger> passengerList){
        // Create a Survivors and Deceased groups
        List<Passenger> Survivors= filterSurvived(passengerList,true);
        List<Passenger> Deceased= filterSurvived(passengerList,false);

        // Averages for the deceased group
        int averageAgeDeceased= averageAge(Deceased);
        Double averagePClassDeceased= averagePClass(Deceased);
        Double averageSexDeceased= averageSex(Deceased);


        // averages for the Survivors group
        int averageAgeSurvivors= averageAge(Survivors);
        Double averagePClassSurvivors= averagePClass(Survivors);
        Double averageSexSurvivors= averageSex(Survivors);


        // Create centroids and the map
        Centroid deceasedCentroid=new Centroid();
        Centroid survivorCentroid=new Centroid();
        deceasedCentroid.setAverageAge(averageAgeDeceased);
        deceasedCentroid.setAveragePclass(averagePClassDeceased);
        deceasedCentroid.setAverageSex(averageSexDeceased);
        survivorCentroid.setAverageAge(averageAgeSurvivors);
        survivorCentroid.setAveragePclass(averagePClassSurvivors);
        survivorCentroid.setAverageSex(averageSexSurvivors);

        Map<Integer,Centroid>  centroids= new HashMap<>();
        centroids.put(0,deceasedCentroid);
        centroids.put(1,survivorCentroid);

        return centroids;
    }
}
