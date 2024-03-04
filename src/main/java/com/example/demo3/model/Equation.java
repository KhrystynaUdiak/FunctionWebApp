package com.example.demo3.model;

public enum Equation {
    A("a * Math.pow(x, 2) * Math.log(x)"),
    B("Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2)"),
    C("a*Math.pow(x, 2) + b*x + c");
    private String equation;
    private Equation(String equation){
        this.equation = equation;
    }
}
