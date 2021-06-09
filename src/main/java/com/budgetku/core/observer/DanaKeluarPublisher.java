package com.budgetku.core.observer;

import com.budgetku.model.DanaKeluar;
import java.util.ArrayList;

public class DanaKeluarPublisher {
    private ArrayList<DanaKeluarSubscriber> subscribers = new ArrayList<>();
    private DanaKeluar danaKeluar;
    private String userEmail;

    public void addSubscriber(DanaKeluarSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setDanaKeluar(DanaKeluar danaKeluar) {
        this.danaKeluar = danaKeluar;
        notifySubscriber();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public DanaKeluar getDanaKeluar() {
        return danaKeluar;
    }

    public ArrayList<DanaKeluarSubscriber> getSubscribers() {
        return subscribers;
    }

    private void notifySubscriber() {
        for (DanaKeluarSubscriber subscriber : this.getSubscribers()) {
            subscriber.update(this.getUserEmail());
        }
    }
}
