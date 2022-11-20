package com.pavelryazanov.auction.controller.dao.impl;

import com.pavelryazanov.auction.controller.dao.BaseDAO;
import com.pavelryazanov.auction.controller.dao.ClientDAO;
import com.pavelryazanov.auction.entity.Client;
import com.pavelryazanov.auction.exception.DaoException;
import com.pavelryazanov.auction.pool.ConnectionPool;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class ClientDAOImpl implements BaseDAO<Client>, ClientDAO {


    private static final String SELECT_LOGIN_PASSWORD = "SELECT clients_password FROM clients WHERE clients_login = ?";
    private static ClientDAOImpl instance = new ClientDAOImpl();

    private ClientDAOImpl() {
    }

    public static ClientDAOImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(Client client) {
        return false;
    }

    @Override
    public boolean delete(Client client) {
        throw new UnsupportedOperationException("Delete Client in ClientDAOImpl unsupported");
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) throws DaoException {
        boolean match = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD)) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                match = resultSet.getString(1).equals(password);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return match;
    }
}
