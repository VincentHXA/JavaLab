package patterns.decorator;

public class ComponentDecorator extends AbstractComponentDecorator{

    public ComponentDecorator(AbstractComponent component) {
        this.component = component;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", decorator";
    }

    @Override
    public String function() {
        return component.function() + ", function decorated";
    }
}
