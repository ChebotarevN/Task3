package app.observer;

import app.module.component.Comp3;
import app.module.component.Signal;
import app.module.TimeServer;
import app.module.component.Comp1;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class Controller {
    private TimeServer timeServer;
    @FXML
    public HBox instrument;
    private Signal signal;

    public void initialize() {
        timeServer = new TimeServer();
        Comp1 comp1 = new Comp1();
        signal = new Signal();
        Comp3 comp3 = new Comp3();

        timeServer.attach(comp1);
        timeServer.attach(signal);
        timeServer.attach(comp3);
        instrument.getChildren().add(comp1);
        instrument.getChildren().add(signal);
        instrument.getChildren().add(comp3);
    }

    @FXML
    protected void onButtonStart() {
        timeServer.start();
        signal.onComp(5);
    }

    @FXML
    protected void onButtonStop() {
        timeServer.stop();
        signal.offComp();
    }
}