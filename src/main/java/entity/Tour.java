package entity;


import java.sql.Date;
import java.time.LocalDate;

public class Tour {
    private int id;
    private String photo;
    private LocalDate data;
    private int duration;
    private String description;
    private int cost;
    private  TourType tour_type;
    private int hotel_id;
    private int country_id;




    public Tour() {
    }

    public Tour(String photo, LocalDate data, int duration, String description, int cost, TourType tour_type, int hotel_id, int country_id) {
        this.photo = photo;
        this.data = data;
        this.duration = duration;
        this.description = description;
        this.cost = cost;
        this.tour_type = tour_type;
        this.hotel_id = hotel_id;
        this.country_id = country_id;
    }

    public Tour(int id, String photo, LocalDate data, int duration, String description, int cost, TourType tour_type, int hotel_id, int country_id) {
        this.id = id;
        this.photo = photo;
        this.data = data;
        this.duration = duration;
        this.description = description;
        this.cost = cost;
        this.tour_type = tour_type;
        this.hotel_id = hotel_id;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public TourType getTour_type() {
        return tour_type;
    }

    public void setTour_type(TourType tour_type) {
        this.tour_type = tour_type;
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
                ", photo='" + photo + '\'' +
                ", data=" + data +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", tour_type=" + tour_type +
                ", hotel_id=" + hotel_id +
                ", country_id=" + country_id +
                '}';
    }


}
