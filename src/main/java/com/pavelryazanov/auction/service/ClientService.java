package com.pavelryazanov.auction.service;

import com.pavelryazanov.auction.exception.ServiceException;

public interface ClientService {
    boolean authenticate(String login, String password) throws ServiceException;
}
