package dao;

import entity.Tour;
import org.springframework.stereotype.Repository;

@Repository
public interface TourDao {

    void addTour(Tour tour);

    void updateTour(Tour tour);

    void deleteTour(Tour tour);

    Tour getTourById(int id);

}
