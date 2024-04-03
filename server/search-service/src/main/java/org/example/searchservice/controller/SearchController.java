package org.example.searchservice.controller;

import org.example.searchservice.model.Suggestion;
import org.example.searchservice.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SearchController {
    @Autowired
    private SuggestionService suggestionService;
    @GetMapping("search-suggestion")
    public ResponseEntity<List<Suggestion>> search(@RequestParam String q){
        return ResponseEntity.ok(suggestionService.getDynamicSearchSuggestions(q));
    }

    @GetMapping("default-search-suggestion")
    public ResponseEntity<List<Suggestion>> searchDefault(){
        return ResponseEntity.ok(suggestionService.getDefaultSearchSuggestions());
    }
}
