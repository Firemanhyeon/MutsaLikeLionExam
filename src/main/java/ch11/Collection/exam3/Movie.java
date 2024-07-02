package ch11.Collection.exam3;

import org.jetbrains.annotations.NotNull;

public class Movie implements Comparable<Movie> {


    private String title;
    private int year;
    private double like;

    public Movie(String title, int year, double like) {
        this.title = title;
        this.year = year;
        this.like = like;
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

    public double getLike() {
        return like;
    }

    public void setLike(double like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", like=" + like +
                '}';
    }

    @Override
    public int compareTo(@NotNull Movie o) {
        return this.title.compareTo(o.title);
    }
}
