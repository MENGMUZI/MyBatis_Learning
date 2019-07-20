package com.mmz.dao;

import com.mmz.bean.Key;
import com.mmz.bean.Lock;

/**
 * @author : mengmuzi
 * create at:  2019-07-20  16:22
 * @description:
 */
public interface KeyDao {

    public Key getKeyById(Integer id);

    public Key getKeyByIdSimple(Integer id);

}
