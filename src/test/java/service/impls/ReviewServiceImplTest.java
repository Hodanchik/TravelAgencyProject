package service.impls;

import dao.ReviewDao;
import entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceImplTest {
    @Mock
    ReviewDao reviewDao;
    Review review = new Review();



    @Test
    public void addReview() {
        reviewDao.addReview(review);
        Mockito.verify(reviewDao).addReview(review);
    }

    @Test
    public void updateReview() {
        reviewDao.updateReview(review);
        Mockito.verify(reviewDao).updateReview(review);
    }

    @Test
    public void deleteReview() {
        reviewDao.deleteReview(review);
        Mockito.verify(reviewDao).deleteReview(review);
    }
}