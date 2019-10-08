package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Part1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("phrase") != null){
            String phrase = (String) session.getAttribute("phrase");
            request.setAttribute("phrase", phrase);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String phrase = request.getParameter("phrase");
        
        if(phrase == null || phrase.equals("")){
            //do nothing
        } else{
            session.setAttribute("phrase", phrase);
        }
        
        request.setAttribute("phrase", phrase);
        
        getServletContext().getRequestDispatcher("/WEB-INF/part1.jsp").forward(request, response);
    }
}
