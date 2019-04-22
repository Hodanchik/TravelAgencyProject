package dao.impls;

import dao.CountryDao;
import entity.Country;
import entity.Tour;
import entity.TourType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


@Repository
public class CountryDaoImpl implements CountryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addCountry(Country country) {
        Object[] arg = new Object[]{country.getName()};
        int id = jdbcTemplate.queryForObject("INSERT INTO public.\"Country\"(name) VALUES (?) RETURNING ID",
                arg, Integer.class);

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

    @Override
    public Country getCountryById(int id) {
        String sql = "Select * FROM public.\"Country\" where ID=?";
        Country country = jdbcTemplate.queryForObject(sql,
                new Object[]{id}, new RowMapper<Country>() {
                    @Override
                    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Country country2 = new Country();
                        country2.setId(rs.getInt("id"));
                        country2.setName(rs.getString("name"));

                        return country2;
                    }
                });
        return country;
    }
}