package fr.epita.jfbenhaim.services;

import fr.epita.jfbenhaim.model.Passenger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class PassengerCSVDAO {
    public static List<Passenger> readAll() throws IOException {
        String pathname="/home/jean-francois.benhaim/submission/data.csv";
        List<String> lines = Files.readAllLines(new File(pathname).toPath(), StandardCharsets.ISO_8859_1);

        List<Passenger> passengerList=new ArrayList<>();
        String header = lines.remove(0);
        for (String line : lines) {
            List<String> parts = Arrays.asList(line.split(";"));
            for (int i=0; i<parts.size();i++){
                parts.set(i,parts.get(i).trim());
            }
            Passenger currPassenger= new Passenger();
            currPassenger.setName(parts.get(0));
            currPassenger.setPassengerClass(parts.get(1));
            currPassenger.setAge(parts.get(2));
            currPassenger.setSex(parts.get(3));
            currPassenger.setSurvived(parts.get(4));
            passengerList.add(currPassenger);

        }
        // Sort the list of passenger by descending age
        List<Passenger> sortedPassengerList = passengerList.stream()
                .sorted(Comparator.comparing(Passenger::getAge).reversed())
                .collect(Collectors.toList());
        for (Passenger passenger :sortedPassengerList){
            System.out.println(passenger);
        }

        return sortedPassengerList;
    }

    public static void writeAll(List<Passenger> passengerList, String filename) throws IOException {
        FileWriter csvWriter = new FileWriter("output/" + filename);
        csvWriter.append("PClass");
        csvWriter.append(";");
        csvWriter.append("Name");
        csvWriter.append(";");
        csvWriter.append("Sex");
        csvWriter.append(";");
        csvWriter.append("Age");
        csvWriter.append(";");
        csvWriter.append("Survived");
        csvWriter.append("\n");
        List<String> rows=new ArrayList<>();
        for (Passenger passenger: passengerList){
            rows.add(passenger.getPassengerClass()+";"+passenger.getName()+";"+
                    passenger.getSex()+";"+passenger.getAge()+";"+passenger.getSurvived()+"\n"
                    );
        }
        for (String row : rows) {
            csvWriter.append(row);
            ;
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static void writeAllPrediction(List<Passenger> passengerList, String filename) throws IOException {
        FileWriter csvWriter = new FileWriter("output/" + filename);
        csvWriter.append("PClass");
        csvWriter.append(";");
        csvWriter.append("Name");
        csvWriter.append(";");
        csvWriter.append("Sex");
        csvWriter.append(";");
        csvWriter.append("Age");
        csvWriter.append(";");
        csvWriter.append("Survived");
        csvWriter.append(";");
        csvWriter.append("Predicted");
        csvWriter.append("\n");
        List<String> rows=new ArrayList<>();
        for (Passenger passenger: passengerList){
            rows.add(passenger.getPassengerClass()+";"+passenger.getName()+";"+
                    passenger.getSex()+";"+passenger.getAge()+";"+passenger.getSurvived()
                    +";"+passenger.getPredicted()+"\n"
            );
        }
        for (String row : rows) {
            csvWriter.append(row);
            ;
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static List<Passenger> readAllPredictions() throws IOException {
        String pathname="/home/jean-francois.benhaim/submission/output/output_predicted.csv";
        List<String> lines = Files.readAllLines(new File(pathname).toPath(), StandardCharsets.ISO_8859_1);

        List<Passenger> passengerList=new ArrayList<>();
        String header = lines.remove(0);
        for (String line : lines) {
            List<String> parts = Arrays.asList(line.split(";"));
            for (int i=0; i<parts.size();i++){
                parts.set(i,parts.get(i).trim());
            }
            Passenger currPassenger= new Passenger();
            currPassenger.setName(parts.get(1));
            currPassenger.setPassengerClass(parts.get(0));
            currPassenger.setAge(parts.get(3));
            currPassenger.setSex(parts.get(2));
            currPassenger.setSurvived(parts.get(4));
            currPassenger.setPredicted(parts.get(5));
            passengerList.add(currPassenger);

        }
        // Sort the list of passenger by descending age
        List<Passenger> sortedPassengerList = passengerList.stream()
                .sorted(Comparator.comparing(Passenger::getAge).reversed())
                .collect(Collectors.toList());
        for (Passenger passenger :sortedPassengerList){
            System.out.println(passenger);
        }

        return sortedPassengerList;
    }
}
