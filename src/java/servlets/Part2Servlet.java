package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Person;

public class Part2Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String path = getServletContext().getRealPath("/WEB-INF/list.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String phrase = "";
        
        if(session.getAttribute("phrase") == null){
            response.sendRedirect("part1");
        } else{
            phrase = (String) session.getAttribute("phrase");
        }
        
        request.setAttribute("phrase", phrase);
        
        Person person;
        ArrayList<Person> people = new ArrayList<>();
        String personStr;
        String[] personAr;
        
        for(personStr = br.readLine(); personStr != null; personStr = br.readLine()) {
            personAr = personStr.split(",");
            person = new Person(personAr[0], Double.parseDouble(personAr[1]));
            people.add(person);
        }
        
        double average = 0;
        double ageTotal = 0;
        
        for(int i = 0; i < people.size(); i++){
            ageTotal += people.get(i).getAge();
        }
        
        average = ageTotal/people.size();
        
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String path = getServletContext().getRealPath("/WEB-INF/list.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // to write to files
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
        
        String phrase = "";
        
        if(session.getAttribute("phrase") == null){
            response.sendRedirect("part1");
        } else{
            phrase = (String) session.getAttribute("phrase");
        }
        
        request.setAttribute("phrase", phrase);
        
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        double age;
        
        if(ageStr == null || ageStr.equals("") || name == null || name.equals("")){
            //do nothing
        } else{
            try{
                age = Double.parseDouble(ageStr);
                pw.println(name + "," + age);
            } catch(NumberFormatException e){
                //do nothing
            }
        }
        
        pw.close();
        
        Person person;
        ArrayList<Person> people = new ArrayList<>();
        String personStr;
        String[] personAr;
        
        for(personStr = br.readLine(); personStr != null; personStr = br.readLine()){
            personAr = personStr.split(",");
            person = new Person(personAr[0], Double.parseDouble(personAr[1]));
            people.add(person);
        }
        
        double average = 0;
        double ageTotal = 0;
        
        for(int i = 0; i < people.size(); i++){
            ageTotal += people.get(i).getAge();
        }
        
        average = ageTotal/people.size();
        
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
    }
}
