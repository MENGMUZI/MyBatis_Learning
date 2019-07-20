package com.mmz.bean;

import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-07-20  15:52
 * @description:
 */
public class Lock {

    private Integer id;
    private String lockName;
    private List<Key> keys;//锁的所有钥匙
    // 1-1关联  1-n关联  n-n关联 问题：外键放在哪张表？
    // 1对n：外键一定放在多的一边
    // n对n；找中间表

    public Lock() {
    }

    public Lock(Integer id, String lockName, List<Key> keys) {
        this.id = id;
        this.lockName = lockName;
        this.keys = keys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                ", keys=" + keys +
                '}';
    }
}
