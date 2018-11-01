package patterns.strategy;

public interface Subject {

    void setStrategy(Strategy strategy);
    void performStrategy();
}
