package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.repository.RepositoryIssueList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Data
    public class ManagerIssue {
        private RepositoryIssueList repository;

    public ManagerIssue(RepositoryIssueList repository)
    {
        this.repository = repository;
    }

    public void add(Issue issue) {

        repository.add(issue);
    }

    public List<Issue> getAll() {

        return repository.getAll();
    }

    public List<Issue> filterAuthor(Author author) {
        List<Issue> issues = repository.getAll();
        Predicate<Issue> predicate = obj -> obj.getAuthor().equals(author);
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }
}
