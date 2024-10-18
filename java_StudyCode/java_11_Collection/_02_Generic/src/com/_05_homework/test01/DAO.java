package com._05_homework.test01;

//  定义个泛型类DAO<T>,在其中定义一个Map成员变量,Map的键为String类型,值为T类型。
//  分别创建以下方法:
//      (1) public void save(String id,T entity):保存T类型的对象到Map成员变量中
//      (2) public T get(String id):从map 中获取id 对应的对象
//      (3) public void update(String id,T entity):替换map中key为id的内容,改为entity 对象
//      (4)public List<T>list():返回map中存放的所有T对象
//      (5) public void delete(String id):删除指定id对象

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    private Map<String, T> map;

    public DAO() {
        map = new HashMap<String, T>();
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }

    public Map<String, T> getMap() {
        return map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }


    // (1) public void save(String id,T entity):保存T类型的对象到Map成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }


    // (2) public T get(String id):从map 中获取id 对应的对象
    public T get(String id) {
        return map.get(id);
    }


    // (3) public void update(String id,T entity):替换map中key为id的内容,改为entity 对象
    public void update(String id, T entity) {
        map.put(id, entity);
    }


    // (4)public List<T>list():返回map中存放的所有T对象
    public List<T> list() {
        List<T> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }


    // (5) public void delete(String id):删除指定id对象
    public void delete(String id) {
        map.remove(id);
    }
}
