package com.market.sapphires.sbt.model.datatables.returned;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.sapphires.sbt.entity.LoginUser;
import com.market.sapphires.sbt.util.DataTimeUtil;

import lombok.Data;
import lombok.Getter;

@Data
public class UserDataTables {

    public enum Column {
        /** */
        USERNAME("username"),
        /** */
        FULLNAME("fullname"),
        /** */
        ENABLED("enabled"),
        /** */
        GROUPS("groups"),
        /** */
        COMMENT("comment"),
        /** */
        UPDATED_DATE("updatedDate");

        private Column(String name) {
            this.name = name;
        }

        @Getter
        private String name;
    }

    private int draw;

    private int recordsTotal;

    private int recordsFiltered;

    private List<Map<String, ?>> data = new ArrayList<>();

    public void addToData(LoginUser user) {
        Map<String, Object> d = new HashMap<>();
        d.put("id", user.getIdToString());
        d.put("username", user.getUsername());
        d.put("fullname", user.getFullname());
        d.put("enabled", user.getEnabledString());
        d.put("groups", user.getGroupsString());
        d.put("comment", user.getComment());
        d.put("updatedDate", DataTimeUtil.format(user.getUpdatedDate()));

        this.data.add(d);
    }
}
