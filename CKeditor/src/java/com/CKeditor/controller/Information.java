
/*
 whatsapp: 1-809-978-5552
 kakaotalk: joanvasquez
 email: yoloprogramo22@gmail.com
 */
package com.CKeditor.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joanvasquez
 */
@WebServlet(name = "information", urlPatterns = {"/information.co"})
public class Information extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Gson gson = new Gson();
        Map<String, String> data = new HashMap<>();
        Map<String, String> error = new HashMap<>();
        String dataToPrint;
        String info = request.getParameter("info");

        try (PrintWriter out = response.getWriter()) {

            if (info == null || info.isEmpty()) {
                error.put("error", "you can't have empty field");
            }

            if (error.isEmpty()) {
                request.getSession(true).setAttribute("information", info);
                data.put("success", "true");
                dataToPrint = gson.toJson(data);
            } else {
                dataToPrint = gson.toJson(error);
            }

            out.println(dataToPrint);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
