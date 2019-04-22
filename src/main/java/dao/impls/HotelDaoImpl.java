package dao.impls;

import dao.HotelDao;
import entity.FeaturesType;
import entity.Hotel;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Tour;
import entity.TourType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addHotel(Hotel hotel) {

        Object[] args = {hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude(), createSqlArray(hotel.getFeatures())};
        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Hotel\" (name, stars, website, latitude, longitude, features) " +
                        "VALUES (?, ?, ?, ?, ?, ?) RETURNING ID",
                args, Integer.class);

        hotel.setId(id);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        jdbcTemplate.update(" UPDATE public.\"Hotel\" SET  name=?, stars=?, website=?, latitude=?, longitude=?, features=? WHERE id = ?",
                hotel.getName(), hotel.getStars(), hotel.getWebsite(), hotel.getLalitude(), hotel.getLongitude(), createSqlArray(hotel.getFeatures()), hotel.getId());


    }

    @Override
    public void deleteHotel(Hotel hotel) {
        jdbcTemplate.update("DELETE FROM public.\"Hotel\"\n WHERE id = ?", hotel.getId());
    }

    @Override
    public Hotel getHotelById(int id) {

        String sql = "Select * FROM public.\"Hotel\" where ID=?";

        Hotel hotel = jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new RowMapper<Hotel>() {
                    @Override
                    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Hotel hotel2 = new Hotel();
                        hotel2.setId(rs.getInt("id"));
                        hotel2.setName(rs.getString("name"));
                        hotel2.setStars((rs.getInt("stars")));
                        hotel2.setWebsite(rs.getString("website"));
                        hotel2.setLalitude(rs.getFloat("latitude"));
                        hotel2.setLongitude(rs.getFloat("longitude"));
                        Array features = rs.getArray("features");
                        Object[] array = (Object[]) features.getArray();

                        List<FeaturesType> featuresTypes = new ArrayList<>();
                        for (Object n : array) {
                            featuresTypes.add(FeaturesType.valueOf(n.toString()));
                        }
//
                        hotel2.setFeatures(featuresTypes);
                        return hotel2;
                    }
                });
        return hotel;
    }


    private Array createSqlArray(List<FeaturesType> list) {
        Array intArray = null;
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            intArray = connection.createArrayOf("public.\"FeaturesType\"", list.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intArray;
    }


}
