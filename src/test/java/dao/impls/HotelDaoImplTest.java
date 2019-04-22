package dao.impls;


import dao.DbSetup;
import entity.FeaturesType;
import entity.Hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HotelDaoImplTest extends DbSetup {
   HotelDaoImpl hotelDao;

    Hotel hotel = new Hotel("newHotel", 4, "www.newHotel.com", 3.3425f, -23.342f,
            Arrays.asList(FeaturesType.BALCONY,FeaturesType.BREAKFAST));
Hotel temp;
    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbSetup.class);
        hotelDao = ctx.getBean(HotelDaoImpl.class);
    }
    @Test
    public void addHotel() {
        hotelDao.addHotel(hotel);
        Assert.assertNotEquals(hotel.getId(), 0);
        hotelDao.deleteHotel(hotel);
    }

    @Test
    public void updateHotel() {
        hotelDao.addHotel(hotel);
        temp = hotelDao.getHotelById(hotel.getId());
        hotelDao.updateHotel(new Hotel(hotel.getId(),"LOLLLL", 4, "www.newHotel.com", 11.3425f, -11.342f,
                Arrays.asList(FeaturesType.BREAKFAST)));
      hotel = hotelDao.getHotelById(hotel.getId());
        Assert.assertNotEquals(hotel, temp);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteHotel() {
        hotelDao.addHotel(hotel);
        hotelDao.deleteHotel(hotel);
       hotelDao.getHotelById(hotel.getId());
    }
}