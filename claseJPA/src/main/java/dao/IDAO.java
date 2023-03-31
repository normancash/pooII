package dao;

import java.util.List;

public interface IDAO {

    <T> List<T> findAll(Class<T> clazz,String nameQuery) ;
    <T> void create(T entity);
    <T> void delete(T entity);
    <T> void update(T entity);
    <T> T findById(Long id, Class<T> clazz);


}
