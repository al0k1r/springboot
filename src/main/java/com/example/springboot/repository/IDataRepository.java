package com.example.springboot.repository;

import com.example.springboot.model.Data;

import java.util.List;

public interface IDataRepository {
    String insert(Data data);
    Data get(int id) throws Exception;
    Data update(Data newData) throws Exception;
    int delete(int id) throws Exception;
    List<Data> getall() throws Exception;
}
