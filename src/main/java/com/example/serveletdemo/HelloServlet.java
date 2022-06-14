package com.example.serveletdemo;

import com.example.serveletdemo.Models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


@WebServlet(name = "helloServlet", value ={"/server"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        EntityManagerFactory Emf = Persistence.createEntityManagerFactory("default");
        EntityManager Em = Emf.createEntityManager();

        Student student = new Student();
        student.setId(1L);
        student.setNames("Leila");
        Em.getTransaction().begin();
        Em.persist(student);
        Em.getTransaction().commit();
        Em.close();
        message = "Hello World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String param1 = request.getParameter("name");
        System.out.println("param1 value:"+param1);

        String path = request.getServletPath();
        System.out.println(path);

        ArrayList<String> Students = new ArrayList<String>();
        Students.add("leila");
        Students.add("Grace");
        Students.add("Keza");
        switch (path) {
            case "/new":
                RequestDispatcher dispatcher = request.getRequestDispatcher("pages/addStudent.jsp");
                dispatcher.forward(request,response);
                break;

            case "/list":
                request.setAttribute("Students", Students);
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("pages/listStudents.jsp");
                dispatcher2.forward(request,response);
                break;
        }
    }

    public void destroy() {
    }
}