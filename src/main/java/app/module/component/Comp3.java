package app.module.component;

import app.module.IObserver;

import app.module.Subject;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Comp3 extends Canvas implements IObserver {
    private double x = 0, y = 0, radius;
    private int width = 300, height = 300;

    public Comp3() {
        radius = 100;
        getGraphicsContext2D().setFill(Color.GREEN);
        getGraphicsContext2D().setStroke(Color.BLUE);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public void update(Subject subject) {
        if (subject.getState() % 20 == 0) {
            x = -10;
            y = -10;
        }
        x += 10;
        y += 10;
        getGraphicsContext2D().clearRect(0,0, width, height);
        getGraphicsContext2D().fillRect(x, y, radius,  radius);
        getGraphicsContext2D().strokeRect(0,0,width, height);
    }
}
