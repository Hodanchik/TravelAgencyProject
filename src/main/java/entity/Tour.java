package entity;

import java.awt.*;
import java.time.Period;
import java.util.Date;

public class Tour {
    private int id;
    private Image photo;
    private Date data;
    private Period duration;
    private String description;
    private double cost;
    private  TourType tour_type;
    private int hotel_id;
    private int country_id;



    public Tour() {
    }




    public Period getDuration() {
        return duration;
    }

    public void setDuration(Period duration) {
        this.duration = duration;
    }

    public TourType getTour_type() {
        return tour_type;
    }

    public void setTour_type(TourType tour_type) {
        this.tour_type = tour_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", photo=" + photo +
                ", data=" + data +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", hotel_id=" + hotel_id +
                ", country_id=" + country_id +
                '}';
    }
}
