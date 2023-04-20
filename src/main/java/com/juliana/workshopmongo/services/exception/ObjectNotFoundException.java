package com.juliana.workshopmongo.services.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6290509673540288624L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
