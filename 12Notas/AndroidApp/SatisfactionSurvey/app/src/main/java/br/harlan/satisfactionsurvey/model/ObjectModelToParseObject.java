package br.harlan.satisfactionsurvey.model;

import com.parse.ParseObject;

public class ObjectModelToParseObject {
    public static ParseObject getParseObject(BaseModel baseModel){
        ParseObject parseObject = null;
        if(baseModel.getClassName().equals(BaseModel.CLASS_NAME_EVALUATION)){
            parseObject = new ParseObject(baseModel.getClassName());
            parseObject.put("name", ((EvaluationModel)baseModel).getName());
            parseObject.put("company", ((EvaluationModel)baseModel).getCompany());
            parseObject.put("email", ((EvaluationModel)baseModel).getEmail());
            parseObject.put("telephone", ((EvaluationModel)baseModel).getTelephone());
            parseObject.put("comments", ((EvaluationModel)baseModel).getComments());
            parseObject.put("typeEvaluation", ((EvaluationModel)baseModel).getTypeEvaluation());
            parseObject.put("noteKnowledge", ((EvaluationModel)baseModel).getNoteKnowledge());
            parseObject.put("noteCommunication", ((EvaluationModel)baseModel).getNoteCommunication());
            parseObject.put("noteCommitment", ((EvaluationModel)baseModel).getNoteCommitment());
            parseObject.put("noteCordiality", ((EvaluationModel)baseModel).getNoteCordiality());
            parseObject.put("satisfaction", ((EvaluationModel)baseModel).getSatisfaction());
        }
        return parseObject;
    }
}
