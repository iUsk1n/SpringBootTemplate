package com.market.sapphires.sbt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.sapphires.sbt.model.datatables.returned.UserDataTables;
import com.market.sapphires.sbt.repository.LoginUserDao;

@Service
public class LoginUserService {

    @Autowired
    private LoginUserDao dao;

    public UserDataTables getList(
            int draw,
            int start,
            int length,
            Map<String, ?> columns,
            Map<String, ?> order) {

        UserDataTables dts = new UserDataTables();
        dts.setDraw(draw);
        dts.setRecordsTotal(1000);
        dts.setRecordsFiltered(50);

        return dts;
    }
}
