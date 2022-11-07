package web.backend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonListResponse<T> {
    private boolean success;
    private T result;
    private int count;
    @JsonProperty("totalCount")
    private long totalCount;

}
