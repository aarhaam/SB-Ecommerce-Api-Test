package com.mahardika.ecommerce.api.exceptions;

public class Error {

  private static final long serialVersionUUID = 1l;
  private String errorCode;
  private String message;
  private Integer status;
  private String url = "Not available";
  private String reqMethod = "Not Available";

  
  public static long getSerialversionuuid() {
    return serialVersionUUID;
  }
  public String getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getReqMethod() {
    return reqMethod;
  }
  public void setReqMethod(String reqMethod) {
    this.reqMethod = reqMethod;
  }

  

}
