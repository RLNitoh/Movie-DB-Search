/*
class handles reading the provided data file. For each record in the file,
a new Media object (either movie or series from Media.java) will be created
and added to list of Media objects. Class will return the list of objects.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class DataFileParser {
    private String[] line = new String[7788];
    private String[] parsingLine = new String[14];
    Media currentLine;

    Scanner scnr = null; // just creating scanner outside of try/catch

    // The FileInputStream constructor throws a FileNotFoundException (which is a checked
    //  exception), so the compiler forces you to handle it
    public String[] readFile() {
        try {
            scnr = new Scanner(new FileInputStream("src/netflix_titles.csv"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File Not Found!");
            System.exit(0);
        }
        int lineCounter = 0;
        while (scnr.hasNext()) {
            line[lineCounter] = scnr.nextLine();
            lineCounter++;
        }
        return line;
    }

    public ArrayList<Media> parseData(String[] line) {
        ArrayList<Media> masterList = new ArrayList<>();

        // loop that runs through every line
        for (int i = 0; i < line.length; i++) {
            int endOfLine = 0; // counter for end of line to keep from going out of bounds
            String temp = ""; // temp string to store results
            int counter = 0; // counter for counting parsingLine
            boolean isInQuotes = false; // boolean to keep track of whether is inside of quotes or not.
            // loop runs through every character in line
            for (int j = 0; j < line[i].length(); j++) {
                // making a check for the end of the line
                if (endOfLine >= line[i].length()) {
                    temp = "";
                    counter = 0;
                    isInQuotes = false;
                    break;
                }
                // if to check for comma
                else if (line[i].charAt(j) == ',') {
                    // this if will check if the comma is inside quotes
                    if (isInQuotes) {
                        temp += line[i].charAt(j);
                    } else { // this else will just set the temp to the array if it is not inside quotes
                        parsingLine[counter] = temp;
                        counter++;
                        temp = ""; // setting temp back to empty for the next element.
                        isInQuotes = false; // setting variable back to false as IF current char is a comma and not in quotes, it's the end of that element.
                    }
                }
                // if to check for quotes
                else if (line[i].charAt(j) == '"') {
                    isInQuotes ^= true;
                    temp += line[i].charAt(j);
                }
                // this last else is if it's not a comma or a quote it just needs to be added to temp
                else {
                    temp += line[i].charAt(j);
                }

                endOfLine++;
            }
            // this if is to determine if the current line is a movie or tv series
            if (parsingLine[1].equals("Movie")) {
                currentLine = new Movie(parsingLine[2], parsingLine[3], parsingLine[4], parsingLine[5], parsingLine[6], parsingLine[7], parsingLine[8], parsingLine[9], parsingLine[10]);
            } else if (parsingLine[1].equals("TV Show")) {
                currentLine = new Series(parsingLine[2], parsingLine[3], parsingLine[4], parsingLine[5], parsingLine[6], parsingLine[7], parsingLine[8], parsingLine[9], parsingLine[10]);
            }
            // empty back out parsingLine
            Arrays.fill(parsingLine, "");

            // NOW, at the end of everything assign the currentLine obj into ArrayList
            masterList.add(currentLine);
        }
        return masterList;
    }
}