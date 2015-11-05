package com.beyene.spark.tutorial.controller;

import com.beyene.spark.tutorial.model.Model;
import com.beyene.spark.tutorial.ApiResponse;
import com.beyene.spark.tutorial.model.Student;

import java.io.IOException;

/**
 * Created by Mehari.Beyene on 11/4/2015.
 */
public class CreateStudentController extends AbstractController<Student> {

    private Model model;

    public CreateStudentController(Class<Student> classType, Model model) {
        super(classType, model);
        this.model=model;
    }

    @Override
    public ApiResponse process(Student student) throws IOException {
        Student s = model.createStudent(student);
        return new ApiResponse(200,dataToJason(s));
    }
}
