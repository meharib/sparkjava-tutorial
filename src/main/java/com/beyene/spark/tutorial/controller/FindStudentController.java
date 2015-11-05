package com.beyene.spark.tutorial.controller;

import com.beyene.spark.tutorial.ApiResponse;
import com.beyene.spark.tutorial.model.EmptyRequestObject;
import com.beyene.spark.tutorial.model.Model;
import com.beyene.spark.tutorial.model.Student;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mehari.Beyene on 11/4/2015.
 */
public class FindStudentController extends AbstractController<EmptyRequestObject> {

    private Model model;

    public FindStudentController(Class<EmptyRequestObject> classType, Model model) {
        super(classType, model);
        this.model=model;
    }

    @Override
    public ApiResponse process(EmptyRequestObject emptyRequestObject) throws IOException {
        List<Student> allStudents = model.getAllStudents();
        System.out.println("allStudents = " + allStudents.size());
        return new ApiResponse(200,dataToJason(allStudents));
    }
}
