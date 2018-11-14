package patterns.decorator;

public class Component2 extends AbstractComponent{

    public Component2() {
        description = "component 2";
    }

    @Override
    public String function() {
        return "BBB";
    }
}
