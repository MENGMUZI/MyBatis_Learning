package com.mmz.dao;


import com.mmz.bean.Lock;

public interface LockDao {

    public Lock getLockById(Integer id);

    public Lock getLockByIdSimple(Integer id);

}
