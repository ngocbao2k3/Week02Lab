/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 595770
 */
@WebServlet(name = "AgeCalculatorServlet", urlPatterns = {"/ageCal"})
public class AgeCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentAge = request.getParameter("age");
        try
        {
        if(currentAge == null || currentAge.isEmpty())
        {
            request.setAttribute("errorMessage","Please enter your age");
            request.setAttribute("currentAge",currentAge);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
            
        }
        else if(Integer.parseInt(currentAge) > 0)
        {
            request.setAttribute("result", "Your age next birthday will be " + (Integer.parseInt(currentAge)+1));
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
            
        }
        else
        {
            request.setAttribute("errorMessage","Please enter only number");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
            
        }
        }
        catch (NumberFormatException e)
        {
            request.setAttribute("errorMessage","Please enter only number");
             getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        }
        
        
    }

    
   
        
}
