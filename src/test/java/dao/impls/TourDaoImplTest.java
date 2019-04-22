package dao.impls;

import dao.DbSetup;
import entity.Tour;
import entity.TourType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;


public class TourDaoImplTest extends DbSetup {
    TourDaoImpl tourDao;
    Tour tour = new Tour("PhotoForProject/cinque-terre-340348_960_720.jpg",
            LocalDate.of(2019,11,20), 4, "good tour for you", 450, TourType.TRAINING, 6, 19);
    Tour temp;

    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbSetup.class);
        tourDao = ctx.getBean(TourDaoImpl.class);
    }

    @Test
    public void addTour() {

        tourDao.addTour(tour);
         Assert.assertNotEquals(tour.getId(), 0);
        tourDao.deleteTour(tour);
    }

    @Test
    public void updateTour() {
        tourDao.addTour(tour);
        temp = tourDao.getTourById(tour.getId());
        tourDao.updateTour(new Tour(tour.getId(), "PhotoForProject/cinque-terre-340348_960_720.jpg",
                LocalDate.of(2019,9,20), 3, "good tour for you", 455, TourType.RELAX, 2, 13));
        tour = tourDao.getTourById(tour.getId());
        Assert.assertNotEquals(tour, temp);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteTour() {
        tourDao.addTour(tour);
        tourDao.deleteTour(tour);
        tourDao.getTourById(tour.getId());
    }
}