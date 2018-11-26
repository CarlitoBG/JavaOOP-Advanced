package p07_1984.models;

import p07_1984.annotations.Changeable;
import p07_1984.contracts.Observer;
import p07_1984.contracts.Subject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSubject implements Subject{

    private List<Observer> observers;

    BaseSubject() {
        this.observers = new ArrayList<>();
    }

    protected abstract String getSubjectId();

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObserver(String attributeToChange, String newValue) {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals(attributeToChange) && field.isAnnotationPresent(Changeable.class)){
                field.setAccessible(true);
                Class type = field.getType();
                Object value = newValue;

                if (type.getSimpleName().equals("int")){
                    value = Integer.parseInt(newValue);
                }

                try {
                    Object oldValue = field.get(this);
                    field.set(this, value);

                    for (Observer observer : this.observers) {
                        observer.update(this.getClass().getSimpleName(), this.getSubjectId(), attributeToChange,
                                type.getSimpleName(), oldValue.toString(), newValue);
                    }
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}