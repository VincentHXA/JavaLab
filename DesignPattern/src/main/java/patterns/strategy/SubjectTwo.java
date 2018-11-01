package patterns.strategy;

public class SubjectTwo extends AbstractSubject{

    public SubjectTwo() {
    }

    @Override
    public void action() {
        logger.info("action of [{}]", this.getClass().getName());
        performStrategy();
    }
}
