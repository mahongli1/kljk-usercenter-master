package com.kljk.usercenter.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@ApiModel(value = "用户")
public class Users {
    @ApiModelProperty(value = "用户id",hidden = true)

    private Integer id;
    @ApiModelProperty(value = "username2")
    private String username;
    @ApiModelProperty(value = "password")

    private String password;
    @ApiModelProperty(value = "kljk_Identity_id",hidden = true)

    private int kljk_Identity_id;
    @ApiModelProperty(value = "status",hidden = true)

    private  int status;
    @ApiModelProperty(value = "createTime",hidden = true)

    private Date createTime;

    public Users() {
    }

    public Users(Integer id, String username, String password, int kljk_Identity_id, int status, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.kljk_Identity_id = kljk_Identity_id;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKljk_Identity_id() {
        return kljk_Identity_id;
    }

    public void setKljk_Identity_id(int kljk_Identity_id) {
        this.kljk_Identity_id = kljk_Identity_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", kljk_Identity_id=" + kljk_Identity_id +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
