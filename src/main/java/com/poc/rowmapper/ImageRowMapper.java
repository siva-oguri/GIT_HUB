package com.poc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.poc.model.Image;



public class ImageRowMapper implements RowMapper<Image> {

@Override
public Image mapRow(ResultSet rs, int arg1) throws SQLException {
Image img = new Image();
img.setVr(rs.getString("vr"));
img.setValue(rs.getString("value"));


        return img;
}


}
