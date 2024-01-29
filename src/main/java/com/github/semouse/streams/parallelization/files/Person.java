package com.github.semouse.streams.parallelization.files;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int personId;

    public Person(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }
}
