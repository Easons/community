package com.pangpan.service;

import com.pangpan.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@SpringBootTest
class DeptmentServiceTest {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    void getDeptById() {
        departmentMapper.getDeptById(1);
    }
}