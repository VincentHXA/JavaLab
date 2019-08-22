package classloading.classloader;

public class Child extends Parent{
    static {
        CLASS_NAME = Child.class.getName();
        CLASS_LOADER_NAME = Child.class.getClassLoader().toString();
        System.out.println("Step b: " + CLASS_NAME + " is loaded by " + CLASS_LOADER_NAME);
    }

    {
        instanceID = this.toString();
        System.out.println("Step e: Child instance is created: " + CLASS_LOADER_NAME + " -> " + instanceID);
    }

    public Child() {
        System.out.println("Step f: Child instance: " + instanceID + ", constructor is invoked");
    }

    public void say() {
        System.out.println("My first class loader...");
    }
}
