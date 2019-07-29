package com.cskaoyan.wdjava.service;

import com.cskaoyan.wdjava.bean.WdStudentInsert;

public interface WdInsertService {

    boolean insertStudentMessage(WdStudentInsert studentInsert);

    boolean updateStudentMessage(WdStudentInsert update);
}
