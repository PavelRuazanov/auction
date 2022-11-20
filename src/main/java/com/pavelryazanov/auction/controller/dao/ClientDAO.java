package com.pavelryazanov.auction.controller.dao;

import com.pavelryazanov.auction.exception.DaoException;

public interface ClientDAO {
    boolean authenticate(String login, String password) throws DaoException;
}
