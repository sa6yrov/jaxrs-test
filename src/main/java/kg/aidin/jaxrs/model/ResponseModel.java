package kg.aidin.jaxrs.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseModel {
    private boolean isSuccess;
    private Object data;
    private String message;
}
