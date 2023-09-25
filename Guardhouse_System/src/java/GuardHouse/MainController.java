/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GuardHouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ariff
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "/ErrorTest.jsp";
    private static final String SUCCESS = "/SuccessTest.jsp";
    private static final String MAINPAGE = "/mainPage.jsp";
    private static final String CHECKIN = "/CheckInPage.jsp";
    private static final String NODATA = "/NoDataFound.jsp";
    private static final String ALREADY = "/AlreadyCheckedIn.jsp";
    private static final String OUTPUT = "/QueryPage.jsp";
    private final MainDAO dao;

    public MainController() throws ClassNotFoundException {
        super();
        dao = new MainDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward;
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("search")) {
            User user = new User();
            String ID = request.getParameter("QueryValue");
            user.setIdentification(ID);
            dao.SearchUser(ID);
            int counter = user.getCounter();
            if (counter > 0) {
                request.setAttribute("IDE", request.getParameter("QueryValue"));
                forward = CHECKIN;
                counter--;
            } else {
                forward = NODATA;
            }
        } else if (action.equalsIgnoreCase("checkin")) {
            int output = dao.CheckIn(request.getParameter("ID"));
            if (output == 0) {
                forward = ALREADY;
            } else {
                forward = MAINPAGE;
            }
        } else if (action.equalsIgnoreCase("checkout")) {
            String ID = request.getParameter("Identification");
            String CIn = request.getParameter("CheckIn");
            dao.CheckOut(ID, CIn);
            forward = MAINPAGE;
        } else if (action.equalsIgnoreCase("back")) {
            forward = MAINPAGE;
        } else if (action.equalsIgnoreCase("QueryVis")) {
            List<User> searchResults = dao.SearchVisitor(request.getParameter("SearchValue"));
            request.setAttribute("Output", searchResults);
            forward = OUTPUT;
        } else {
            forward = ERROR;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward;
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("register")) {
            User user = new User();
            String IDType = request.getParameter("IDType");
            String VisitorType = request.getParameter("VisitorType");
            String ID = request.getParameter("ID");
            String FullName = request.getParameter("FullName");
            String BriefStart = request.getParameter("BriefStart");
            String BriefEnd = request.getParameter("BriefEnd");
            String Company = request.getParameter("Company");
            user.setIdentificationType(IDType);
            user.setVisitorType(VisitorType);
            user.setIdentification(ID);
            user.setFullName(FullName);
            user.setBriefingDateStart(BriefStart);
            user.setBriefingDateEnd(BriefEnd);
            user.setCompany(Company);
            dao.AddUser(user);
            dao.CheckIn(ID);
            forward = MAINPAGE;
        } else {
            forward = ERROR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
