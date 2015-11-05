package com.beyene.spark.tutorial.model;

/**
 * Created by Mehari.Beyene on 11/5/2015.
 */
public class EmptyRequestObject implements Validable {
    @Override
    public boolean isValid() {
        return true;
    }
}
