package dao.impls;

import dao.CountryDao;
import entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CountryDaoImpl implements CountryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addCountry(Country country) {
        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Country\"(name) VALUES (?) RETURNING ID;",
                new Object[] { country.getName()}, new int[] {12}, Integer.class);
        country.setId(id);
    }

    @Override
    public void updateCountry(Country country) {
        jdbcTemplate.update("UPDATE public.\"Country\" SET name=? WHERE id = ?;", country.getName(), country.getId());
    }

    @Override
    public void deleteCountry(Country country) {
jdbcTemplate.update("DELETE FROM public.\"Country\" WHERE id=?;", country.getId());
    }
}