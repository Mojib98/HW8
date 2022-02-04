package service;

import models.Admin;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{
     int add() throws SQLException;
    List<T> findAll();
    int update() throws SQLException;
    int delete();



}
