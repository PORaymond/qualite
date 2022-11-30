/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DaoImp.PersonDAOImplementation;
import interfaceDao.PersonDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

/**
 *
 * @author tlazr
 */
@WebServlet(urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    PersonDAOImplementation dao;

    @Override
    public void init() {
        dao = new PersonDAOImplementation();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Person pers = new Person();
        pers.setId(id);
        pers.setName(name);

        dao.create(pers);
        List<Person> listPersons = dao.findAll();

        request.setAttribute("listPersons", listPersons);
        String mess = " Merci d avoir inserer  la donnee";
        request.setAttribute("message", mess);
        getServletContext().getRequestDispatcher("/listPersons.jsp").
                forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("m"));
        String action = request.getParameter("act");
        //PersonDAOImplementation dao = new PersonDAOImplementation();
        if (action.equals("delete")) {
            dao.delete(id);

            List<Person> listPersons = dao.findAll();

             

            request.setAttribute("listPersons", listPersons);  // x is attiribute that holds the list of persons from DAO

             getServletContext().getRequestDispatcher("/listPersons.jsp").
                forward(request, response);
        }
    }

}
