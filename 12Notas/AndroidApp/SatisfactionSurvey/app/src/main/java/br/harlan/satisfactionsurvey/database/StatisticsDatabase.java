package br.harlan.satisfactionsurvey.database;

import com.parse.CountCallback;
import com.parse.GetCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
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
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_STATISTICS);
        parseQuery.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    statisticsModel = (StatisticsModel) ParseObjectToObjectModel.getObjectModel(object);
                    if (statisticsListener != null)
                        statisticsListener.onStatisticsChange(statisticsModel);
                }
            }
        });
    }

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