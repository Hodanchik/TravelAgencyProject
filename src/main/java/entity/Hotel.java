package entity;

import java.util.Set;

public class Hotel {
    private int id;
    private String name;
    private int stars;
    private String website;
    private float lalitude;
    private float longitude;
    private Set<FeaturesType> features;

    public Hotel() {
    }

    public Hotel(int id, String name, int stars, String website, int lalitude, int longitude, Set<FeaturesType> features) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.website = website;
        this.lalitude = lalitude;
        this.longitude = longitude;
        this.features = features;
    }

    public Set<FeaturesType> getFeatures() {
        return features;
    }

    public void setFeatures(Set<FeaturesType> features) {
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public float getLalitude() {
        return lalitude;
    }

    public void setLalitude(float lalitude) {
        this.lalitude = lalitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", website='" + website + '\'' +
                ", lalitude=" + lalitude +
                ", longitude=" + longitude +
                '}';
    }
}
