package com.promineotech.jeep.service;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import java.sql.SQLException;
import java.util.List;

public interface JeepSalesService {
    /**
     * @param model
     * @param trim
     * @return
     */
    List<Jeep> fetchJeeps(JeepModel model, String trim) throws SQLException;

}
