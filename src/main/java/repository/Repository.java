package repository;

import java.util.List;

public interface Repository<T> {
    int add(T t);
    List<T> findAll();
    int update(T t);
    int delete(int id);
}
