package com.cskaoyan.wdjava.service;

import com.cskaoyan.wdjava.bean.WdStudentInfo;

public interface WdStudentInfoService {
    WdStudentInfo queryStudentByName(String username);

    WdStudentInfo queryStudentById(int id);
}
