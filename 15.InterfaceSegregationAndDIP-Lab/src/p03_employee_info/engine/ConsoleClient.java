package p03_employee_info.engine;

import p03_employee_info.interfaces.Formatter;
import p03_employee_info.interfaces.InfoProvider;

public class ConsoleClient {

    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    public String formatByName(){
        return this.formatter.format(this.infoProvider.getEmployeesByName());
    }

    public String formatBySalary(){
        return this.formatter.format(this.infoProvider.getEmployeesBySalary());
    }
}