import java.io.*;
import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        String[] line = {"Hey", "How", "Are", "You", "Today"};

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].length(); j++) {
                System.out.println("" + i + line[i]);
                System.out.println();
                System.out.println("" + j + line[i].charAt(j));
                System.out.println();
            }

        }
    }
}
