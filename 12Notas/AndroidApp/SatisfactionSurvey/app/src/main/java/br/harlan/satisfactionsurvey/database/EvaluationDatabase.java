package br.harlan.satisfactionsurvey.database;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class EvaluationDatabase extends BaseDatabase implements ICRUD<EvaluationModel> {

    public EvaluationDatabase(IDatabaseServices databaseServices) {
        super(databaseServices);
    }

    @Override
    public void create(EvaluationModel object) {
        ParseObject parseObject = new ParseObject(object.getClassName());
        parseObject.put("name", object.getName());
        parseObject.put("company", object.getCompany());
        parseObject.put("email", object.getEmail());
        parseObject.put("telephone", object.getTelephone());
        parseObject.put("comments", object.getComments());
        parseObject.put("typeEvaluation", object.getTypeEvaluation());
        parseObject.put("noteKnowledge", object.getNoteKnowledge());
        parseObject.put("noteCommunication", object.getNoteCommunication());
        parseObject.put("noteCommitment", object.getNoteCommitment());
        parseObject.put("noteCordiality", object.getNoteCordiality());
        parseObject.put("satisfaction", object.getSatisfaction());
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
