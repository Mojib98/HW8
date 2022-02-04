package service;

import models.Admin;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{
     int add() ;
    List<T> findAll();
    int update() ;
    int delete();



}
