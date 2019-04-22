package service.impls;

import dao.ReviewDao;
import entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ReviewService;
@Component

public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void addReview(Review review) {
        reviewDao.addReview(review);
    }

    @Override
    public void updateReview(Review review) {
        reviewDao.updateReview(review);
    }

    @Override
    public void deleteReview(Review review) {
        reviewDao.deleteReview(review);
    }

    @Override
    public Review getReviewById(int id) {
        return null;
    }
}
