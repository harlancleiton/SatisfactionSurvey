package br.harlan.satisfactionsurvey.model;


import java.util.Observable;
import java.util.Observer;

public class StatisticsModel extends Observable {

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

    public void dataChange(){
        setChanged();
        notifyObservers();
    }
}
