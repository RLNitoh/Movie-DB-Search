/*
Class to hold the fields of the file read: title, director, cast, country,
release year, rating, duration, genre, and description. Should include
toString methods in both of the subclasses; each one returning a string
indicating the type of media and all of the instance variables.
 */
abstract class Media {
    // instance variables
    protected String title;
    protected String director;
    protected String cast;
    protected String country;
    protected String releaseYear;
    protected String rating;
    protected String genre;
    protected String description;


    // constructor
    public Media(String title, String director, String cast, String country, String releaseYear,
                 String rating, String genre, String description) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.description = description;
    }

    public String toString() {
        return "" + title + " " + director + " " + cast + " " + country + " " + releaseYear + " " + rating + " " + genre + " " + description;
    }
}
