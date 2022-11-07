package web.backend.module.common.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommonDataListDto {
    @JsonProperty("companyCode")
    private String companyCode;

    @JsonProperty("componentTitle")
    private String componentTitle;

    @JsonProperty("searchText")
    private String searchText;

    @JsonProperty("searchSelectBox")
    private String searchSelectBox;

    @JsonProperty("searchSubSelectBox")
    private String searchSubSelectBox;

    @JsonProperty("searchDateBox")
    private String searchDateBox;

    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @JsonProperty("endDate")
    private LocalDateTime endDate;

    @JsonProperty("pageNumber")
    private int pageNumber;

    @JsonProperty("postNumber")
    private int postNumber;

    @JsonProperty("bodyNumber")
    private int bodyNumber;
}
