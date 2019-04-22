package dao;


import entity.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao {

    void addHotel(Hotel hotel);

    void updateHotel(Hotel hotel);

    void deleteHotel(Hotel hotel);

    Hotel getHotelById(int id);
}
