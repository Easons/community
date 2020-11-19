package com.pangpan.pangpan.mapper;

import com.pangpan.pangpan.dto.DepartDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public DepartDto getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public  int deleteDeptById(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(DepartDto dept);

    @Update("update department  set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(DepartDto dept);


}
