package p05_security_system;

public class KeyCardCheck extends SecurityCheck implements KeyCardUI{

    @Override
    public String requestKeyCard() {
        return "slide your key card";
    }
}