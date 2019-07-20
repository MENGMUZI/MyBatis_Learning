package com.mmz.dao;

import com.mmz.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author : mengmuzi
 * create at:  2019-07-19  22:02
 * @description:
 */
public interface EmployeeDao {
    //查询所有员工返回list
    public List<Employee> getAllEmployee();

    //查询全部的封装map
    @MapKey("id")//把查询记录的id作为key的记录封装
    public Map<String,Employee> getAllEmployeeReturnMap();

    //查询单个封装map（列名作为key，值作为value）
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    //按照员工ID查询员工
    public Employee getEmpById(Integer id);

    public Employee getEmpByIdAndEmpName(@Param("id") int id , @Param("empName") String empName);

    public Employee getEmpByIdAndEmpNameByMap(Map<String,Object> map);

    //测试增删改查
    public int updateEmployee(Employee employee , Integer id);

    public boolean deleteEmployee(Employee employee);

    public int insertEmployee(Employee employee);

    public int insertEmployee2(Employee employee);


}
