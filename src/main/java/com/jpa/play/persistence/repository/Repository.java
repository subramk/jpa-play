package com.jpa.play.persistence.repository;

import java.io.Serializable;
import java.util.List;

import com.jpa.play.persistence.entity.Model;

public interface Repository {

    <T extends Model> T find(Class<T> clazz, Serializable id);

    <T extends Model> List<T> findAll(Class<T> clazz);

    <T extends Model> List<T> findByQuery(Class<T> clazz, String query);

    <T extends Model> void save(T t);

    <T extends Model> void saveAll(List<T> tList);

    <T extends Model> void update(T t);

    <T extends Model> void delete(T t);
}
