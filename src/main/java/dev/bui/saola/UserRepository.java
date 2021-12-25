package dev.bui.saola;

import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    public User save(User user) {
        //need to save User (and add primary key to User object, and then return it)
        String sql = "INSERT INTO User (username, password) VALUES (?, ?)";
        this.jdbc.update(sql, user.getUsername(), user.getPassword());

        return user;
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM User WHERE username=?";
        return this.jdbc.queryForObject(sql, this::mapRowToUser, username);
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("username"), rs.getString("password"));
    }
}
