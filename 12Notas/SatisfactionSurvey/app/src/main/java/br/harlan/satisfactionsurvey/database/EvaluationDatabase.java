package br.harlan.satisfactionsurvey.database;

import android.util.Log;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.harlan.satisfactionsurvey.business.StatisticsBusiness;
import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.model.services.ObjectModelToParseObject;
import br.harlan.satisfactionsurvey.model.services.ParseObjectToObjectModel;

public class EvaluationDatabase extends BaseDatabase implements ICRUD<EvaluationModel> {

    public EvaluationDatabase(IDatabaseServices databaseServices) {
        super(databaseServices);
    }

    @Override
    public void create(EvaluationModel object) {
        final ParseObject parseObject = ObjectModelToParseObject.getParseObject(object);
        final ParseObject statisticsObject = new StatisticsBusiness(null, null).updateStatistics(object);
        final ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_STATISTICS);
        parseQuery.countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                if (count > 0) {
                    createEvaluation(parseObject, parseQuery, statisticsObject);
                } else createStatistics(parseObject, parseQuery, statisticsObject);
            }
        });
    }

    private void createStatistics(final ParseObject parseObject, final ParseQuery<ParseObject> parseQuery, ParseObject statisticsObject) {
        statisticsObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null)
                    createEvaluation(parseObject, parseQuery, null);
            }
        });
    }

    private void createEvaluation(final ParseObject parseObject, final ParseQuery parseQuery, final ParseObject statisticsObject) {
        parseQuery.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                List<ParseObject> parseObjects = new ArrayList<>();
                parseObjects.add(parseObject);
                if (statisticsObject != null) {
                    statisticsObject.setObjectId(object.getObjectId());
                    parseObjects.add(statisticsObject);
                }
                ParseObject.saveAllInBackground(parseObjects, new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        databaseServices.saveComplete(e);
                    }
                });
            }
        });
    }

    @Override
    public void update(EvaluationModel object) {
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
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(EvaluationModel.CLASS_NAME_EVALUATION);
        parseQuery.orderByDescending("createdAt");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                databaseServices.retrieveComplete(objects, e);
                Log.i("Object createAt", objects.get(0).getCreatedAt().toString());
            }
        });
    }

    @Override
    public void retrieveAll(String className, Date initialDate, Date finalDate) {

    }

    @Override
    public void delete(String objectId, String className) {

    }

    @Override
    public void delete(EvaluationModel object) {

    }
}
