package com.parking.parkinglotbun.servlets;

import com.parking.parkinglotbun.common.CarDto;
import com.parking.parkinglotbun.common.UserDto;
import com.parking.parkinglotbun.ejb.CarsBean;
import com.parking.parkinglotbun.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCar", value = "/AddCar")
public class AddCar extends HttpServlet {
    @Inject
    UserBean userBean;
    @Inject
    CarsBean carsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<UserDto>users=userBean.findAllUsers();
        request.setAttribute("users",users);
        request.getRequestDispatcher("/WEB-INF/pages/addCar.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        String licensePlate=request.getParameter("license_plate");
        String parkingSpot=request.getParameter("parking_spot");
        Long userId=Long.parseLong(request.getParameter("owner_id"));

        carsBean.createCar(licensePlate,parkingSpot,userId);
        response.sendRedirect(request.getContextPath()+"/Cars");
    }
}
