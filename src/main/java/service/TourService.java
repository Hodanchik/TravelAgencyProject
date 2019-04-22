package service;

import entity.Tour;

public interface TourService{

    void addTour(Tour tour);

    void updateTour(Tour tour);

    void deleteTour(Tour tour);

    Tour getTourById(int id);
}
