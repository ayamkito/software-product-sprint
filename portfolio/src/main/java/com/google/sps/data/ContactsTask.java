package com.google.sps.data;

/** Contact information of individuals */
public final class ContactsTask {
    private final long id;
    private final String name;
    private final String email;

    public ContactsTask(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}