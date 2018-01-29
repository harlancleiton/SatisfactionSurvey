package br.harlan.satisfactionsurvey.model;

public class StatisticsModel extends BaseModel {

    //region Variables
    int total;
    int satisfied;
    int indifferent;
    int dissatisfied;
    int compliment;
    int doubt;
    int suggestion;
    int criticims;
    int knowledge1;
    int knowledge2;
    int knowledge3;
    int knowledge4;
    int knowledge5;
    int communication1;
    int communication2;
    int communication3;
    int communication4;
    int communication5;
    int commitment1;
    int commitment2;
    int commitment3;
    int commitment4;
    int commitment5;
    int cordiality1;
    int cordiality2;
    int cordiality3;
    int cordiality4;
    int cordiality5;
    //endregion Variables

    public StatisticsModel() {
        className = BaseModel.CLASS_NAME_STATISTICS;
        setTotal(NO_READY);
    }

    //region Getters and Setters
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(int satisfied) {
        this.satisfied = satisfied;
    }

    public int getIndifferent() {
        return indifferent;
    }

    public void setIndifferent(int indifferent) {
        this.indifferent = indifferent;
    }

    public int getDissatisfied() {
        return dissatisfied;
    }

    public void setDissatisfied(int dissatisfied) {
        this.dissatisfied = dissatisfied;
    }

    public int getCompliment() {
        return compliment;
    }

    public void setCompliment(int compliment) {
        this.compliment = compliment;
    }

    public int getDoubt() {
        return doubt;
    }

    public void setDoubt(int doubt) {
        this.doubt = doubt;
    }

    public int getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(int suggestion) {
        this.suggestion = suggestion;
    }

    public int getCriticims() {
        return criticims;
    }

    public void setCriticims(int criticims) {
        this.criticims = criticims;
    }

    public int getKnowledge1() {
        return knowledge1;
    }

    public void setKnowledge1(int knowledge1) {
        this.knowledge1 = knowledge1;
    }

    public int getKnowledge2() {
        return knowledge2;
    }

    public void setKnowledge2(int knowledge2) {
        this.knowledge2 = knowledge2;
    }

    public int getKnowledge3() {
        return knowledge3;
    }

    public void setKnowledge3(int knowledge3) {
        this.knowledge3 = knowledge3;
    }

    public int getKnowledge4() {
        return knowledge4;
    }

    public void setKnowledge4(int knowledge4) {
        this.knowledge4 = knowledge4;
    }

    public int getKnowledge5() {
        return knowledge5;
    }

    public void setKnowledge5(int knowledge5) {
        this.knowledge5 = knowledge5;
    }

    public int getCommunication1() {
        return communication1;
    }

    public void setCommunication1(int communication1) {
        this.communication1 = communication1;
    }

    public int getCommunication2() {
        return communication2;
    }

    public void setCommunication2(int communication2) {
        this.communication2 = communication2;
    }

    public int getCommunication3() {
        return communication3;
    }

    public void setCommunication3(int communication3) {
        this.communication3 = communication3;
    }

    public int getCommunication4() {
        return communication4;
    }

    public void setCommunication4(int communication4) {
        this.communication4 = communication4;
    }

    public int getCommunication5() {
        return communication5;
    }

    public void setCommunication5(int communication5) {
        this.communication5 = communication5;
    }

    public int getCommitment1() {
        return commitment1;
    }

    public void setCommitment1(int commitment1) {
        this.commitment1 = commitment1;
    }

    public int getCommitment2() {
        return commitment2;
    }

    public void setCommitment2(int commitment2) {
        this.commitment2 = commitment2;
    }

    public int getCommitment3() {
        return commitment3;
    }

    public void setCommitment3(int commitment3) {
        this.commitment3 = commitment3;
    }

    public int getCommitment4() {
        return commitment4;
    }

    public void setCommitment4(int commitment4) {
        this.commitment4 = commitment4;
    }

    public int getCommitment5() {
        return commitment5;
    }

    public void setCommitment5(int commitment5) {
        this.commitment5 = commitment5;
    }

    public int getCordiality1() {
        return cordiality1;
    }

    public void setCordiality1(int cordiality1) {
        this.cordiality1 = cordiality1;
    }

    public int getCordiality2() {
        return cordiality2;
    }

    public void setCordiality2(int cordiality2) {
        this.cordiality2 = cordiality2;
    }

    public int getCordiality3() {
        return cordiality3;
    }

    public void setCordiality3(int cordiality3) {
        this.cordiality3 = cordiality3;
    }

    public int getCordiality4() {
        return cordiality4;
    }

    public void setCordiality4(int cordiality4) {
        this.cordiality4 = cordiality4;
    }

    public int getCordiality5() {
        return cordiality5;
    }

    public void setCordiality5(int cordiality5) {
        this.cordiality5 = cordiality5;
    }
    //endregion Getters and Setters

//    public interface OnStatisticsChangeListener {
//        void onStatisticsChange(StatisticsModel statisticsModel);
//    }

//    public interface OnDataChangeListener<T extends ChartData> {
//        void onDataChange(T data);
//    }
}