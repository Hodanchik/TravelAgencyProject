package entity;

import java.time.LocalDate;
import java.util.Date;

public class Review {

    private int id;
    private LocalDate data;
    private String text;
    private int user_id;
    private int tour_id;

    public Review() {
    }

    public Review(LocalDate data, String text, int user_id, int tour_id) {
        this.data = data;
        this.text = text;
        this.user_id = user_id;
        this.tour_id = tour_id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", data=" + data +
                ", text='" + text + '\'' +
                ", user_id=" + user_id +
                ", tour_id=" + tour_id +
                '}';
    }
}