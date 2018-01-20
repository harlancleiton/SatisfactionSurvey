package br.harlan.satisfactionsurvey.model;

import java.util.ArrayList;
import java.util.Date;

public class BaseModel {

    protected String objectId;
    protected String className;
    protected String currentDate;
    protected String currentTime;
    protected Date createdAt;
    protected Date updatedAt;
    protected OnDataChangeListener onDataChangeListener;

    public final static String CLASS_NAME_EVALUATION =  "Evaluations";

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OnDataChangeListener getOnDataChangeListener() {
        return onDataChangeListener;
    }

    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
    }

    public interface OnDataChangeListener<T extends BaseModel> {
        void onDataChange(ArrayList<T> baseModelArrayList);
    }
}