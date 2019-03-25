package dao.impls;

import dao.HotelDao;
import entity.FeaturesType;
import entity.Hotel;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addHotel(Hotel hotel) {

        Object [] args = {hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude(), createSqlArray(hotel.getFeatures())};
        jdbcTemplate.update("INSERT INTO public.\"Hotel\" (name, stars, website, lalitude, longitude, features) VALUES (?, ?, ?, ?, ?, ?)",
               args);
        int id=jdbcTemplate.queryForObject("SELECT id FROM Hotel WHERE name=? and stars=? and website=? and lalitude=? and longitude=?",
                new Object []{hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude()}, Integer.class);
        hotel.setId(id);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        jdbcTemplate.update(" UPDATE public.\"Hotel\" SET  name=?, stars=?, website=?, lalitude=?, longitude=?, features=? WHERE id = ?",
                hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude(),createSqlArray(hotel.getFeatures()), hotel.getId());
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        jdbcTemplate.update("DELETE FROM public.\"Hotel\"\n WHERE id = ?", hotel.getId() );
           }

    private Array createSqlArray(List<FeaturesType> list) {
        Array intArray = null;
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            intArray = connection.createArrayOf("public.\"FeaturesType\"", list.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intArray;
    }

}
