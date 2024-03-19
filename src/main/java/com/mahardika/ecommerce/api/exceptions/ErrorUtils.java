package com.mahardika.ecommerce.api.exceptions;

public class ErrorUtils {

  private ErrorUtils() {}

  public static final Error createError(final String errMsgKey, final String errorCode, final Integer httpStatusCode){
    Error error = new Error();
    error.setMessage(errMsgKey);
    error.setErrorCode(errorCode);
    error.setStatus(httpStatusCode);
    return error;
  }

}
