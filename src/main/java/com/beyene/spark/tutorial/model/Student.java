package com.beyene.spark.tutorial.model;

import lombok.Data;

/**
 * Created by Mehari.Beyene on 11/4/2015.
 */
@Data
public class Student implements Validable {

    private String id;
    private String givenName;
    private String lastName;

    @Override
    public boolean isValid() {
        return givenName!=null && lastName!=null;
    }
}
