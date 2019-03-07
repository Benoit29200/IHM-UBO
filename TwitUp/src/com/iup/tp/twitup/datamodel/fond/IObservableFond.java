package com.iup.tp.twitup.datamodel.fond;

import javax.swing.*;
import java.awt.*;

public interface IObservableFond {

    void addObserver(IObserverFond o);

    void deleteObserver();

    void notifyEventApp(String nom, String login, String mdp);

    void chargeComponent(JComponent component, GridBagConstraints constraints);
}
