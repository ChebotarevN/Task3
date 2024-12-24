package app.module.component;

import app.module.TimeServer;
import app.module.IObserver;
import app.module.Subject;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Comp1 extends Label implements IObserver {
    private int localTime = 0;

    @Override
    public void update(Subject subject) {
        if (subject instanceof TimeServer) {
            localTime = subject.getState();
            System.out.println("Локальное время: " + localTime + " секунд.");
            Platform.runLater(() -> setText("Локальное время: " + localTime + " секунд."));
        }
    }
}