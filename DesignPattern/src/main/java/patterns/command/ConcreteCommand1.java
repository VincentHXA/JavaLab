package patterns.command;

public class ConcreteCommand1 implements Command{

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.onAction();
    }

    public void undo() {
        this.receiver.offAction();
    }
}
