package com.promineotech.jeep.dao;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import java.sql.SQLException;
import java.util.List;

public interface JeepSalesDao {
    /**
     *
     * @param model
     * @param trim
     * @return
     * @throws SQLException
     */
    List<Jeep> fetchJeeps(JeepModel model, String trim) throws SQLException;
}
