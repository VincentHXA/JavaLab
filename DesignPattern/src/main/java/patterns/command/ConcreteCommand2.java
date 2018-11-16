package patterns.command;

public class ConcreteCommand2 implements Command{

    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        this.receiver.onAction();
    }

    public void undo() {
        this.receiver.offAction();
    }
}
