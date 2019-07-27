package com.cskaoyan.wdjava.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WdStudentInsert {

    private int id;
    private int row;
    private int column;
    private String positionName;
    private int positionId;
    private String name;
    private String isLeader;
    private String idNo;
    private String startTermId; // 开始期
    private String currentTermId;
    private String mobile;// 电话
    private String master; // 硕士
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String imgUrl;// 图片
    private String gender; // 性别
    private String school; //
    private String major;
    private String graduateYear;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getStartTermId() {
        return startTermId;
    }

    public void setStartTermId(String startTermId) {
        this.startTermId = startTermId;
    }

    public String getCurrentTermId() {
        return currentTermId;
    }

    public void setCurrentTermId(String currentTermId) {
        this.currentTermId = currentTermId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "WdStudentInsert{" +
                "id=" + id +
                ", row=" + row +
                ", column=" + column +
                ", positionName='" + positionName + '\'' +
                ", positionId=" + positionId +
                ", name='" + name + '\'' +
                ", isLeader='" + isLeader + '\'' +
                ", idNo='" + idNo + '\'' +
                ", startTermId='" + startTermId + '\'' +
                ", currentTermId='" + currentTermId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", master='" + master + '\'' +
                ", birthday=" + birthday +
                ", imgUrl='" + imgUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", graduateYear='" + graduateYear + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
