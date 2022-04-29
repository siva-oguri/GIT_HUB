package com.poc.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.poc.dao.ImageDAO;
import com.poc.model.Image;
@Repository
public class ImagdeDAOImpl implements ImageDAO {

	
	private NamedParameterJdbcTemplate template;
	public ImagdeDAOImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	
	@Override
	public void insertImage(Image img) {
		 final String sql = "insert into image(id, vr , value) values(id, vr , value)";

	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	.addValue("imgVr", img.getVr())
	 .addValue("imgValue", img.getValue());
	
	        template.update(sql,param, holder);

		
	

	
	SqlParameterSource map = null;
	template.execute(sql,map,new PreparedStatementCallback<Object>() {  
	   
		@Override
		public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			return ps.executeUpdate();
		}  
	}); 
	
}}
