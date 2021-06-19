package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.ContactsTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This servlet will query the databse created for the inputs that have been registered by the FormHandlerServlet.
@WebServlet("/contact-list")
public class FormQueryServlet extends HttpServlet{ 
    @Override 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> queryDatabase =
            Query.newEntityQueryBuilder().setKind("Contacts").setOrderBy(OrderBy.desc("name")).build();
        QueryResults<Entity> results = datastore.run(queryDatabase);

        List<ContactsTask> contacts = new ArrayList<>();
        while(results.hasNext()){
            Entity entity = results.next();
            
            long id = entity.getKey().getId();
            String name = entity.getString("name");
            String email = entity.getString("email");

            ContactsTask contact = new ContactsTask(id, name, email);
            contacts.add(contact);            
        }
        Gson gson = new Gson();

        response.setContentType("application/json;");
        response.getWriter().println(gson.toJson(contacts)); 
        
    } 
}   