package com.mahardika.ecommerce.api.exceptions;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestApiErrorHandler {

  private static final Logger log = LoggerFactory.getLogger(RestApiErrorHandler.class);
  private final MessageSource messageSource;

  @Autowired
  public RestApiErrorHandler(MessageSource messageSource){
    this.messageSource = messageSource;
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> handleException(HttpServletRequest request, Exception ex,
                                               Locale locale) {
    ex.printStackTrace(); // TODO: Should be kept only for development
    Error error = ErrorUtils.createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(), ErrorCode.GENERIC_ERROR.getErrCode(),
      HttpStatus.INTERNAL_SERVER_ERROR.value());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  public ResponseEntity<Error> handleHttpMediaTypeNotSupportedException(HttpServletRequest request,
      HttpMediaTypeNotSupportedException ex,
      Locale locale) {
    ex.printStackTrace(); // TODO: Should be kept only for development
    Error error = ErrorUtils
        .createError(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey(),
            ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode(),
            HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
    log.info("HttpMediaTypeNotSupportedException :: request.getMethod(): " + request.getMethod());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
