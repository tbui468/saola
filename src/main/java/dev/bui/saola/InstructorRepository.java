/*

package dev.bui.saola;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorRepository {
    private JdbcTemplate jdbc;

    public InstructorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Iterable<Instructor> findAll() {
        return this.jdbc.query("SELECT * FROM Instructor", this::mapRowToInstructor);        
    }

    public Instructor findById(String id)  {
        String sql = "SELECT * FROM Instructor WHERE id=?";
        return jdbc.queryForObject(sql, this::mapRowToInstructor, id);
    }

    public Instructor save(Instructor instructor) {
        //need to use PreparedStatementCreator to get SQL generated id
        PreparedStatementCreator psc = 
            new PreparedStatementCreatorFactory(
                "INSERT INTO Instructor (name) VALUES (?)",
                Types.VARCHAR
            ).newPreparedStatementCreator(
                Arrays.asList(instructor.getName())
            );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbc.update(psc, keyHolder);

        instructor.setId(keyHolder.getKey().longValue());

        return instructor;
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM Instructor WHERE id=?";
        this.jdbc.update(sql, id);
    }

    private Instructor mapRowToInstructor(ResultSet rs, int rowNum) throws SQLException {
        return new Instructor(rs.getLong("id"), rs.getString("name"));
    }
}*/
