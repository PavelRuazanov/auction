package com.pavelryazanov.auction.command;

import com.pavelryazanov.auction.command.impl.AddClientCommand;
import com.pavelryazanov.auction.command.impl.DefaultCommand;
import com.pavelryazanov.auction.command.impl.LoginCommand;
import com.pavelryazanov.auction.command.impl.LogoutCommand;

public enum CommandType {
    ADD_CLIENT(new AddClientCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand());
    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command define(String commandString) {
        CommandType current = CommandType.valueOf(commandString.toUpperCase());
        return current.command;
    }
}
