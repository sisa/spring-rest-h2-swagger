package io.sisa.demo.core.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;
import java.util.Optional;

/**
 * Created by isaozturk on 21.01.2019
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DefaultException extends RuntimeException {

    private final String errorCode;

    private final Object[] messageArguments;

    public DefaultException() {
        this.errorCode = null;
        this.messageArguments = new Object[0];
    }

    public DefaultException(Exception e) {
        super(e.getMessage(), e);
        this.errorCode = null;
        this.messageArguments = new Object[0];
    }

    public DefaultException(String errorCode, Object... messageArguments) {
        this.errorCode = errorCode;
        this.messageArguments = messageArguments;
    }

    public Optional<String> getErrorCode() {
        return Optional.ofNullable(errorCode);
    }

    public String getMessage(MessageSource messageSource, Locale locale) {
        if (errorCode == null) {
            // this is a wrap exception, use original exception's message
            return this.getMessage();
        }
        else {
            return messageSource.getMessage(errorCode, messageArguments, locale);
        }
    }

    public Object[] getMessageArguments() {
        return this.messageArguments;
    }
}
