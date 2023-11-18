package az.ingress.ms1relations.errors;

import org.springframework.http.HttpStatus;

public enum Errors implements ErrorResponse {

    jakarta_NOT_NULL("jakarta.validation.constraints.Not.Null.message",
            HttpStatus.BAD_REQUEST,"deyer bos ola bilmez ,get doldur"),
    BOOKING_NOT_FOUND("BOOKING_NOT_FOUND",
            HttpStatus.NO_CONTENT,"bu booking yoxdur");


    String key;
    HttpStatus httpStatus;

    String message;
    Errors(String key,HttpStatus httpStatus,String message){
        this.message=message;
        this.key=key;
        this.httpStatus=httpStatus;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
