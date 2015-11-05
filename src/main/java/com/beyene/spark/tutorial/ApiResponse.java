package com.beyene.spark.tutorial;

import lombok.Data;

@Data
public class ApiResponse {
    private int statusCode;
    private String body;

    public ApiResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
