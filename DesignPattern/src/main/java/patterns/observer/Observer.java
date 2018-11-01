package patterns.observer;

public interface Observer {

    void update(Observable observable);
    void update(Object args);
}
