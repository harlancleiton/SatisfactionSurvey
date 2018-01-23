package br.harlan.satisfactionsurvey.database;

import br.harlan.satisfactionsurvey.model.BaseModel;

public interface ICRUD<T extends BaseModel> {
    void create(T object);
    void update(T object);
    void retrieve(String objectId, String className);
    void retrieveAll(String className);
    void delete(String objectId, String className);
    void delete(T object);
}