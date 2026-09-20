package br.com.nonnapizza.serlvet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-pizza")
public class CreateNonnaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pizzaName = request.getParameter("pizza-name");

        System.out.println(pizzaName);

        request.getRequestDispatcher("index.html").forward(request, response);

    }
}
