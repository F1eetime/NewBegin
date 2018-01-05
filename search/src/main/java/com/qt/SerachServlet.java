package com.qt;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerachServlet extends HttpServlet {

    static List<String> list = new ArrayList<>();

    static {
        list.add("ajax");
        list.add("ajax get");
        list.add("back");
        list.add("black");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String keyword = req.getParameter("keyword");

        List<String> list2 = getList(keyword);
        //System.out.println(JSONArray.fromObject(list2));
        resp.getWriter().write(JSONArray.fromObject(list2).toString());
    }

    public List<String> getList(String keyword) {

        List<String> list1 = new ArrayList<>();
        for (String str : list) {
            if (str.contains(keyword)) {
                list1.add(str);
            }
        }
        return list1;
    }
}
