package com.geekhub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/fileremove")
public class RemoveFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Paths.get(req.getParameter("path"));
        try {
            Files.delete(path);
            resp.getWriter().write("File successfully deleted.");
        } catch (NoSuchFileException e) {
            resp.getWriter().write("No such file: " + e.getMessage());
        }
    }
}