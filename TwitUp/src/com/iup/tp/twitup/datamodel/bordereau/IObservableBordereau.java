package com.iup.tp.twitup.datamodel.bordereau;

public interface IObservableBordereau {

    void addObserver(IObserverBordereau o);

    void deleteObserver();

}
