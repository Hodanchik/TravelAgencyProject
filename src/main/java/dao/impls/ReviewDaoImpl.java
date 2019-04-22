package dao.impls;

import dao.ReviewDao;
import entity.Review;
import entity.Tour;
import entity.TourType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addReview(Review review) {
        Object[] arg =  new Object[]{review.getData(), review.getText(), review.getUser_id(), review.getTour_id()};
        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Review\"( date, text, user_id, tour_id) VALUES (?, ?, ?, ?) RETURNING ID",
                arg, Integer.class);

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

    @Override
    public Review getReviewById(int id) {
        String sql = "Select * FROM public.\"Review\" where ID=?";
        Review review = jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new RowMapper<Review>() {
                    @Override
                    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                       Review review2 = new Review();
                        review2.setId(rs.getInt("id"));
                        review2.setData((rs.getObject("date", LocalDate.class)));
                        review2.setText(rs.getString("text"));
                        review2.setUser_id(rs.getInt("user_id"));
                        review2.setTour_id(rs.getInt("tour_id"));
                        return review2;
                    }
                });
        return review;
    }
}
