package com.iup.tp.twitup.ObservableController;

import java.util.Observable;
import java.util.Observer;

public interface IObservable {

    void addObserver(Observer o);

    void deleteObserver(Observer o);

    void notifyObservers();

    void notifyObservers(Object arg);
}
