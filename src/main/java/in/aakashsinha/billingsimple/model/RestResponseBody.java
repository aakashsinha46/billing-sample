package in.aakashsinha.billingsimple.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@Builder
public class RestResponseBody<T> {

    private String message;
    private HttpStatus status;
    private T data;
    private Instant timestamp;

}
