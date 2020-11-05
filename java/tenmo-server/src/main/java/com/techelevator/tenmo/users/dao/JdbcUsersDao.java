package com.techelevator.tenmo.users.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.users.model.Users;


@Component
public class JdbcUsersDao implements UsersDao{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcUsersDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	private Users mapRowToUsers(SqlRowSet result) {  // result has the row to be mapped
        Users user = new Users();                // Create a Java object
        user.setUsername(result.getString("username"));
        user.setUserId(result.getInt("user_id")); 
        return user;   // Return the Java object containing the data from the row
    }

	@Override
	public List<Users> getAllUsers() {
		List<Users> allUsers = new ArrayList<>();
		String sqlGetAllUsers = "SELECT * FROM users";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllUsers);
		
		while (results.next()) {
			Users userResult = mapRowToUsers(results);
			allUsers.add(userResult);
		}
		return allUsers;
	}

}
