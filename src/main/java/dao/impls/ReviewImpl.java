package dao.impls;

import dao.ReviewDao;
import entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewImpl implements ReviewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addReview(Review review) {
        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Review\"( date, text, user_id, tour_id) VALUES (?, ?, ?, ?) RETURNING ID",
                new Object[]{review.getData(), review.getText(), review.getUser_id(), review.getTour_id()}, Integer.class);
        review.setId(id);
    }

    @Override
    public void updateReview(Review review) {
        jdbcTemplate.update("UPDATE public.\"Review\" SET date=?, text=?, user_id=?, tour_id=? WHERE id = ?",
                review.getData(), review.getText(), review.getUser_id(), review.getTour_id(), review.getId());
    }

    @Override
    public void deleteReview(Review review) {
        jdbcTemplate.update("DELETE FROM public.\"Review\" WHERE id = ?", review.getId());

    }
}
