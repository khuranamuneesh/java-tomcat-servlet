package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = {"/login"},
        initParams = {
                @WebInitParam(name = "userw",value = "Mohit"),
                @WebInitParam(name = "passwordw",value = "1234@Mohit")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
        String user = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userId = getServletConfig().getInitParameter("userw");
        String userPassword = getServletConfig().getInitParameter("passwordw");

        if(!NameValidation.isValidName(user)) {
            out.println("<html><body>");
            out.println("<h2>Invalid Username Format</h2>");
            out.println("<p>Name must start with a capital letter and have at least 3 characters.</p>");
            out.println("<a href='index.jsp'>Back to Login</a>");
            out.println("</body></html>");
        }
        if (!PasswordValidator.isValidPassword(password)) {
            out.println("<html><body>");
            out.println("<h2>Invalid Password Format</h2>");
            out.println("<p>Password must:</p>");
            out.println("<ul>");
            out.println("<li>Be at least 8 characters long</li>");
            out.println("<li>Contain at least one uppercase letter</li>");
            out.println("<li>Contain at least one number</li>");
            out.println("<li>Contain exactly one special character</li>");
            out.println("</ul>");
            out.println("<a href='index.jsp'>Try Again</a>");
            out.println("</body></html>");
            return;
        }

        else if(userId.equals(user) && userPassword.equals(password)){
//            out.println("<html><body>");
//            out.println("<h2>Login successful!</h2>");
//            out.println("<p>Welcome, " + user + "!</p>");
//            out.println("<a href='success.jsp'>hh</a>");
//            out.println("</body></html>");
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            response.sendRedirect("success.jsp");

        }else {
            out.println("<html><body>");
            out.println("<h2>Login failed</h2>");
            out.println("<p>Invalid username or password.</p>");
            out.println("<a href='index.jsp'>Try Again</a>");
            out.println("</body></html>");
        }
        out.close();
    }

}
























// --------------------For Single Users------------------------------

//package servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    private static final String USERNAME = "admin";
//    private static final String PASSWORD = "1234";
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String user = request.getParameter("username");
//        String pass = request.getParameter("password");
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        if (USERNAME.equals(user) && PASSWORD.equals(pass)) {
//            out.println("<html><body>");
//            out.println("<h2>Login successful!</h2>");
//            out.println("<p>Welcome, " + user + "!</p>");
//            out.println("</body></html>");
//        } else {
//            out.println("<html><body>");
//            out.println("<h2>Login failed</h2>");
//            out.println("<p>Invalid username or password.</p>");
//            out.println("<a href='index.jsp'>Try Again</a>");
//            out.println("</body></html>");
//        }
//
//        out.close();
//    }
//}

// --------------------For Multiple Users------------------------------

//package servlets;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    // Predefined multiple users
//    private static final Map<String, String> users = new HashMap<>();
//
//    @Override
//    public void init() throws ServletException {
//        users.put("admin", "admin123");
//        users.put("john", "john123");
//        users.put("alice", "alice123");
//        users.put("bob", "bob123");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        if (users.containsKey(username) && users.get(username).equals(password)) {
//            out.println("<html><body>");
//            out.println("<h2>Login successful!</h2>");
//            out.println("<p>Welcome, " + username + "!</p>");
//            out.println("</body></html>");
//        } else {
//            out.println("<html><body>");
//            out.println("<h2>Login failed</h2>");
//            out.println("<p>Invalid username or password.</p>");
//            out.println("<a href='login.jsp'>Try Again</a>");
//            out.println("</body></html>");
//        }
//
//        out.close();
//    }
//}
