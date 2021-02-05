package net.iwillwork4u.sensors.repository.impl;

import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.repository.sensor.SensorRepository;
import net.iwillwork4u.sensors.repository.user.UserRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private SensorRepository sensorRepository;

    public UserRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, SensorRepository sensorRepository) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void create(User user) {
        String INSERT_USER_SQL = "INSERT INTO USER(ID) VALUES (:id)";

        Map<String, Object> userParams = new HashMap<String, Object>();
        userParams.put("id", user.getId());

        jdbcTempleate.update(INSERT_USER_SQL, userParams);

        user.getSensors().stream().forEach(sensor ->{

            Sensor sensorById = .getProductById(cartItemDto.getProductId());

            String INSERT_CART_ITEM_SQL = "INSERT INTO CART_ITEM(ID,PRODUCT_ID,CART_ID,QUANTITY) "
                    + "VALUES (:id, :product_id, :cart_id, :quantity)";

            Map<String, Object> cartItemsParams = new HashMap<String, Object>();
            cartItemsParams.put("id", cartItemDto.getId());
            cartItemsParams.put("product_id", productById.getProductId());
            cartItemsParams.put("cart_id", cartDto.getId());
            cartItemsParams.put("quantity", cartItemDto.getQuantity());

            jdbcTempleate.update(INSERT_CART_ITEM_SQL, cartItemsParams);
        });
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public void update(Long id, User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void addSensor(Long userId, Long sensorId) {

    }

    @Override
    public void removeSensor(Long userId, Long sensorId) {

    }
}
