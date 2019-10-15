package com.market.sapphires.sbt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.sapphires.sbt.entity.LoginUser;
import com.market.sapphires.sbt.model.datatables.returned.UserDataTables;
import com.market.sapphires.sbt.repository.LoginUserDao;

@Service
public class UserService {

    @Autowired
    private LoginUserDao dao;

    public UserDataTables getList(Map<String, String> params) {

        int draw = Integer.parseInt(params.get("draw"));
        int start = Integer.parseInt(params.get("start"));
        int length = Integer.parseInt(params.get("length"));
        List<String> search = params.entrySet().stream()
                .filter(e -> e.getKey().startsWith("columns["))
                .filter(e -> e.getKey().endsWith("][search][value]"))
                .map(e -> e.getValue())
                .collect(Collectors.toList());
        Map<String, String> order = params.entrySet().stream()
                .filter(e -> e.getKey().startsWith("order["))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        UserDataTables.Column[] columns = UserDataTables.Column.values();

        List<List<Object>> searches = new ArrayList<>();
        for (int i = 0; i < search.size(); i++) {
            searches.add(Arrays.asList(columns[i], search.get(i)));
        }

        List<List<Object>> orders = new ArrayList<>();
        for (int i = 0; i < order.size(); i += 2) {
            String keyCol = new StringBuilder("order[").append(i).append("][column]").toString();
            String keyDir = new StringBuilder("order[").append(i).append("][dir]").toString();
            orders.add(Arrays.asList(columns[Integer.parseInt(order.get(keyCol))], order.get(keyDir)));
        }

        List<LoginUser> users = this.dao.find4DataTables(start, length, searches, orders);

        UserDataTables dts = new UserDataTables();
        dts.setDraw(draw);
        dts.setRecordsTotal((int) this.dao.count());
        dts.setRecordsFiltered(2);

        dts.getData();
        users.forEach(u -> {
            dts.addToData(u);
        });

        return dts;
    }
}
