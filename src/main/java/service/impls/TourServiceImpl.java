package service.impls;

import dao.TourDao;
import dao.impls.TourDaoImpl;
import entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TourService;
@Component
public class TourServiceImpl implements TourService {


    @Autowired
private TourDao tourDao;
    @Override
    public void addTour(Tour tour) {
tourDao.addTour(tour);
    }

    @Override
    public void updateTour(Tour tour) {
        tourDao.updateTour(tour);
    }

    @Override
    public void deleteTour(Tour tour) {
        tourDao.deleteTour(tour);
    }
}
