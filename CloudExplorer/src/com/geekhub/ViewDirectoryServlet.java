package com.geekhub;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/dirview", initParams = {
        @WebInitParam(name = "root", value = "c://")
})
public class ViewDirectoryServlet extends HttpServlet {

    private static Path ROOT_PATH;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ROOT_PATH = Paths.get(config.getInitParameter("root"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Path> paths;
        String path = req.getParameter("path");
        try {
            if (Files.isRegularFile(Paths.get(path))) {
                req.getRequestDispatcher("/fileview").forward(req, resp);
            }
        } catch (NullPointerException e) {
        }
        paths = appendLink(path, ROOT_PATH);
        req.setAttribute("list", paths);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private List<Path> appendLink(String text, Path path) throws IOException {
        Path finalPath;
        if (text == null) {
            finalPath = path;
        } else {
            finalPath = Paths.get(text);
        }
        List<Path> paths = Files.walk(finalPath, 1).collect(Collectors.toList());
        paths.sort(new SorterByType());
        return paths;
    }

    private class SorterByType implements Comparator<Path> {
        @Override
        public int compare(Path path1, Path path2) {
            int k = 0;
            if (Files.isDirectory(path1) && Files.isRegularFile(path2)) k = -1;
            if (Files.isDirectory(path2) && Files.isRegularFile(path1)) k = 1;
            return k;
        }
    }
}