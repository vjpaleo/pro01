package com.pro01.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("fruitGroupDAO")
public class FruitGroupDAO {
	
	private JdbcTemplate myJdbcTemplate;

	public List<FruitGroup> getFoodGroups() {
		return myJdbcTemplate.query("Select * from foodgroups", new RowMapper<FruitGroup>(){

			@Override
			public FruitGroup mapRow(ResultSet rs1, int rowNum) throws SQLException {
				FruitGroup fg = new FruitGroup();
				fg.setId(rs1.getInt("id"));
				fg.setName(rs1.getString("name"));
				fg.setDescription(rs1.getString("description"));
				return fg;
			}
		});
		
	}
	
	public JdbcTemplate getMyJdbcTemplate () {
		return myJdbcTemplate;
	}
	
	@Autowired
	public void setMyJdbcTemplate(DataSource ds) {
		this.myJdbcTemplate = new JdbcTemplate(ds);
	}
}
