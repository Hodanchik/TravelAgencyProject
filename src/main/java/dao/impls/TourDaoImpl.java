package dao.impls;

import dao.TourDao;
import entity.Tour;
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

        jdbcTemplate.update("INSERT INTO public.\"Tour\"(photo, date, duration, description, cost, tour_type, hotel_id, country_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?::\"Tour_type\", ?, ?)",
                new Object[]{tour.getPhoto(), tour.getData(), tour.getDuration(), tour.getDescription(), tour.getCost(), tour.getTour_type().name(),
                        tour.getHotel_id(), tour.getCountry_id()});

        int id = jdbcTemplate.queryForObject("SELECT id FROM Tour WHERE photo = ? and date = ? and duration = ? and description=? " +
                "and cost=? and tour_type=? and hotel_id=? and country_id=?", new Object[]{tour.getPhoto(), tour.getData(), tour.getDuration(),
                tour.getDescription(), tour.getCost(), tour.getTour_type(), tour.getHotel_id(), tour.getCountry_id()}, Integer.class);
        tour.setId(id);
    }
    @Override
    public Tour getTourById (int id){
        String sql = "Select * FROM Tour where ID=?";
        Tour tour = jdbcTemplate.queryForObject(sql,
                new Object[] { id }, new RowMapper<Tour>() {
                    @Override
                    public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Tour tour2  = new Tour();
                        tour2.setId(rs.getInt("id"));
                        tour2.setPhoto(rs.getString("photo"));
                        tour2.setData((rs.getObject("data", LocalDate.class)));

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
