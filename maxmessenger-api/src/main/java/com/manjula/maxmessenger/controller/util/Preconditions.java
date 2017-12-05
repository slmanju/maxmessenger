package com.manjula.maxmessenger.controller.util;

import com.manjula.maxmessenger.controller.exception.NotFoundException;

import java.util.List;

public final class Preconditions {

    private Preconditions() {
        throw new AssertionError();
    }

    public static void validate(final boolean expression) {
        if (!expression) {
            throw new NotFoundException();
        }
    }

    public static <T> T validate(final T resource) {
        if (resource == null) {
            throw new NotFoundException();
        }
        return resource;
    }

    public static <T> List<T> validate(final List<T> resource) {
        if (resource == null || resource.isEmpty()) {
            throw new NotFoundException();
        }
        return resource;
    }

}

