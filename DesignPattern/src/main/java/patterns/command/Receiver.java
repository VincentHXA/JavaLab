package patterns.command;

public class Receiver {

    public void onAction() {
        System.out.println("onAction of receiver");
    }

    public void offAction() {
        System.out.println("offAction of receiver");
    }
}
