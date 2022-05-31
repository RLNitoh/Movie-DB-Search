/*
class will represent a single filter. Every time the user adds a filter,
a new Filter object will be created and added to a list. Removing a filter
will remove it from the list. The Filter class will include a method
that determines whether or not hte filter matches a specific Media object.
 */
import java.util.ArrayList;
public class Filter {
    private String field; // for field ex: director or movie
    private String target; // for target, what specifically it's looking for in field

    // constructor
    public Filter(String field, String target) {
        this.field = field;
        this.target = target;
    }
    // getter and setter so I can access them individually.
    public void setField(String newField) {
        this.field = newField;
    }
    public String getField() {
        return field;
    }

    // default constructor
    public Filter() {
        // Auto-generated constructor
    }


    // but this method will see if filter matches a specific media object
    public ArrayList<Media> match(ArrayList<Filter> filterList, ArrayList<Media> currentList) {



        return currentList;
    }

    // method toString allows me to see what a specific Filter object contains
    public String toString() {
        return "Filter: " + field + "- " + target;
    }
}