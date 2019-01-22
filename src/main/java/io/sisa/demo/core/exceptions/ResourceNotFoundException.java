package io.sisa.demo.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by isaozturk on 21.01.2019
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends MyAppException{

    public ResourceNotFoundException(String errorCode, Object... messageArguments) {
        super(errorCode, messageArguments);
    }
}
