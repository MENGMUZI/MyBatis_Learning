package com.mmz.dao;

import com.mmz.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author : mengmuzi
 * create at:  2019-07-19  22:02
 * @description:
 */
public interface EmployeeDao {
    //查询所有员工
    public List<Employee> getAllEmployee();

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
