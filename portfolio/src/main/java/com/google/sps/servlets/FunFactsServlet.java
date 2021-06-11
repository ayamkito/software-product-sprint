package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/funfacts")
public final class FunFactsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<String> funFacts = new ArrayList<String>();
        funFacts.add("Some interesting facts 0");
        funFacts.add("Some interesting facts 1");

        // Convert the ArrayList to JSON
        String json = convertToJsonUsingGson(funFacts);

        // Send the jason data as the response
        response.setContentType("text/html;");
        response.getWriter().println(json);
    }

    // Function converts ArrayList<> to Json
    private String convertToJsonUsingGson (ArrayList<String> facts) {
        Gson gson = new Gson();
        String json = gson.toJson(facts);
        return json;
    }

}