package patterns.command;

public class MarcoCommand implements Command{

    private Command[] commands;

    public MarcoCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for(Command command : commands) {
            command.execute();
        }
    }

    public void undo() {
        for(Command command : commands) {
            command.undo();
        }
    }
}
