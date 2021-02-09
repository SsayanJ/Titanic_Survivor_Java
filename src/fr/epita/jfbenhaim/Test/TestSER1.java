package fr.epita.jfbenhaim.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSER1 {
    public static void test() throws IOException {
        String pathname="/home/jean-francois.benhaim/submission/data.csv";
        List<String> lines = Files.readAllLines(new File(pathname).toPath(), StandardCharsets.ISO_8859_1);
        System.out.println(lines.get(1));

        List<List> file_data=new ArrayList<>();

        String header = lines.remove(0);
        for (String line : lines) {
            List<Double> parts = Arrays.asList(line.split(";")).stream()
                    .map(s -> Double.parseDouble(s))
                    .collect(Collectors.toList());
            file_data.add(parts);
        }
        System.out.println(file_data.get(1));
    }
}
