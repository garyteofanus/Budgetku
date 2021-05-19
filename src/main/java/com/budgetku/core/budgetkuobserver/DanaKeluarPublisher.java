package com.budgetku.core.budgetkuobserver;

import com.budgetku.model.DanaKeluar;

import java.util.ArrayList;

public class DanaKeluarPublisher {
    private ArrayList<DanaKeluarSubscriber> subscribers = new ArrayList<>();
    private DanaKeluar danaKeluar;

    public void addSubscriber(DanaKeluarSubscriber subscriber){
        subscribers.add(subscriber);
    }

    public void addDanaKeluar(DanaKeluar danaKeluar){
        this.danaKeluar = danaKeluar;
    }

    public DanaKeluar getDanaKeluar() {
        return danaKeluar;
    }

    public ArrayList<DanaKeluarSubscriber> getSubscribers() {
        return subscribers;
    }

    private void notifySubscriber() {
        for(DanaKeluarSubscriber subscriber : this.getSubscribers()){
            subscriber.update();
        }
    }
}
