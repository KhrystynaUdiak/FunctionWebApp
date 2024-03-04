package com.example.demo3.model;

public class Function {
    private long id;
    private Equation equation;
    private double x;
    private double step;
    private double start;
    private double end;
    private static int counter = 1;

    public Function(){
        id = counter++;
    }

    public Function(Equation equation, double x, double start, double end, double step){
        this.equation = equation;
        this.x = x;
        this.start = start;
        this.end = end;
        this.step = step;
        id = counter++;
    }

    public long getId() {
        return id;
    }

    public Equation getEquation() {
        return equation;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", step=" + step +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
