package dao;

import entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao {

    void addReview(Review review);

    void updateReview(Review review);

    void deleteReview(Review review);

}
