package p05_say_hello_extended;

public class European extends BasePerson implements Person{

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}