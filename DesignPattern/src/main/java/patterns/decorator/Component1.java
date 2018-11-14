package patterns.decorator;

public class Component1 extends AbstractComponent{

    public Component1() {
        description = "component 1";
    }

    @Override
    public String function() {
        return "AAA";
    }
}
