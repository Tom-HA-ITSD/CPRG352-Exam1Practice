<%-- 
    Document   : part1
    Created on : Oct 8, 2019, 9:29:15 AM
    Author     : 768661
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 1</title>
    </head>
    <body>
        <h1>CPRG-352 Practice Exam 1</h1>
        <form action="part1" method="post">
            Enter a motivational phase: <input type="text" name="phrase"><br>
            <input type="submit" name="setPhrase" value="Set Phrase">
        </form>
        <h2>${phrase}</h2>
        <a href="part2">Part 2</a>
    </body>
</html>
