package dao.impls;

import dao.TourDao;
import entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TourDaoImpl implements TourDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addTour(Tour tour) {

        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Tour\"(photo, date, duration, description, cost, tour_type, hotel_id, country_id) " +
                "VALUES (?, ?, ?, ?, ?, ?::\"Tour_type\", ?, ?) RETURNING ID",
                new Object[] {tour.getPhoto(), tour.getData(), tour.getDuration(), tour.getDescription(), tour.getCost(), tour.getTour_type().name() ,
                tour.getHotel_id(), tour.getCountry_id()}, Integer.class );
        tour.setId(id);
            }

    @Override
    public void updateTour(Tour tour) {
jdbcTemplate.update("UPDATE public.\"Tour\" SET photo=?, date=?, duration=?, description=?, cost=?, tour_type=?::\"Tour_type\", hotel_id=?, country_id=? " +
        "WHERE id = ?",tour.getPhoto(), tour.getData(), tour.getDuration(), tour.getDescription(), tour.getCost(), tour.getTour_type().name(),
        tour.getHotel_id(), tour.getCountry_id(), tour.getId());
    }

    @Override
    public void deleteTour(Tour tour) {
        jdbcTemplate.update("DELETE FROM public.\"Tour\" WHERE id = ?", tour.getId());
            }


}
