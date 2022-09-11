package org.theledgerco.Entities.Bank;

public class Bank {

    private String name;
    private int id;

    public Bank(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
