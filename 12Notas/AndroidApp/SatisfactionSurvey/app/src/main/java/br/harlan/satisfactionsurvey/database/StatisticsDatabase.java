package br.harlan.satisfactionsurvey.database;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.model.StatisticsModel;

public class StatisticsDatabase extends BaseDatabase implements ICRUD<StatisticsModel> {

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

    }

    @Override
    public void delete(String objectId, String className) {

    }

    @Override
    public void delete(StatisticsModel object) {

    }

    public StatisticsDatabase getStatistics(StatisticsModel.StatisticsChange statisticsChange) {
        ParseQuery<ParseObject> totalQuery = ParseQuery.getQuery(BaseModel.CLASS_NAME_EVALUATION);
        totalQuery.countInBackground();

        return null;
    }
}
