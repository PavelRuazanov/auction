package com.pavelryazanov.auction.command.impl;

import com.pavelryazanov.auction.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "index.jsp";
    }
}
