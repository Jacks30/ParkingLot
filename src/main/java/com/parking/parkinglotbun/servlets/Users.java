package com.parking.parkinglotbun.servlets;
import com.parking.parkinglotbun.common.UserDto;
import com.parking.parkinglotbun.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    UserBean userBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<UserDto> users=userBean.findAllUsers();
        request.setAttribute("users",users);
        request.setAttribute("activePage", "Users");
        request.getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException{}
}