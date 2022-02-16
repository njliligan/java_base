package com.njganlili.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author njgan
 * @description
 * @date 2022/2/13 1:03
 */
public class User implements Serializable {

    private String userName;

    private Integer userAge;

    private String userSex;

    private String userIdCard;

    private String revision;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private String id;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public User setUserAge(Integer userAge) {
        this.userAge = userAge;
        return this;
    }

    public String getUserSex() {
        return userSex;
    }

    public User setUserSex(String userSex) {
        this.userSex = userSex;
        return this;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public User setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
        return this;
    }

    public String getRevision() {
        return revision;
    }

    public User setRevision(String revision) {
        this.revision = revision;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public User setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public User setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public User setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public User setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", revision='" + revision + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", id='" + id + '\'' +
                '}';
    }

}
