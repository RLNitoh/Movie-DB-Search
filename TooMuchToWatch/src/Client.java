/*
Client program that will contain the main method. It will read the data file
and create new Media objects for each record in the file. and then store them
in a list. It will allow the user to add or remove any number of filters.
These filters will be stored in a list called filterList. Each time the user
adds a new filter or removes an existing one the code will search the
masterList and compare it to filterList, then copy those objects into another
list called currentList.
 */

import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;
public class Client {
    public static void main(String[] args) {
        // creating arrayList for list of filters
        ArrayList<Filter> filterList = new ArrayList<>();
        ArrayList<Media> currentList = new ArrayList<>();
        ArrayList<Media> masterList = new ArrayList<>();
        Filter newFilter = null;
        Filter passListToFilter = new Filter();
        DataFileParser mList = new DataFileParser();




        // putting whole main in a loop until the user wants to quit
        char temp = 'z';
        while (temp != 'Q') {
            // prints going to user prompting them with options to search
            Scanner scnr = new Scanner(System.in);
            System.out.println("Current Filters: ");
            System.out.println("_______________");
            System.out.println();
            System.out.println("(A)dd a new filter");
            System.out.println("(R)emove a filter");
            System.out.println("(L)ist matching records");
            System.out.println("(Q)uit");
            System.out.println();
            System.out.println("Enter the letter of your choice: ");
            // getting user input and doing toUpperCase for char to make sure it reads properly
            temp = scnr.nextLine().charAt(0);
            char c = Character.toUpperCase(temp);

            String filter; // variable for filter to be stored in
            String target = "";
            String field = "";
            // start of if statements to check which option the user entered
            // Add Filter
            if (c == 'A') {
                System.out.println("Enter new filter: ");
                filter = scnr.nextLine();
                filter = filter.toLowerCase();

                // switch statement to go through the filters provided setting two variables to put into a Filter
                // object with field and target.
                switch(filter) {
                    case "movie":
                        field = "movie";
                        target = "movie";
                        break;
                    case "series":
                        field = "series";
                        target = "series";
                        break;
                    case "title":
                        field = "title";
                        System.out.println("Enter title: ");
                        target = scnr.nextLine();
                        break;
                    case "director":
                        field = "director";
                        System.out.println("Enter director's name: ");
                        target = scnr.nextLine();
                        break;
                    case "cast":
                        field = "cast";
                        System.out.println("Enter cast member's name: ");
                        target = scnr.nextLine();
                        break;
                    case "country":
                        field = "country";
                        System.out.println("Enter country: ");
                        target = scnr.nextLine();
                        break;
                    case "rating":
                        field = "rating";
                        System.out.println("Enter Rating(G, PG, TV-MA, etc): ");
                        target = scnr.nextLine();
                        break;
                    case "genre":
                        field = "genre";
                        System.out.println("Enter genre: ");
                        target = scnr.nextLine();
                        break;
                    default:
                        break;
                }

                // putting an if to ensure an object is only made IF both fields are not empty
                if (!field.equals("") && !target.equals("")){
                    newFilter = new Filter(field, target);
                }
                if (newFilter != null) {
                    filterList.add(newFilter);
                }
            }
            // Remove Filter
            else if (c == 'R') {
                System.out.println("Enter filter to remove: ");
                System.out.println("current filters: ");
                if (filterList.size() > 0) {
                    for (int i = 0; i < filterList.size(); i++) {
                        System.out.println("" + (i+1) + ". " + filterList.get(i));
                    }
                }
                System.out.println("Please select a filter to remove from the ones above: ");
                int filterToRemove = scnr.nextInt();
                filterList.remove((filterToRemove - 1));
            }
            // Print out List of obj based on filters added
            else if (c == 'L') {
                // MAKE SURE TO INCLUDE SOMETHING WITH FILTER AND DATAFILEPARSER IN THIS IF

                String[] temp1 = mList.readFile();
                masterList = mList.parseData(temp1);
                currentList = passListToFilter.match(filterList, masterList);
                // loop to go through list and print out lines
                for (int i = 0; i < currentList.size(); i++) {
                    System.out.println(currentList.get(i));
                }

            }
            // QUIT, SON!
            else if (c == 'Q') {
                break;
            }
            // this last else will be if something other than the options given are entered
            else {
                System.out.println("Error: Letter entered not a valid option");
                System.out.println("Please enter a valid option (A, R, L, or Q)");
            }
        }
    }
}
