package org.example.searchservice.service;

import org.example.searchservice.entity.ApparelCategory;
import org.example.searchservice.entity.BrandCategory;
import org.example.searchservice.entity.Category;
import org.example.searchservice.entity.GenderCategory;
import org.example.searchservice.model.DefaultSuggestion;
import org.example.searchservice.model.Suggestion;
import org.example.searchservice.repository.ApparelCategoryRepository;
import org.example.searchservice.repository.BrandCategoryRepository;
import org.example.searchservice.repository.GenderCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestionService {

    @Autowired
    private ApparelCategoryRepository apparelCategoryRepository;

    @Autowired
    private GenderCategoryRepository genderCategoryRepository;

    @Autowired
    private BrandCategoryRepository productBrandCategoryRepository;

    public List<DefaultSuggestion> getDefaultSearchSuggestions() {
        List<DefaultSuggestion> suggestions = new ArrayList<>();
        suggestions.addAll(getSuggestionsFromApparelCategory());
        suggestions.addAll(getSuggestionsFromGenderCategory());
        suggestions.addAll(getSuggestionsFromProductBrandCategory());
        return suggestions;
    }

    public List<Suggestion> getDynamicSearchSuggestions(String query) {
        List<Suggestion> suggestions = new ArrayList<>();
        suggestions.addAll(getSuggestionsFromApparelCategory(query));
        suggestions.addAll(getSuggestionsFromGenderCategory(query));
        suggestions.addAll(getSuggestionsFromProductBrandCategory(query));
        return suggestions;
    }

    private List<DefaultSuggestion> getSuggestionsFromApparelCategory() {
        List<ApparelCategory> categories = apparelCategoryRepository.findAll();
        return buildDefautSuggestions(categories);
    }

    private List<DefaultSuggestion> getSuggestionsFromGenderCategory() {
        List<GenderCategory> categories = genderCategoryRepository.findAll();
        return buildDefautSuggestions(categories);
    }

    private List<DefaultSuggestion> getSuggestionsFromProductBrandCategory() {
        List<BrandCategory> categories = productBrandCategoryRepository.findAll();
        return buildDefautSuggestions(categories);
    }

    private List<DefaultSuggestion> buildDefautSuggestions(List<? extends Category> categories){
        List<DefaultSuggestion> suggestions=new ArrayList<>();
        for(Category category:categories){
            suggestions.add(new DefaultSuggestion(category.getKeyword()));
        }
        return suggestions;
    }

    private List<Suggestion> getSuggestionsFromApparelCategory(String query) {
        List<ApparelCategory> categories = apparelCategoryRepository.findByTypeStartingWith(query);
        return buildSuggestions(categories, "apparels");
    }

    private List<Suggestion> getSuggestionsFromGenderCategory(String query) {
        List<GenderCategory> categories = genderCategoryRepository.findByTypeStartingWith(query);
        return buildSuggestions(categories, "genders");
    }

    private List<Suggestion> getSuggestionsFromProductBrandCategory(String query) {
        List<BrandCategory> categories = productBrandCategoryRepository.findByTypeStartingWith(query);
        return buildSuggestions(categories, "brands");
    }

    private List<Suggestion> buildSuggestions(List<? extends Category> categories, String tableName) {
        List<Suggestion> suggestions = new ArrayList<>();
        for (Category category : categories) {
            String link = tableName +"="+ category.getId();
            suggestions.add(new Suggestion(category.getKeyword(), link));
        }
        return suggestions;
    }
}
