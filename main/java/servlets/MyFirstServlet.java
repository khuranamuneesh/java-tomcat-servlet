package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID = 11L;

    public MyFirstServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>My First Servlet</h1>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}



