package service.impls;

import dao.TourDao;
import entity.Tour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class TourServiceImplTest {
    @Mock
    TourDao tourDao;
    Tour tour = new Tour();



    @Test
    public void addTour() {
        tourDao.addTour(tour);
        Mockito.verify(tourDao).addTour(tour);
    }

    @Test
    public void updateTour() {
        tourDao.updateTour(tour);
        Mockito.verify(tourDao).updateTour(tour);
    }

    @Test
    public void deleteTour() {
        tourDao.deleteTour(tour);
        Mockito.verify(tourDao).deleteTour(tour);
    }
}