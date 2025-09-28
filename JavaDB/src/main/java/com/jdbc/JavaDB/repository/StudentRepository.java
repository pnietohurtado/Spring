package com.jdbc.JavaDB.repository;

import com.jdbc.JavaDB.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student){
        String sql = "insert into student(rollno, name, marks) values(?,?,?)";
        //System.out.println(student.getRollno() + " " + student.getName() + " " + student.getMarks());
        int rows = jdbc.update(sql, student.getRollno(), student.getName(), student.getMarks());
        System.out.println(rows + " rows affected");
    }

    public List<Student> findAll() {
        String sql = "select * from student where rollno <> ?";


        RowMapper<Student> mapper = new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student student = new Student();
                student.setRollno(rs.getInt("rollno"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));

                return student;
            }
        };
        return jdbc.query(sql, mapper, 0);

        /*
        return jdbc.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setRollno(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });

         */
    }
}
