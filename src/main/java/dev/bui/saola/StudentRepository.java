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
public class StudentRepository {
    private JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Iterable<Student> findAll() {
        return this.jdbc.query("SELECT * FROM Student", this::mapRowToStudent);        
    }

    public Student findById(String id) {
        return this.jdbc.queryForObject("SELECT * FROM Student WHERE id=?", this::mapRowToStudent, id);
    }

    public Student save(Student student) {
        //if student id is not null, need to replace student
        if (student.getId() == null) {
            PreparedStatementCreatorFactory pscf = 
                new PreparedStatementCreatorFactory("INSERT INTO Student (name) VALUES (?)", Types.VARCHAR);
            pscf.setReturnGeneratedKeys(true); //default if 'false'. Keyholder returns null if 'false'

            PreparedStatementCreator psc = 
                pscf.newPreparedStatementCreator(
                    Arrays.asList(student.getName())
                );

            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.jdbc.update(psc, keyHolder);

            student.setId(keyHolder.getKey().longValue());

            return student;
        }

        String sql = "UPDATE Student SET name=? WHERE id=?";
        jdbc.update(sql, student.getName(), student.getId());
        return student;
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM Student WHERE id=?";
        jdbc.update(sql, id); 
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        return new Student(rs.getLong("id"), rs.getString("name")); 
    }
}
