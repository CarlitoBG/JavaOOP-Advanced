package p05_security_system;

import java.util.Scanner;

public class SecurityManager {

    private KeyCardUI keyCardCheck;
    private PinCodeUI pinCodeCheck;

    private SecurityManager(KeyCardUI keyCardCheck, PinCodeUI pinCodeCheck) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
    }

    private void check() {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println(this.keyCardCheck.requestKeyCard());
                break;
            case 2:
                System.out.println(this.pinCodeCheck.requestPinCode());
                break;
        }
    }

    public static void main(String[] args){
        KeyCardUI keyCardCheck = new KeyCardCheck();
        PinCodeUI pinCodeCheck = new PinCodeCheck();
        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck);
        manager.check();
    }
}