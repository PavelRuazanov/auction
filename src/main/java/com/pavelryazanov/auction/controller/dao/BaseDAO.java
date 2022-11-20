package com.pavelryazanov.auction.controller.dao;

import com.pavelryazanov.auction.entity.AbstractEntity;
import com.pavelryazanov.auction.exception.DaoException;

import java.util.List;

public interface BaseDAO<T extends AbstractEntity> {
    boolean insert(T t) throws DaoException;

    boolean delete(T t) throws DaoException;

    List<T> findAll() throws DaoException;

    T update(T t) throws DaoException;
}
