package com.junky.springboot.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


public class User {

  private String account;
  private String uid;
  private String userName;
  private long male;
  private String deviceToken;


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public long getMale() {
    return male;
  }

  public void setMale(long male) {
    this.male = male;
  }


  public String getDeviceToken() {
    return deviceToken;
  }

  public void setDeviceToken(String deviceToken) {
    this.deviceToken = deviceToken;
  }

}
