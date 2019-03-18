package service.impls;

import dao.HotelDao;
import dao.impls.HotelDaoImpl;
import entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.HotelService;
@Component
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;
    @Override
    public void addHotel(Hotel hotel) {
        hotelDao.addHotel(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelDao.updateHotel(hotel);
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelDao.deleteHotel(hotel);
    }
}
