package br.harlan.satisfactionsurvey.database;

import android.util.Log;

import com.parse.CountCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;

import br.harlan.satisfactionsurvey.database.services.IDatabaseServices;
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
        aux = 0;
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQuery.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQuery.whereLessThanOrEqualTo("createdAt", finalDate);
        final StatisticsModel statisticsModel = new StatisticsModel();
        //region Total
        parseQuery.countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setTotal(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Total
        //region Notes
        //region NoteCommunication
        for (int i = 1; i <= 5; i++) {
            ParseQuery<ParseObject> parseQueryNoteCommunication = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
            parseQueryNoteCommunication.whereGreaterThanOrEqualTo("createdAt", initialDate);
            parseQueryNoteCommunication.whereLessThanOrEqualTo("createdAt", finalDate);
            final int finalI = i;
            parseQueryNoteCommunication.whereEqualTo("noteCommunication", i).countInBackground(new CountCallback() {
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
                    aux++;
                    check(statisticsModel);
                }
            });
        }
        //endregion NoteCommunication
        //region NoteCordiality
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            ParseQuery<ParseObject> parseQueryNoteCordiality = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
            parseQueryNoteCordiality.whereGreaterThanOrEqualTo("createdAt", initialDate);
            parseQueryNoteCordiality.whereLessThanOrEqualTo("createdAt", finalDate);
            parseQueryNoteCordiality.whereEqualTo("noteCordiality", i).countInBackground(new CountCallback() {
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
                    aux++;
                    check(statisticsModel);
                }
            });
        }
        //endregion NoteCordiality
        //region NoteCommitment
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            ParseQuery<ParseObject> parseQueryNoteCommitment = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
            parseQueryNoteCommitment.whereGreaterThanOrEqualTo("createdAt", initialDate);
            parseQueryNoteCommitment.whereLessThanOrEqualTo("createdAt", finalDate);
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
                    aux++;
                    check(statisticsModel);
                }
            });
        }
        //endregion NoteCommitment
        //region NoteKnowledge
        for (int i = 1; i <= 5; i++) {
            final int finalI = i;
            ParseQuery<ParseObject> parseQueryNoteKnowledge = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
            parseQueryNoteKnowledge.whereGreaterThanOrEqualTo("createdAt", initialDate);
            parseQueryNoteKnowledge.whereLessThanOrEqualTo("createdAt", finalDate);
            parseQueryNoteKnowledge.whereEqualTo("noteKnowledge", i).countInBackground(new CountCallback() {
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
                    aux++;
                    check(statisticsModel);
                }
            });
        }
        //endregion NoteKnowledge
        //endregion Notes
        //region TypeComment
        //region Doubt
        ParseQuery<ParseObject> parseQueryDoubt = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQueryDoubt.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQueryDoubt.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQueryDoubt.whereEqualTo("typeEvaluation", EvaluationModel.EVALUATION_TYPE_DOUBT).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setDoubt(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Doubt
        //region Compliment
        ParseQuery<ParseObject> parseQueryCompliment = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQueryCompliment.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQueryCompliment.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQueryCompliment.whereEqualTo("typeEvaluation", EvaluationModel.EVALUATION_TYPE_COMPLIMENT).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setCompliment(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Compliment
        //region Criticims
        ParseQuery<ParseObject> parseQueryCriticims = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQueryCriticims.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQueryCriticims.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQueryCriticims.whereEqualTo("typeEvaluation", EvaluationModel.EVALUATION_TYPE_CRITICISM).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setCriticims(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Criticims
        //region Suggestion
        ParseQuery<ParseObject> parseQuerySuggestion = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQuerySuggestion.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQuerySuggestion.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQuerySuggestion.whereEqualTo("typeEvaluation", EvaluationModel.EVALUATION_TYPE_SUGGESTION).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setSuggestion(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Suggestion
        //endregion TypeComment
        //region Satisfaction
        //region Satisfied
        ParseQuery<ParseObject> parseQuerySatisfied = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQuerySatisfied.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQuerySatisfied.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQuerySatisfied.whereEqualTo("satisfaction", EvaluationModel.SATISFIED).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setSatisfied(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Satisfied
        //region Indifferent
        ParseQuery<ParseObject> parseQueryIndifferent = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQueryIndifferent.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQueryIndifferent.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQueryIndifferent.whereEqualTo("satisfaction", EvaluationModel.INDIFFERENT).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setIndifferent(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Indifferent
        //region Dissatisfied
        ParseQuery<ParseObject> parseQueryDissatisfied = ParseQuery.getQuery(StatisticsModel.CLASS_NAME_EVALUATION);
        parseQueryDissatisfied.whereGreaterThanOrEqualTo("createdAt", initialDate);
        parseQueryDissatisfied.whereLessThanOrEqualTo("createdAt", finalDate);
        parseQueryDissatisfied.whereEqualTo("satisfaction", EvaluationModel.DISSATISFIED).countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                statisticsModel.setDissatisfied(count);
                aux++;
                check(statisticsModel);
            }
        });
        //endregion Dissatisfied
        //endregion Satisfaction
    }

    private void check(StatisticsModel statisticsModel) {
        if(aux == 28)
            statisticsListener.onStatisticsChange(statisticsModel);
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