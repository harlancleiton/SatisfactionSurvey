package br.harlan.satisfactionsurvey.model.services;

import com.parse.ParseObject;

import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;
import br.harlan.satisfactionsurvey.model.StatisticsModel;
import br.harlan.satisfactionsurvey.singleton.FirebaseSingleton;
import br.harlan.satisfactionsurvey.singleton.StatisticsSingleton;

public class ParseObjectToObjectModel {

    private static BaseModel baseModel = null;

    public static BaseModel getObjectModel(ParseObject parseObject){
        if(parseObject.getClassName().equals(BaseModel.CLASS_NAME_EVALUATION)){
            baseModel = getEvaluationModel(parseObject);
        } else if (parseObject.getClassName().equals(BaseModel.CLASS_NAME_STATISTICS)){
            baseModel = getStatisticsModel(parseObject);
        }
        return baseModel;
    }

    private static StatisticsModel getStatisticsModel(ParseObject parseObject) {
        StatisticsModel statisticsModel = StatisticsSingleton.getInstance();
        statisticsModel.setTotal(parseObject.getInt("total"));
        statisticsModel.setSatisfied(parseObject.getInt("satisfied"));
        statisticsModel.setIndifferent(parseObject.getInt("indifferent"));
        statisticsModel.setDissatisfied(parseObject.getInt("dissatisfied"));
        statisticsModel.setCommitment1(parseObject.getInt("commitment1"));
        statisticsModel.setCommitment2(parseObject.getInt("commitment2"));
        statisticsModel.setCommitment3(parseObject.getInt("commitment3"));
        statisticsModel.setCommitment4(parseObject.getInt("commitment4"));
        statisticsModel.setCommitment5(parseObject.getInt("commitment5"));
        statisticsModel.setCommunication1(parseObject.getInt("communication1"));
        statisticsModel.setCommunication2(parseObject.getInt("communication2"));
        statisticsModel.setCommunication3(parseObject.getInt("communication3"));
        statisticsModel.setCommunication4(parseObject.getInt("communication4"));
        statisticsModel.setCommunication5(parseObject.getInt("communication5"));
        statisticsModel.setCordiality1(parseObject.getInt("cordiality1"));
        statisticsModel.setCordiality2(parseObject.getInt("cordiality2"));
        statisticsModel.setCordiality3(parseObject.getInt("cordiality3"));
        statisticsModel.setCordiality4(parseObject.getInt("cordiality4"));
        statisticsModel.setCordiality5(parseObject.getInt("cordiality5"));
        statisticsModel.setKnowlegde1(parseObject.getInt("knowlegde1"));
        statisticsModel.setKnowlegde2(parseObject.getInt("knowlegde2"));
        statisticsModel.setKnowlegde3(parseObject.getInt("knowlegde3"));
        statisticsModel.setKnowlegde4(parseObject.getInt("knowlegde4"));
        statisticsModel.setKnowlegde5(parseObject.getInt("knowlegde5"));
        statisticsModel.setCriticims(parseObject.getInt("criticims"));
        statisticsModel.setDoubt(parseObject.getInt("doubt"));
        statisticsModel.setCompliment(parseObject.getInt("compliment"));
        statisticsModel.setSuggestion(parseObject.getInt("suggestion"));
        return statisticsModel;
    }

    private static EvaluationModel getEvaluationModel(ParseObject parseObject) {
        EvaluationModel evaluationModel = null;
        evaluationModel = new EvaluationModel();
        evaluationModel.setObjectId(parseObject.getObjectId());
        evaluationModel.setCreatedAt(parseObject.getCreatedAt());
        evaluationModel.setUpdatedAt(parseObject.getUpdatedAt());
        evaluationModel.setName(parseObject.getString("name"));
        evaluationModel.setCompany(parseObject.getString("company"));
        evaluationModel.setEmail(parseObject.getString("email"));
        evaluationModel.setTelephone(parseObject.getString("telephone"));
        evaluationModel.setComments(parseObject.getString("comments"));
        evaluationModel.setNoteKnowledge((float) parseObject.getDouble("noteKnowledge"));
        evaluationModel.setNoteCommitment((float) parseObject.getDouble("noteCommitment"));
        evaluationModel.setNoteCommunication((float) parseObject.getDouble("noteCommunication"));
        evaluationModel.setNoteCordiality((float) parseObject.getDouble("noteCordiality"));
        evaluationModel.setSatisfaction(parseObject.getInt("satisfaction"));
        return evaluationModel;
    }
}