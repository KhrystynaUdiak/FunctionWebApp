package com.example.demo3.controller;

import com.example.demo3.model.Equation;
import com.example.demo3.model.Function;
import com.example.demo3.repository.FunctionRepository;
import jakarta.json.Json;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "calcServlet", value = "/calculate")
public class CalculateFunctionServlet extends HttpServlet {
    private FunctionRepository functionRepository;

    public void init() {
        functionRepository = FunctionRepository.getFunctionRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("equation", Equation.values());
        request.getRequestDispatcher("/calculate-function.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Equation equation = Equation.valueOf(request.getParameter("equation"));
        double x = Double.parseDouble(request.getParameter("x"));
        double step= Double.parseDouble(request.getParameter("step"));
        double start = Double.parseDouble(request.getParameter("start"));
        double end = Double.parseDouble(request.getParameter("end"));

        Function function = new Function(equation, x, start, end, step);
        double result = functionRepository.calculate(function);
        double countSteps = functionRepository.countSteps(function);
        double[][] arrayFunctionsValue = functionRepository.arrayFunctionsValue(function);

        double sum = functionRepository.sum(arrayFunctionsValue);
        double average = functionRepository.average(arrayFunctionsValue);


        request.setAttribute("result", result);
        request.setAttribute("countSteps", countSteps);
        request.setAttribute("arrayFunctionsValue", arrayFunctionsValue);
        request.setAttribute("sum", sum);
        request.setAttribute("average", average);
        request.getRequestDispatcher("/calculate-function.jsp").forward(request, response);
    }

    public void destroy() {
    }


}