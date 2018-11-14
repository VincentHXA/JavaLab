package decorator;

import org.junit.Test;
import patterns.decorator.AbstractComponent;
import patterns.decorator.Component1;
import patterns.decorator.Component2;
import patterns.decorator.ComponentDecorator;

public class DecoratorPatternTest {

    @Test
    public void test() {
        AbstractComponent component1 = new Component1();
        AbstractComponent component2 = new Component2();

        AbstractComponent component3 = new ComponentDecorator(component1);
        System.out.println(component3.function());
        System.out.println(component3.getDescription());
        AbstractComponent component4 = new ComponentDecorator(component2);
        System.out.println(component4.function());
        System.out.println(component4.getDescription());
    }
}
