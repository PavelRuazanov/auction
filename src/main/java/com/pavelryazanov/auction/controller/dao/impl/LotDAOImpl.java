package com.pavelryazanov.auction.controller.dao.impl;

import com.pavelryazanov.auction.controller.dao.BaseDAO;
import com.pavelryazanov.auction.entity.Lot;

import java.util.List;

public class LotDAOImpl implements BaseDAO<Lot> {
    @Override
    public boolean insert(Lot lot) {
        return false;
    }

    @Override
    public boolean delete(Lot lot) {
        return false;
    }

    @Override
    public List<Lot> findAll() {
        return null;
    }

    @Override
    public Lot update(Lot lot) {
        return null;
    }
}
