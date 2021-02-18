package com.pangpan.controller;

import com.pangpan.dto.DepartDto;
import com.pangpan.service.DeptmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JdbcTempletController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    @Transactional
    public Map<String, Object> map() {

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select  * from department");

        return list.get(0);
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, String> update() {
//        List<Map<String,Object>> list =  jdbcTemplate.queryForList("select  * from department");
        Map<String, String> map = new HashMap<>();

        jdbcTemplate.execute("update department t set t.bumenTablename = '6666' where t.bumenTableid = 1");

//        throw new RuntimeException("erro");
        map.put("success", "0");
        return map;

    }

    @Autowired
    private DeptmentService deptmentService;

    @ResponseBody
    @GetMapping("/dept/{id}")
    public DepartDto getDepartment(@PathVariable Integer id) {
        return deptmentService.getDeptById(id);
    }


//    public DepartDto insertDepartment(){
//        return depe
//    }

}
