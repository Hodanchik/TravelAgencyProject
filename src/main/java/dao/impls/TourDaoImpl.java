package dao.impls;

import dao.TourDao;
import entity.Tour;
import entity.TourType;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Repository
public class TourDaoImpl implements TourDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addTour(Tour tour) {
        Object[] arg = new Object[]{tour.getPhoto(), tour.getData(), tour.getDuration(), tour.getDescription(), tour.getCost(), tour.getTour_type().name(),
                tour.getHotel_id(), tour.getCountry_id()};
        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Tour\"(photo, date, duration, description, cost, tour_type, hotel_id, country_id) " +
                "VALUES (?, ?, ?, ?, ?, ?::\"Tour_type\", ?, ?) RETURNING ID", arg, Integer.class);
        tour.setId(id);
    }

    @Override
    public Tour getTourById(int id) {
        String sql = "Select * FROM public.\"Tour\" where ID=?";
        Tour tour = jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new RowMapper<Tour>() {
                    @Override
                    public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Tour tour2 = new Tour();
                        tour2.setId(rs.getInt("id"));
                        tour2.setPhoto(rs.getString("photo"));
                        tour2.setData((rs.getObject("date", LocalDate.class)));
                        tour2.setDuration(rs.getInt("duration"));
                        tour2.setDescription(rs.getString("description"));
                        tour2.setCost(rs.getInt("cost"));
                        tour2.setTour_type(TourType.valueOf(rs.getString("tour_type")));
                        tour2.setHotel_id(rs.getInt("hotel_id"));
                        tour2.setCountry_id(rs.getInt("country_id"));
                        return tour2;
                    }
                });
        return tour;
    }


    @Override
    public void updateTour(Tour tour) {
        jdbcTemplate.update("UPDATE public.\"Tour\" SET photo=?, date=?, duration=?, description=?, cost=?, tour_type=?::\"Tour_type\", hotel_id=?, country_id=? " +
                        "WHERE id = ?", tour.getPhoto(), tour.getData(), tour.getDuration(), tour.getDescription(), tour.getCost(), tour.getTour_type().name(),
                tour.getHotel_id(), tour.getCountry_id(), tour.getId());
    }

    @Override
    public void deleteTour(Tour tour) {
        jdbcTemplate.update("DELETE FROM public.\"Tour\" WHERE id = ?", tour.getId());
    }


}
