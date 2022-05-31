public class Movie extends Media {
    // instance variables
    private String title;
    private String director;
    private String cast;
    private String country;
    private String releaseYear;
    private String rating;
    private String genre;
    private String description;
    private String durationTime;

    // redoing constructor but with durationTime
    public Movie(String title, String director, String cast, String country, String releaseYear,
                 String rating, String genre, String description, String durationTime) {
        super(title, director, cast, country, releaseYear, rating, genre, description);
        this.durationTime = durationTime;
    }



    // toString method that will create a big string of all the instance variables
    public String toString() {
        return "Movie, " + super.toString() + " " + durationTime;
    }
}
