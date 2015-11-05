package com.beyene.spark.tutorial.controller;

import com.beyene.spark.tutorial.model.EmptyRequestObject;
import com.beyene.spark.tutorial.model.Model;
import com.beyene.spark.tutorial.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Mehari.Beyene on 11/4/2015.
 */
public abstract class AbstractController<T> implements Route {
    protected Model model;
    private Class<T> requestType;

    public AbstractController(Class<T> requestType, Model model) {
        this.requestType = requestType;
        this.model = model;
    }

    public abstract ApiResponse process(T classType) throws IOException;

    public static String dataToJason(Object data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, data);
        return stringWriter.toString();

    }

    @Override
    public Object handle(Request request, Response response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T t=null;
        if(requestType!= EmptyRequestObject.class){
            t = objectMapper.readValue(request.body(), requestType);
        }
        ApiResponse apiResponse = process(t);
        response.status(apiResponse.getStatusCode());
        response.type("application/json");
        response.body(apiResponse.getBody());
        return apiResponse.getBody();

    }
}
