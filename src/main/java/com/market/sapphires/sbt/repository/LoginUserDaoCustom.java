package com.market.sapphires.sbt.repository;

import java.util.List;

import com.market.sapphires.sbt.entity.LoginUser;

public interface LoginUserDaoCustom {

    public List<LoginUser> find4DataTables(
            int start, int length, List<List<Object>> search, List<List<Object>> order);

}
