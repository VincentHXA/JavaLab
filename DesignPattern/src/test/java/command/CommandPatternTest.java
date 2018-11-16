package command;

import org.junit.Test;
import patterns.command.*;

public class CommandPatternTest {

    @Test
    public void test() {
        Invoker invoker = new Invoker();

        Receiver receiver = new Receiver();
        Command command1 = new ConcreteCommand1(receiver);
        Command command2 = new ConcreteCommand2(receiver);

        invoker.setCommand(command1);
        invoker.commandOn();
        invoker.undoCommand();

        invoker.setCommand(command2);
        invoker.commandOn();
        invoker.undoCommand();
    }

    @Test
    public void testMarcoCommand() {
        Invoker invoker = new Invoker();

        Receiver receiver = new Receiver();
        Command marcoCommand = new MarcoCommand(new Command[] {new ConcreteCommand1(receiver), new ConcreteCommand2(receiver)});
        invoker.setCommand(marcoCommand);

        invoker.commandOn();
        invoker.undoCommand();
    }
}
