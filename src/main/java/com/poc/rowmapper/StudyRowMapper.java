package com.poc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.model.Image;
import com.poc.model.Study;



public class StudyRowMapper implements RowMapper<Study> {

@Override
public Study mapRow(ResultSet rs, int arg1) throws SQLException {
	Study study = new Study();
	study.setVr(rs.getString("vr"));
	study.setValue(rs.getString("value"));


        return study;
}


}
