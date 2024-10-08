package com.elotech.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@JsonIgnoreProperties
public class GoogleBooksItem {
    @JsonProperty("volumeInfo")
    private GoogleBooksVolumeInfo googleBooksVolumeInfo;
}
