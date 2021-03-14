package ru.manager.manager;

import lombok.Data;
import ru.manager.domain.Issue;
import ru.manager.repository.RepositoryIssueList;

import java.util.List;


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

}
