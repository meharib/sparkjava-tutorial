package com.beyene.spark.tutorial;

import com.beyene.spark.tutorial.controller.CreateStudentController;
import com.beyene.spark.tutorial.controller.FindStudentController;
import com.beyene.spark.tutorial.model.EmptyRequestObject;
import com.beyene.spark.tutorial.model.Model;
import com.beyene.spark.tutorial.model.Student;
import org.sql2o.Sql2o;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String[] args) {

        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/sca_db","app", "app_password");
        Model model = new Model(sql2o);

        post("/create", new CreateStudentController(Student.class,model));
        get("/all", new FindStudentController(EmptyRequestObject.class, model));


    }

}
