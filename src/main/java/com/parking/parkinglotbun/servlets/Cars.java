package com.parking.parkinglotbun.servlets;

import com.parking.parkinglotbun.common.CarDto;
import com.parking.parkinglotbun.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {
    @Inject
    CarsBean carsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<CarDto> cars=carsBean.findAllCars();
        request.setAttribute("cars",cars);
        request.setAttribute("numberOfFreeParkingSpots", 10);
        request.setAttribute("activePage", "Cars");
        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException{
        String[] carIdsAsString =request.getParameterValues("car_ids");
        if(carIdsAsString!=null)
        {
            List<Long>carIds=new ArrayList<>();
            for (String carIdAsString:carIdsAsString)
            {
                carIds.add(Long.parseLong(carIdAsString));
            }
            carsBean.deleteCarsByIds(carIds);
        }
        response.sendRedirect(request.getContextPath()+"/Cars");
    }
}