package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "SampleServlet", value = "/SampleServlet")
public class SampleServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter responseBody = response.getWriter();

        response.setContentType("text/html");

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        responseBody.println(String.format("<h1 align=\"center\">Today: %s</h1>", localDate.format(formatter)));

        responseBody.println("<h1 align=\"center\">Sample Servlet GET method processing</h1>");
        responseBody.println("<h3 align=\"center\">Request from: " + request.getRemoteHost() + "</h3>");

        String client = request.getParameter("client");
        if (client == null) {
            client = "anonymous user";
        }
        responseBody.println("<h3 align=\"center\">Hi, " + client + " </h3>");
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
