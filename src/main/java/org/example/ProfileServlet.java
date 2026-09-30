package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null ||
                session.getAttribute("username") == null) {
            response.sendRedirect(
                    request.getContextPath() + "/login.html");
            return;
        }

        String username = (String) session.getAttribute("username");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>User Profile</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<a href='dashboard'>Back to Dashboard</a><br><br>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}