package service.impls;

import dao.HotelDao;
import entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class HotelServiceImplTest {
@Mock
    HotelDao hotelDao;
Hotel hotel = new Hotel();
    @Test
    public void addHotel() {
        hotelDao.addHotel(hotel);
        Mockito.verify(hotelDao).addHotel(hotel);
    }

    @Test
    public void updateHotel() {
        hotelDao.updateHotel(hotel);
        Mockito.verify(hotelDao).updateHotel(hotel);
    }

    @Test
    public void deleteHotel() {
        hotelDao.deleteHotel(hotel);
        Mockito.verify(hotelDao).deleteHotel(hotel);
    }
}