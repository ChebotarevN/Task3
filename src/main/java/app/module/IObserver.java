package app.module;

public interface IObserver {

    Subject subject = null;

    public abstract void update(Subject subject);

}