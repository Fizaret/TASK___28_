package az.ingress.ms1relations.errors;

import org.springframework.http.HttpStatus;

public interface ErrorResponse {
    String getKey();

    String getMessage();

    HttpStatus getHttpStatus();

}
