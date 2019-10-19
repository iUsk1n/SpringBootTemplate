package com.market.sapphires.sbt.model;

import com.market.sapphires.sbt.entity.LoginUser;
import com.market.sapphires.sbt.util.DataTimeUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUserModel {

    public LoginUserModel(LoginUser user) {
        this.id = user.getIdToString();
        this.username = user.getUsername();
        this.fullname = user.getFullname();
        this.comment = user.getComment();
        this.groups = user.getGroupsString();
        this.enabled = user.getEnabledString();
        this.createdDate = DataTimeUtil.format(user.getCreatedDate());
        this.updatedDate = DataTimeUtil.format(user.getUpdatedDate());
    }

    private String id;

    private String username;

    private String fullname;

    private String password;

    private String comment;

    private String groups;

    private String enabled;

    private String createdDate;

    private String updatedDate;

    private String version;

}
