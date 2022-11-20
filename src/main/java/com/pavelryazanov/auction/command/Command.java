package com.pavelryazanov.auction.command;

import com.pavelryazanov.auction.exception.CommandException;
import com.pavelryazanov.auction.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
