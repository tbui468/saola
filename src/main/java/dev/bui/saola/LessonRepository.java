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
public class LessonRepository {
    private JdbcTemplate jdbc; 
    private StudentRepository studentRepo;
    private InstructorRepository instructorRepo;

    public LessonRepository(JdbcTemplate jdbc, StudentRepository studentRepo, InstructorRepository instructorRepo) {
        this.jdbc = jdbc;
        this.studentRepo = studentRepo;
        this.instructorRepo = instructorRepo;
    }

    public Iterable<Lesson> findAll() {
        String sql = "SELECT * FROM Lesson";
        return this.jdbc.query(sql, this::mapRowToLesson);
    }

    public Lesson findById(Long id) {
        String sql = "SELECT * FROM Lesson WHERE id=?";
        return this.jdbc.queryForObject(sql, this::mapRowToLesson, id);
    }

    public Lesson save(Lesson lesson) {
        PreparedStatementCreate psc = 
            new PreparedStatementCreatorFactory(
                "INSERT INTO Lesson (instructor, student) VALUES (?, ?)",
                Types.BIGINT, Types.BIGINT
            ).newPreparedStatementCreate(
                Arrays.asList(
                    lesson.getInstructor().getId(),
                    lesson.getStudent().getId()
                )
            ); 

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbc.update(psc, keyHolder);

        lesson.setId(keyHolder.getKey().longValue());

        return lesson;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM Lesson WHERE id=?";
        this.jdbc.update(sql, id);
    }

    private Lesson mapRowToLesson(ResultSet rs, int rowNum) throws SQLException {
        Instructor instructor = this.instructorRepo.findbyId(rs.getLong("instructor"));
        Student student = this.studentRepo.findById(rs.getLong("student"));
        
        return new Lesson(rs.getLong("id"), instructor, student);
    }
}*/
