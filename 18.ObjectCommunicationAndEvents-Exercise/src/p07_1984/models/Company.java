package p07_1984.models;

import p07_1984.annotations.Changeable;

public class Company extends BaseSubject{

    private String id;
    @Changeable
    private String name;
    @Changeable
    private int turnover;
    @Changeable
    private int revenue;

    @Override
    protected String getSubjectId() {
        return this.id;
    }
}