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
        parseQuery.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQuery.whereLessThanOrEqualTo("createdAt", finalDate);
        final StatisticsModel statisticsModel = new StatisticsModel();
        parseQuery.countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setTotal(count);
            }
        });
        //region NoteCommunication
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            parseQuery.whereEqualTo("noteCommunication", i).countInBackground(new CountCallback() {
                @Override
                public void done(int count, ParseException e) {
                    if (finalI == 1)
                        statisticsModel.setCommunication1(count);
                    else if (finalI == 2)
                        statisticsModel.setCommunication2(count);
                    else if (finalI == 3)
                        statisticsModel.setCommunication3(count);
                    else if (finalI == 4)
                        statisticsModel.setCommunication4(count);
                    else
                        statisticsModel.setCommunication5(count);
                }
            });
        }
        //endregion NoteCommunication
        //region NoteCordiality
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            parseQuery.whereEqualTo("noteCordiality", i).countInBackground(new CountCallback() {
                @Override
                public void done(int count, ParseException e) {
                    if (finalI == 1)
                        statisticsModel.setCordiality1(count);
                    else if (finalI == 2)
                        statisticsModel.setCordiality2(count);
                    else if (finalI == 3)
                        statisticsModel.setCordiality3(count);
                    else if (finalI == 4)
                        statisticsModel.setCordiality4(count);
                    else
                        statisticsModel.setCordiality5(count);
                }
            });
        }
        //endregion NoteCordiality
        //region NoteCommitment
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            parseQuery.whereEqualTo("noteCommitment", i).countInBackground(new CountCallback() {
                @Override
                public void done(int count, ParseException e) {
                    if (finalI == 1)
                        statisticsModel.setCommitment1(count);
                    else if (finalI == 2)
                        statisticsModel.setCommitment2(count);
                    else if (finalI == 3)
                        statisticsModel.setCommitment3(count);
                    else if (finalI == 4)
                        statisticsModel.setCommitment4(count);
                    else
                        statisticsModel.setCommitment5(count);
                }
            });
        }
        //endregion NoteCommitment
        //region NoteKnowledge
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            parseQuery.whereEqualTo("noteKnowledge", i).countInBackground(new CountCallback() {
                @Override
                public void done(int count, ParseException e) {
                    if (finalI == 1)
                        statisticsModel.setKnowledge1(count);
                    else if (finalI == 2)
                        statisticsModel.setKnowledge2(count);
                    else if (finalI == 3)
                        statisticsModel.setKnowledge3(count);
                    else if (finalI == 4)
                        statisticsModel.setKnowledge4(count);
                    else
                        statisticsModel.setKnowledge5(count);
                }
            });
        }
        //endregion NoteKnowledge
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