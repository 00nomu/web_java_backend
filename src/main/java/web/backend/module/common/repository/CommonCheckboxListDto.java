package web.backend.module.common.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CommonCheckboxListDto {

    @JsonProperty("checkboxList")
    private List<String> checkboxList;
}
