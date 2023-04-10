package com.example.mevenproject.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class AdditionRequest {

    @NonNull
    private double firstElement;
    @NonNull
    private double secondElement;

}
