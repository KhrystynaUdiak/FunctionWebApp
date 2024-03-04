package com.example.demo3.repository;


import com.example.demo3.model.Equation;
import com.example.demo3.model.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionRepository {
    private final List<Function> functions;
    private static FunctionRepository functionRepository;
    private FunctionRepository(){
        functions = new ArrayList<>();
        functions.add(new Function(Equation.A, 1, 1, 2, 0.5));
    }

    public synchronized static FunctionRepository getFunctionRepository() {
        if (functionRepository == null) {
            functionRepository = new FunctionRepository();
        }
        return functionRepository;
    }

    public double calculate(Function function){
        double result = 0;
        switch (function.getEquation()){
            case A: result = calculateFunctionA(function.getX());
                break;
            case B: result = calculateFunctionB(function.getX());
                break;
            case C: result = calculateFunctionC(function.getX());
        }
        return result;
    }
    public double calculateFunctionA( double x) {
        double a = -1.5;
        double b = 2;
        if (x > 0.7 && x <=1.4) {
            return a * Math.pow(x, 2) * Math.log(x);
        } else if( x <= 0.7){
            return 1;
        } else{
            return Math.exp(a * x) * Math.cos(b * x);
        }
    }
    public double calculateFunctionB( double x) {
        double a = 1.5;
        if (x < 1.7) {
            if(x == 0){
                throw new ArithmeticException();
            }
            return Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2);
        } else if( x == 1.7){
            return a * Math.pow(x, 3) + 7 * Math.sqrt(x);
        } else{
            return Math.log10(x + 7 * Math.sqrt(x));
        }
    }
    public double calculateFunctionC( double x) {
        double a = 2.7;
        double b = -0.3;
        int c = 4;
        if (x < 1.4) {
            return  a*Math.pow(x, 2) + b*x + c;
        } else if( x == 1.4){
            return a/x + Math.sqrt(Math.pow(x, 2) + 1);
        } else{
            return (a + b*x) / Math.sqrt(Math.pow(x, 2) + 1);
        }
    }

    public int countSteps(Function function){
        double start = function.getStart();
        double end = function.getEnd();
        int count = 0;
        while(start <= end){
            count++;
            start += function.getStep();
        }
        return count;
    }

    public double[][] arrayFunctionsValue(Function function ) {
        double start = function.getStart();
        double end = function.getEnd();
        double step = function.getStep();

        double[][] array = new double[countSteps(function)][2];

        for (int i = 0; i < array.length; i++) {
            array[i][0] = start;
            array[i][1] = calculate(function);
            start += step;

            if (start > end) {
                break;
            }
        }
        return array;
    }


    public double sum(double[][] array){
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][1];
        }
        return sum;
    }

    public double average(double[][] array){
        return sum(array)/array.length;
    }


}
