package com.budgetku.core.observer;

import com.budgetku.model.DanaKeluar;
import java.util.ArrayList;

// import org.springframework.stereotype.Component;

// @Component
public class DanaKeluarPublisher {
    private final ArrayList<DanaKeluarSubscriber> subscribers = new ArrayList<>();
    private DanaKeluar danaKeluar;

    public void addSubscriber(DanaKeluarSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void addDanaKeluar(DanaKeluar danaKeluar) {
        this.danaKeluar = danaKeluar;
        notifySubscriber();
    }

    public DanaKeluar getDanaKeluar() {
        return danaKeluar;
    }

    public ArrayList<DanaKeluarSubscriber> getSubscribers() {
        return subscribers;
    }

    private void notifySubscriber() {
        for (DanaKeluarSubscriber subscriber : this.getSubscribers()) {
            subscriber.update();
        }
    }
}
