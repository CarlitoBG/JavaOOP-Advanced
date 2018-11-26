package p07_1984.models;

import p07_1984.annotations.Changeable;

public class Employee extends BaseSubject{

    private String id;
    @Changeable
    private String name;
    @Changeable
    private int income;

    @Override
    protected String getSubjectId() {
        return this.id;
    }
}