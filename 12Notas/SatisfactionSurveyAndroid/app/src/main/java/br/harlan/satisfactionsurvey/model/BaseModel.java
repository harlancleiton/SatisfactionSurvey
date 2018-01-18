package br.harlan.satisfactionsurvey.model;

public class BaseModel {

    private String key;
    private String classChild;
    String currentDate;
    String currentTime;
    OnDataChangeListener onDataChangeListener;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getClassChild() {
        return classChild;
    }

    public void setClassChild(String classChild) {
        this.classChild = classChild;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public OnDataChangeListener getOnDataChangeListener() {
        return onDataChangeListener;
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
    }

    public interface OnDataChangeListener {
        void onDataChange();
    }
}