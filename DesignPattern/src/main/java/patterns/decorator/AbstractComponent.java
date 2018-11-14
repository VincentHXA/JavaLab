package patterns.decorator;

public abstract class AbstractComponent {

    protected String description = "unknown component";

    public String getDescription() {
        return description;
    }

    public abstract String function();
}
