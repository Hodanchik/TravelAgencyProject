package dao;

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
//int id = jdbcTemplate.("INSERT INTO public.\"Hotel\" (name, stars, website, lalitude, longitude, features) VALUES (?, ?, ?, ?, ?, ?) RETURNING ID;",
//        new Object [] {hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude(), hotel.getFeatures()},
//        new int[] {12, 4, 12, 6, 6, 1111}, Integer.class);
        Object [] args = {hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude(), createSqlArray(hotel.getFeatures())};
        int id=jdbcTemplate.queryForObject("INSERT INTO public.\"Hotel\" (name, stars, website, lalitude, longitude, features) VALUES (?, ?, ?, ?, ?, ?)RETURNING ID;",
               args,  Integer.class);
        hotel.setId(id);
    }

//    @Override
//    public void save(Hotel hotel) {
//        args = {hotel.getName(), hotel.getStars(), hotel.getWebsite(),
//                hotel.getLalitude(), hotel.getLongitude(), createSqlArray(hotel.getFeatures())};
//        hotel.setId(jdbcTemplate.queryForObject(ADD_HOTEL_QUERY, args, Integer.class));
//    }


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
