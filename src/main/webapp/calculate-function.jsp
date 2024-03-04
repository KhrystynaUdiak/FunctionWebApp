<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page import="com.example.demo3.model.Function" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate Function</title>
</head>
<body>

<br/>
<form action="${pageContext.request.contextPath}/calculate" method="post">

    <label>Select Equation:</label>
    <select name="equation">
        <option value="A">Equation A: a * Math.pow(x, 2) * Math.log(x)</option>
        <option value="B">Equation B: Math.PI * Math.pow(x, 2) - 7 / Math.pow(x, 2)</option>
        <option value="C">Equation C: a*Math.pow(x, 2) + b*x + c</option>
    </select>


    <label>X-Value</label>
                        <input type="text"
                               name="x"
                               required="required"
                               value="${Function.x}">


    <label>Start</label> <input type="text"
                               name="start"
                               required="required"
                               value="${Function.start}">

    <label>End</label> <input type="text"
                              name="end"
                              required="required"
                              value="${Function.end}">

    <label>Step</label>
    <input type="text"
           name="step"
           required="required"
           value="${Function.step}">

    <button type="submit" class="btn btn-success">Calculate</button>


</form>


<c:if test="${result != null}">

    <table>
        <tr>
            <td>
                <p>Result is: </p>
            </td>
            <td>
                <p><b>${result}</b></p>
            </td>
        </tr>
    </table>
</c:if>

<c:if test="${countSteps != null}">

    <table>
        <tr>
            <td>
                <p>Amount of steps is: </p>
            </td>
            <td>
                <p><b>${countSteps}</b></p>
            </td>
        </tr>
    </table>
</c:if>


<c:if test="${sum != null}">

    <table>
        <tr>
            <td>
                <p>Sum of function value is: </p>
            </td>
            <td>
                <p><b>${sum}</b></p>
            </td>
        </tr>
    </table>
</c:if>

<c:if test="${average != null}">

    <table>
        <tr>
            <td>
                <p>Average of function value is: </p>
            </td>
            <td>
                <p><b>${average}</b></p>
            </td>
        </tr>
    </table>
</c:if>


</body>
</html>
