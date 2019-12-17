package com.utm.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cars> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Student",
                (reponse, rownumber) ->
                        new Cars(reponse.getInt("id"),
                                reponse.getString("brand"),
                                reponse.getString("model"),
                                reponse.getString("color"),
                                reponse.getFloat("price")));
    }

    public void save(Cars cars) {
        jdbcTemplate.update(
                "INSERT INTO cars(id,brand,model,color,price) VALUES(?,?,?,?)",
                cars.getId(), cars.getBrand(), cars.getModel(), cars.getColor(), cars.getPrice());
    }

    public void delete(String brand) {
        jdbcTemplate.update(
                "DELETE FROM cars WHERE model = ?", brand);
    }
}
