package com.pavelryazanov.auction.service.impl;

import com.pavelryazanov.auction.controller.dao.impl.ClientDAOImpl;
import com.pavelryazanov.auction.exception.DaoException;
import com.pavelryazanov.auction.exception.ServiceException;
import com.pavelryazanov.auction.service.ClientService;

import java.sql.*;
import java.util.Collection;
import java.util.Properties;

public class ClientServiceImpl implements ClientService {
    private static ClientServiceImpl instance = new ClientServiceImpl();

    private ClientServiceImpl() {
    }

    public static ClientServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        // validate login, pass
        ClientDAOImpl clientDAO = ClientDAOImpl.getInstance();
        boolean match = false;
        try {
            match = clientDAO.authenticate(login, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }
}
