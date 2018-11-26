package p01_logger.core;

import p01_logger.enums.ReportLevel;
import p01_logger.factories.AppenderFactory;
import p01_logger.factories.LayoutFactory;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.InputReader;
import p01_logger.interfaces.Layout;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InputReader inputReader;
    private List<Appender> appenders;

    public Controller(InputReader inputReader) {
        this.inputReader = inputReader;
        this.appenders = new ArrayList<>();
    }

    public void run() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        int numberOfAppenders = Integer.parseInt(this.inputReader.readLine());

        for (int i = 0; i < numberOfAppenders; i++) {
            String[] tokens = this.inputReader.readLine().split("\\s+");
            ReportLevel reportLevel = tokens.length == 3 ? ReportLevel.valueOf(tokens[2]) : null;

            Layout layout = LayoutFactory.create(tokens[1]);
            Appender appender = AppenderFactory.create(tokens[0], layout, reportLevel);

            this.appenders.add(appender);
        }

        String line;
        while (true){
            if ("END".equals(line = this.inputReader.readLine())){
                break;
            }

            String[] tokens = line.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String time = tokens[1];
            String message = tokens[2];

            for (Appender appender : this.appenders) {
                appender.appendMessage(reportLevel, time, message);
            }
        }

        System.out.println("Logger info");
        this.appenders.forEach(System.out::println);
    }
}