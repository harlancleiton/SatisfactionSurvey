package br.harlan.satisfactionsurvey.database;

import android.util.Log;

import com.parse.CountCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.model.services.ParseObjectToObjectModel;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class StatisticsDatabase extends BaseDatabase implements ICRUD<StatisticsModel> {

    StatisticsModel statisticsModel = StatisticsSingleton.getInstance();

    private StatisticsDatabase.OnStatisticsChangeListener statisticsListener = null;

    public StatisticsDatabase(IDatabaseServices databaseServices) {
        super(databaseServices);
    }

    @Override
    public void create(StatisticsModel object) {

    }

    @Override
    public void update(StatisticsModel object) {

    }

    @Override
    public void retrieve(String objectId, String className) {

    }

    @Override
    public void retrieveAll(String className) {
        final ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_STATISTICS);
        parseQuery.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    statisticsModel = (StatisticsModel) ParseObjectToObjectModel.getObjectModel(object);
                    Log.i("Date Statistics", statisticsModel.getCreatedAt().toString());
                    if (statisticsListener != null)
                        statisticsListener.onStatisticsChange(statisticsModel);
                }
            }
        });
    }

    int aux = 0;

    @Override
    public void retrieveAll(String className, Date initialDate, Date finalDate) {
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQuery.whereGreaterThanOrEqualTo("createAt", initialDate);
        parseQuery.whereLessThanOrEqualTo("createAt", finalDate);
        parseQuery.countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                Log.i("Count", Integer.toString(count));
            }
        });
        parseQuery.whereEqualTo("noteCommunication", 1).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                Log.i("noteCommunication1", Integer.toString(count));
            }
        });
        parseQuery.whereEqualTo("noteCommunication", 2).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                Log.i("noteCommunication2", Integer.toString(count));
            }
        });
    }

//    private void check() {
//        if(aux == 11)
//
//    }

    @Override
    public void delete(String objectId, String className) {

    }

    @Override
    public void delete(StatisticsModel object) {

    }

    public void setStatisticsListener(StatisticsDatabase.OnStatisticsChangeListener statisticsListener) {
        this.statisticsListener = statisticsListener;
    }

    public interface OnStatisticsChangeListener {
        void onStatisticsChange(StatisticsModel statisticsModel);
    }
}