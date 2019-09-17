package com.lib.kodillalibrary.controller.exceptions;

public class NotFoundException extends Exception {

    public NotFoundException(Long id) {
        super("Id not found: " + id);
    }
}
