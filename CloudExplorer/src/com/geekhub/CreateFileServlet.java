package com.geekhub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/filecreate")
public class CreateFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Paths.get(req.getParameter("path"));
        Files.createDirectories(path.getParent());
        try {
            Files.createFile(path);
            resp.getWriter().write("File successfully created.");
        } catch (FileAlreadyExistsException e) {
            resp.getWriter().write("File already exists: " + e.getMessage());
        }
    }
}