package com.cskaoyan.wdjava.mapper;


import com.cskaoyan.wdjava.bean.WdStudentInsert;

public interface WdInsertMapper {

    void insertStudentInfo(WdStudentInsert studentInsert);

    void insertSeatArrange(WdStudentInsert studentInsert);

    void updateStudentMessage(WdStudentInsert update);

    void updateStudentMessageSeatArrange(WdStudentInsert update);
}