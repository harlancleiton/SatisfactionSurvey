package br.harlan.satisfactionsurvey.model;


public class EvaluationModel extends BaseModel {

    //region Variables
    private String name;
    private String company;
    private String email;
    private String telephone;
    private String comments;
    private float noteKnowledge;
    private float noteCommunication;
    private float noteCommitment;
    private float noteCordiality;
    private int satisfaction;
    private int typeEvaluation;

    public static int SATISFIED = 0;
    public static int INDIFFERENT = 1;
    public static int DISSATISFIED = 2;
    public static int EVALUATION_TYPE_DOUBT = 3;
    public static int EVALUATION_TYPE_COMPLIMENT = 4;
    public static int EVALUATION_TYPE_SUGGESTION = 5;
    public static int EVALUATION_TYPE_CRITICISM = 6;
    public static int NO_SELECTION = -1;
    //endregion Variables

    //region Getters and Setters
    public EvaluationModel() {
        setClassChild("evaluations");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public float getNoteKnowledge() {
        return noteKnowledge;
    }

    public void setNoteKnowledge(float noteKnowledge) {
        this.noteKnowledge = noteKnowledge;
    }

    public float getNoteCommunication() {
        return noteCommunication;
    }

    public void setNoteCommunication(float noteCommunication) {
        this.noteCommunication = noteCommunication;
    }

    public float getNoteCommitment() {
        return noteCommitment;
    }

    public void setNoteCommitment(float noteCommitment) {
        this.noteCommitment = noteCommitment;
    }

    public float getNoteCordiality() {
        return noteCordiality;
    }

    public void setNoteCordiality(float noteCordiality) {
        this.noteCordiality = noteCordiality;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(int typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    //endregion Getters and Setters
}