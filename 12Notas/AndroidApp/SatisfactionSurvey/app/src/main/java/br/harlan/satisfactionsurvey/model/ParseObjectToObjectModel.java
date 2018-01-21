package br.harlan.satisfactionsurvey.model;

import com.parse.ParseObject;

public class ParseObjectToObjectModel {


    public static BaseModel getObjectModel(ParseObject parseObject){
        BaseModel baseModel = null;
        if(parseObject.getClassName().equals(BaseModel.CLASS_NAME_EVALUATION)){
            baseModel = new EvaluationModel();
            baseModel.setObjectId(parseObject.getObjectId());
            baseModel.setCreatedAt(parseObject.getCreatedAt());
            baseModel.setUpdatedAt(parseObject.getUpdatedAt());
            ((EvaluationModel)baseModel).setName(parseObject.getString("name"));
            ((EvaluationModel)baseModel).setCompany(parseObject.getString("company"));
            ((EvaluationModel)baseModel).setEmail(parseObject.getString("email"));
            ((EvaluationModel)baseModel).setTelephone(parseObject.getString("telephone"));
            ((EvaluationModel)baseModel).setComments(parseObject.getString("comments"));
            ((EvaluationModel)baseModel).setNoteKnowledge((float) parseObject.getDouble("noteKnowledge"));
            ((EvaluationModel)baseModel).setNoteCommitment((float) parseObject.getDouble("noteCommitment"));
            ((EvaluationModel)baseModel).setNoteCommunication((float) parseObject.getDouble("noteCommunication"));
            ((EvaluationModel)baseModel).setNoteCordiality((float) parseObject.getDouble("noteCordiality"));
            ((EvaluationModel)baseModel).setSatisfaction(parseObject.getInt("satisfaction"));
        }
        return baseModel;
    }
}