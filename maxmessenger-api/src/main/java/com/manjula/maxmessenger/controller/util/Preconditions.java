package com.manjula.maxmessenger.controller.util;

import com.manjula.maxmessenger.controller.exception.ResourceNotFoundException;

import java.util.List;

public final class Preconditions {

    private Preconditions() {
        throw new AssertionError();
    }

    public static void validate(final boolean expression) {
        if (!expression) {
            throw new ResourceNotFoundException();
        }
    }

    public static <T> T validate(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

    public static <T> List<T> validate(final List<T> resource) {
        if (resource == null || resource.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

}

