package br.harlan.satisfactionsurvey.model.services;

import com.parse.ParseObject;

import br.harlan.satisfactionsurvey.model.BaseModel;
import br.harlan.satisfactionsurvey.model.EvaluationModel;

public class ObjectModelToParseObject {

    private static EvaluationModel currentEvaluation;

    public static ParseObject getParseObject(BaseModel baseModel) {
        ParseObject parseObject = null;
        if (baseModel.getClassName().equals(BaseModel.CLASS_NAME_EVALUATION)) {
            parseObject = getEvaluationParseObject(baseModel);
        } else if (baseModel.getClassName().equals(BaseModel.CLASS_NAME_STATISTICS))
            parseObject = getStatisticsParseObject(baseModel);
        return parseObject;
    }

    private static ParseObject getStatisticsParseObject(BaseModel baseModel) {
        ParseObject parseObject = new ParseObject(baseModel.CLASS_NAME_STATISTICS);
        parseObject.increment("total");
        if (currentEvaluation.getSatisfaction() == EvaluationModel.SATISFIED)
            parseObject.increment("satisfied");
        else if (currentEvaluation.getSatisfaction() == EvaluationModel.INDIFFERENT)
            parseObject.increment("indifferent");
        else
            parseObject.increment("dissatisfied");
        if (currentEvaluation.getTypeEvaluation() == EvaluationModel.EVALUATION_TYPE_COMPLIMENT)
            parseObject.increment("compliment");
        else if (currentEvaluation.getTypeEvaluation() == EvaluationModel.EVALUATION_TYPE_DOUBT)
            parseObject.increment("doubt");
        else if (currentEvaluation.getTypeEvaluation() == EvaluationModel.EVALUATION_TYPE_SUGGESTION)
            parseObject.increment("suggestion");
        else
            parseObject.increment("criticims");
        if (currentEvaluation.getNoteKnowledge() == 1)
            parseObject.increment("knowledge1");
        else if (currentEvaluation.getNoteKnowledge() == 2)
            parseObject.increment("knowledge2");
        else if (currentEvaluation.getNoteKnowledge() == 3)
            parseObject.increment("knowledge3");
        else if (currentEvaluation.getNoteKnowledge() == 4)
            parseObject.increment("knowledge4");
        else
            parseObject.increment("knowledge5");
        if (currentEvaluation.getNoteCommunication() == 1)
            parseObject.increment("communication1");
        else if (currentEvaluation.getNoteCommunication() == 2)
            parseObject.increment("communication2");
        else if (currentEvaluation.getNoteCommunication() == 3)
            parseObject.increment("communication3");
        else if (currentEvaluation.getNoteCommunication() == 4)
            parseObject.increment("communication4");
        else
            parseObject.increment("communication5");
        if (currentEvaluation.getNoteCommitment() == 1)
            parseObject.increment("commitment1");
        else if (currentEvaluation.getNoteCommitment() == 2)
            parseObject.increment("commitment2");
        else if (currentEvaluation.getNoteCommitment() == 3)
            parseObject.increment("commitment3");
        else if (currentEvaluation.getNoteCommitment() == 4)
            parseObject.increment("commitment4");
        else
            parseObject.increment("commitment5");
        if (currentEvaluation.getNoteCordiality() == 1)
            parseObject.increment("cordiality1");
        else if (currentEvaluation.getNoteCordiality() == 2)
            parseObject.increment("cordiality2");
        else if (currentEvaluation.getNoteCordiality() == 3)
            parseObject.increment("cordiality3");
        else if (currentEvaluation.getNoteCordiality() == 4)
            parseObject.increment("cordiality4");
        else
            parseObject.increment("cordiality5");
        return parseObject;
    }

    private static ParseObject getEvaluationParseObject(BaseModel baseModel) {
        ParseObject parseObject = new ParseObject(baseModel.getClassName());
        parseObject.put("name", ((EvaluationModel) baseModel).getName());
        parseObject.put("company", ((EvaluationModel) baseModel).getCompany());
        parseObject.put("email", ((EvaluationModel) baseModel).getEmail());
        parseObject.put("telephone", ((EvaluationModel) baseModel).getTelephone());
        parseObject.put("comments", ((EvaluationModel) baseModel).getComments());
        parseObject.put("typeEvaluation", ((EvaluationModel) baseModel).getTypeEvaluation());
        parseObject.put("noteKnowledge", ((EvaluationModel) baseModel).getNoteKnowledge());
        parseObject.put("noteCommunication", ((EvaluationModel) baseModel).getNoteCommunication());
        parseObject.put("noteCommitment", ((EvaluationModel) baseModel).getNoteCommitment());
        parseObject.put("noteCordiality", ((EvaluationModel) baseModel).getNoteCordiality());
        parseObject.put("satisfaction", ((EvaluationModel) baseModel).getSatisfaction());
        return parseObject;
    }

    public static void setCurrentEvaluation(EvaluationModel currentEvaluation) {
        ObjectModelToParseObject.currentEvaluation = currentEvaluation;
    }
}