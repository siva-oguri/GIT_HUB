package com.poc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.model.Study;



public class SeriesRowMapper implements RowMapper<Series> {

@Override
public Series mapRow(ResultSet rs, int arg1) throws SQLException {
	Series series = new Series();
	series.setVr(rs.getString("vr"));
	series.setValue(rs.getString("value"));


        return series;
}


}
