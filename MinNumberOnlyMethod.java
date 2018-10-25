package ru.minnumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MinNumberOnlyMethod {


    public int findMinNaturalNumber(String filePath) {

        List<Integer> reference = new ArrayList<>(1_000_001);
        for (int i = 1; i <= 1_000_001; i++) {
            reference.add(i);
        }
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {

            for (String part : in.readLine().split("\\s+")) {

                int i = Integer.parseInt(part);
                if (i > 0 && i < 1000001) {

                    reference.set(i - 1, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = 1;

        for (int i = 0; i < 1000001; i++) {
            if (reference.get(i) != null) {
                result = reference.get(i);
                break;
            }
        }
        return result;
    }
}
