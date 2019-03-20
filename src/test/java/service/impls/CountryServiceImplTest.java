package service.impls;

import dao.CountryDao;
import entity.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

    @Mock
    CountryDao countryDao;
    Country country = new Country();



    @Test
    public void addCountry() {
                countryDao.addCountry(country);
               Mockito.verify( countryDao).addCountry(country);
    }

    @Test
    public void updateCountry() {
        countryDao.updateCountry(country);
        Mockito.verify( countryDao).updateCountry(country);
    }

    @Test
    public void deleteCountry() {
        countryDao.deleteCountry(country);
        Mockito.verify( countryDao).deleteCountry(country);
    }
}