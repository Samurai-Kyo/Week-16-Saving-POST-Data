package com.promineotech.jeep.dao;


import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DefaultJeepSalesDao implements JeepSalesDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<Jeep> fetchJeeps(JeepModel model, String trim) throws SQLException {
        log.info("The fectchJeeps method was called in DAO with model={} and trim={}", model, trim);

        String GET_JEEPS_BY_MODEL_ANDOR_TRIM = "" +
                "Select * " +
                "from models " +
                "where model_id = :model_id and trim_level = :trim_level";

        Map<String,Object> parms = new HashMap<>();
        parms.put("model_id",model.toString());
        parms.put("trim_level",trim);
        return jdbcTemplate.query(GET_JEEPS_BY_MODEL_ANDOR_TRIM, parms, new RowMapper<Jeep>() {
            @Override
            public Jeep mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Jeep.builder()
                        .basePrice(new BigDecimal(rs.getString("base_price")))
                        .modelId(JeepModel.valueOf(rs.getString("model_id")))
                        .modelPK(rs.getLong("model_pk"))
                        .numDoors(rs.getInt("num_doors"))
                        .trimLevel(rs.getString("trim_level"))
                        .wheelSize(rs.getInt("wheel_size"))
                        .build();
            }
        });
    }

}
