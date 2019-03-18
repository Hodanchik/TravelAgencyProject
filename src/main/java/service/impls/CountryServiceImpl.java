package service.impls;

import dao.CountryDao;
import dao.impls.CountryDaoImpl;
import entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.CountryService;
@Component
public class CountryServiceImpl  implements CountryService {

    @Autowired
    private CountryDao countryDao;
    @Override
    public void addCountry(Country country) {
       countryDao.addCountry(country);
    }

    @Override
    public void updateCountry(Country country) {
        countryDao.updateCountry(country);
    }

    @Override
    public void deleteCountry(Country country) {
        countryDao.deleteCountry(country);
    }
}
