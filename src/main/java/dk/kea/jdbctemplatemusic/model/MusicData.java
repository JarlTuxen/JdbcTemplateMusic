package dk.kea.jdbctemplatemusic.model;

public class MusicData {
    private String artist;
    private String title;
    private int year;
    private String company;

    public MusicData(){}

    public MusicData(String artist, String title, int year, String company) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.company = company;
    }

    // Getters and setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Artist: " + artist + ", Title: " + title + ", Year: " + year + ", Record Company: " + company;
    }
}
