package org.example.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Suggestion {
    private String keyword;
    private String link;
}
