package br.harlan.satisfactionsurvey.database;

import java.util.Date;

import br.harlan.satisfactionsurvey.model.BaseModel;

public interface ICRUD<T extends BaseModel> {
    void create(T object);
    void update(T object);
    void retrieve(String objectId, String className);
    void retrieveAll(String className);
    void retrieveAll(String className, Date initialDate, Date finalDate);
    void delete(String objectId, String className);
    void delete(T object);
}