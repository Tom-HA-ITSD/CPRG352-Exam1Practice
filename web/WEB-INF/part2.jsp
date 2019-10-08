<%-- 
    Document   : part2
    Created on : Oct 8, 2019, 9:29:26 AM
    Author     : 768661
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 2</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <h2>${phrase}</h2>
        <form action="part2" method="post">
            Name: <input type="text" name="name"><br>
            Age: <input type="text" name="age"><br>
            <input type="submit" name="addPerson" value="Add">
        </form>
        <br>
        Average age is: ${average}
    </body>
</html>
