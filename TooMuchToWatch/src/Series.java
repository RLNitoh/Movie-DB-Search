public class Series extends Media {
    // instance variables
    private String title;
    private String director;
    private String cast;
    private String country;
    private String releaseYear;
    private String rating;
    private String genre;
    private String description;
    private String durationSeasons;

    //redoing constructor but with durationSeasons
    public Series(String title, String director, String cast, String country, String releaseYear,
                  String rating, String genre, String description, String durationSeasons) {
        super(title, director, cast, country, releaseYear, rating, genre, description);
        this.durationSeasons = durationSeasons;
    }

    // toString method that will create a big string of all the instance variables
    public String toString() {
        return "TV Show, " + super.toString() + " " + durationSeasons;
    }
}
