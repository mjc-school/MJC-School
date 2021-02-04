package com.epam.esm.exception;


import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;


@ControllerAdvice
public class ApplicationExceptionHandler {
    public static final String NO_SUCH_RESOURCE_MESSAGE = "no_resource";
    public static final String TAG_EXISTS_MESSAGE = "tag_exist";
    public static final String NO_CERTIFICATE = "no_certificate";



    private final ReloadableResourceBundleMessageSource resourceBundle;

    public ApplicationExceptionHandler(ReloadableResourceBundleMessageSource resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<ExceptionDetails> handleInvalidDataException(InvalidDataException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorCode = status.value() + exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), exception.getMessage(), errorCode);
        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler({TagAlreadyExistsException.class, SQLException.class})
    public ResponseEntity<ExceptionDetails> handleTagAlreadyExistsException(InvalidDataException exception) {
        HttpStatus status = HttpStatus.CONFLICT;
        String message = getErrorResponse(TAG_EXISTS_MESSAGE);
        String errorCode = status.value() + exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), message, errorCode);
        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler({GeneralException.class})
    public ResponseEntity<ExceptionDetails> handlerGeneralException(GeneralException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorCode = status.value() + exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), exception.getMessage(), errorCode);
        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler(NoSuchResourceException.class)
    public ResponseEntity<ExceptionDetails> handleNoSuchResourceException(NoSuchResourceException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = getErrorResponse(NO_SUCH_RESOURCE_MESSAGE);
        String errorCode = status.value()+ exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now()
                , status.value(), message, errorCode);

        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler(IllegalEntityId.class)
    public ResponseEntity<ExceptionDetails> handleIllegalEntityId(IllegalEntityId exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = getErrorResponse(NO_CERTIFICATE);
        String errorCode = status.value()+ exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now()
                , status.value(), message, errorCode);

        return new ResponseEntity<>(data, status);
    }

    private String getErrorResponse(String key) {
        HttpServletRequest request = ((ServletRequestAttributes)Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Locale locale = request.getLocale();
        String bundleMessage = resourceBundle.getMessage(key, new Object[]{}, locale);

        return bundleMessage;
    }


}
