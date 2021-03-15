package ru.netology.manager;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.RepositoryIssueList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ManagerIssue {

    private RepositoryIssueList repository;

    public ManagerIssue(RepositoryIssueList repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> filterAuthor(Author author) {
        return repository.getAll()
                .stream()
                .filter(issue -> issue.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Issue> filterAssignee(Author author) {
        return repository.getAll()
                .stream()
                .filter(issue -> issue.getAssignee().contains(author))
                .collect(Collectors.toList());
    }

    public List<Issue> filterLabel(Label label) {
        return repository.getAll()
                .stream()
                .filter(issue -> issue.getLabel().contains(label))
                .collect(Collectors.toList());
    }


}
