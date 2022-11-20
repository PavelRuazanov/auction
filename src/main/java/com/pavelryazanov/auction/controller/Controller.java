package com.pavelryazanov.auction.controller;

import java.io.*;

import com.pavelryazanov.auction.command.Command;
import com.pavelryazanov.auction.command.CommandType;
import com.pavelryazanov.auction.exception.CommandException;
import com.pavelryazanov.auction.exception.ServiceException;
import com.pavelryazanov.auction.pool.ConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/controller")
public class Controller extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String commandString = request.getParameter("command");
        Command command = CommandType.define(commandString);
        String page = null;
        try {
            page = command.execute(request);
        } catch (CommandException e) {
            response.sendError(500);
        }
        String logString = request.getParameter("log");
        String pasString = request.getParameter("pas");
        request.setAttribute("login", logString);
        request.setAttribute("password", pasString);
        request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }
}