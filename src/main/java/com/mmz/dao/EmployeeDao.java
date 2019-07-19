package com.mmz.dao;

import com.mmz.bean.Employee;

/**
 * @author : mengmuzi
 * create at:  2019-07-19  22:02
 * @description:
 */
public interface EmployeeDao {
    //按照员工ID查询员工
    public Employee getEmpById(Integer id);

    //测试增删改查
    public int updateEmployee(Employee employee , Integer id);

    public boolean deleteEmployee(Employee employee);

    public int insertEmployee(Employee employee);

}
