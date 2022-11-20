package com.pavelryazanov.auction.command.impl;

import com.pavelryazanov.auction.command.Command;
import com.pavelryazanov.auction.exception.CommandException;
import com.pavelryazanov.auction.exception.ServiceException;
import com.pavelryazanov.auction.service.ClientService;
import com.pavelryazanov.auction.service.impl.ClientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        ClientService clientService = ClientServiceImpl.getInstance();
        boolean match = false;
        try {
            match = clientService.authenticate(login,password);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        String page;
        if (match){
            request.setAttribute("client", login);
            page = "pages/main.jsp";
        }
        else {
            request.setAttribute("failEnter","incorrect login or password");
            page = "index.jsp";
        }
        return page;
    }
}
