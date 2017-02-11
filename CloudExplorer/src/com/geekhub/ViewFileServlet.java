package com.geekhub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/fileview")
public class ViewFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        List<String> list = Files.lines(Paths.get(path)).collect(Collectors.toList());
        req.setAttribute("text", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}