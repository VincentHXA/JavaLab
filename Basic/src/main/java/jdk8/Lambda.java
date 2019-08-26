package jdk8;

/**
 * Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 *
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 */
public class Lambda {

    static String salutation = "Hello ";
    final static String salutationFinal = "Hi ";

    public static void main(String[] args) {
        Lambda tester = new Lambda();

        // 声明类型
        MathOperation addition = (int a, int b) -> a + b;

        // 不声明类型
        MathOperation subtraction = (a, b) -> a - b;

        // 使用大括号包裹返回
        MathOperation multiplication = (a, b) -> {return a * b;};

        // 不用大括号包裹
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 参数不用圆括号
        GreetingService greetingService1 = msg -> System.out.println(salutationFinal + msg);

        // 参数用圆括号
        GreetingService greetingService2 = (msg) -> System.out.println("Hello " + msg);

        greetingService1.sayMessage("vincent");
        greetingService2.sayMessage("david");

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String msg);
    }

    private int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }
}


