package com.pangpan.service;

import com.pangpan.dto.DepartDto;
import com.pangpan.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public DepartDto getDeptById(int id) {
        return departmentMapper.getDeptById(id);
    }
}
