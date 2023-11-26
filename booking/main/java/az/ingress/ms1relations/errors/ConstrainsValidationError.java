package az.ingress.ms1relations.errors;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ConstrainsValidationError {
    String property;

    String message;
}
