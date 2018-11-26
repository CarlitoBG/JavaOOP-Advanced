package p05_security_system;

public class PinCodeCheck extends SecurityCheck implements PinCodeUI{

    @Override
    public int requestPinCode() {
        return 1458;
    }
}