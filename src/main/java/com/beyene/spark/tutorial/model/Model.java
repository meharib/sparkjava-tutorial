package com.beyene.spark.tutorial.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Model {
    public static final int ID_LENGTH = 10;
    private Sql2o sql2o;

    public Model(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public Student createStudent(Student student){
        try(Connection connection = sql2o.beginTransaction()){
            student.setId(generateRandomId());
            connection.createQuery("insert into sca_db.Student(id, GivenName, LastName) VALUES (:id, :givenName, :lastName)")
                    .addParameter("id", student.getId())
                    .addParameter("givenName", student.getGivenName())
                    .addParameter("lastName", student.getLastName())
                    .executeUpdate();
            connection.commit();
            return student;
        }
    }

    public List<Student> getAllStudents(){
        Connection connection = sql2o.open();
        List<Student> students = connection.createQuery("select * from sca_db.Student")
                .executeAndFetch(Student.class);
        return students;
    }

    private String generateRandomId(){
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
}
