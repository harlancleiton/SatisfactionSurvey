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
    int knowlegde1;
    int knowlegde2;
    int knowlegde3;
    int knowlegde4;
    int knowlegde5;
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
        setTotal(0);
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

    public int getKnowlegde1() {
        return knowlegde1;
    }

    public void setKnowlegde1(int knowlegde1) {
        this.knowlegde1 = knowlegde1;
    }

    public int getKnowlegde2() {
        return knowlegde2;
    }

    public void setKnowlegde2(int knowlegde2) {
        this.knowlegde2 = knowlegde2;
    }

    public int getKnowlegde3() {
        return knowlegde3;
    }

    public void setKnowlegde3(int knowlegde3) {
        this.knowlegde3 = knowlegde3;
    }

    public int getKnowlegde4() {
        return knowlegde4;
    }

    public void setKnowlegde4(int knowlegde4) {
        this.knowlegde4 = knowlegde4;
    }

    public int getKnowlegde5() {
        return knowlegde5;
    }

    public void setKnowlegde5(int knowlegde5) {
        this.knowlegde5 = knowlegde5;
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

    public interface OnStatisticsChangeListener {
        void onStatisticsChange(StatisticsModel statisticsModel);
    }

    public interface OnDataChangeListener<T> {
        void onDataChange(T data);
    }
}