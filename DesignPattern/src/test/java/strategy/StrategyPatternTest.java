package strategy;

import org.junit.Test;
import patterns.strategy.*;

public class StrategyPatternTest {

    private SubjectOne subjectOne = new SubjectOne();
    private SubjectTwo subjectTwo = new SubjectTwo();
    private StrategyOne strategyOne = new StrategyOne();
    private StrategyTwo strategyTwo = new StrategyTwo();

    @Test
    public void test() {
        subjectOne.setStrategy(strategyOne);
        subjectOne.performStrategy();

        subjectTwo.setStrategy(strategyTwo);
        subjectTwo.performStrategy();
        subjectTwo.setStrategy(strategyOne);
        subjectTwo.performStrategy();
    }
}
