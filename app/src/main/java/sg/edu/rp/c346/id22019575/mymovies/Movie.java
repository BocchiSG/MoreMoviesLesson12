package sg.edu.rp.c346.id22019575.mymovies;

import java.io.Serializable;

public class Movie{
    private int _id;
    private String title;
    private String genre;
    private int year;
    private int rate;

    public Movie(int _id, String title, String genre, int year, int rate) {
        this._id = _id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rate = rate;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getRate() {
        return rate;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
