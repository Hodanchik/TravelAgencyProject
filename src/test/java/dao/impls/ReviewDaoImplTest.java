package dao.impls;

import dao.DbSetup;
import dao.ReviewDao;
import entity.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReviewDaoImplTest extends DbSetup {

ReviewDao reviewDao;
Review review = new Review( LocalDate.of(2019,1,20), "Very Interesting tour", 3, 17);
Review temp;

@Before
public void setUp() throws Exception {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbSetup.class);
    reviewDao = ctx.getBean(ReviewDaoImpl.class);
}

    @Test
    public void addReview() {
    reviewDao.addReview(review);
        Assert.assertNotEquals(review.getId(),0);
        reviewDao.deleteReview(review);
    }

    @Test
    public void updateReview() {
        reviewDao.addReview(review);
        temp = reviewDao.getReviewById(review.getId());
        reviewDao.updateReview(new Review(LocalDate.of(2019,1,26), "FINE!", 3, 19));
        review = reviewDao.getReviewById(review.getId());
        Assert.assertNotEquals(review, temp);

    }

    @Test (expected = EmptyResultDataAccessException.class)
    public void deleteReview() {
    reviewDao.addReview(review);
    reviewDao.deleteReview(review);
    reviewDao.getReviewById(review.getId());
    }
}