package br.harlan.satisfactionsurvey.database;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.model.ObjectModelToParseObject;

public class EvaluationDatabase extends BaseDatabase implements ICRUD<EvaluationModel> {

    public EvaluationDatabase(IDatabaseServices databaseServices) {
        super(databaseServices);
    }

    @Override
    public void create(EvaluationModel object) {
        ParseObject parseObject = ObjectModelToParseObject.getParseObject(object);
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                databaseServices.saveComplete(e);
            }
        });
    }

    @Override
    public void update(EvaluationModel object){
        create(object);
    }

    @Override
    public void retrieve(String objectId, String className) {
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(className);
        parseQuery.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                databaseServices.retrieveComplete(object, e);
            }
        });
    }

    @Override
    public void retrieveAll(String className) {
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(className);
        parseQuery.orderByDescending("createdAt");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                databaseServices.retrieveComplete(objects, e);
            }
        });
    }

    @Override
    public void delete(String objectId, String className) {

    }

    @Override
    public void delete(EvaluationModel object) {

    }
}
