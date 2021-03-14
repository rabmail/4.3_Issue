package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;


public class RepositoryIssueList {
    private List<Issue> issues = new ArrayList<>();

    public void openIssueID(List<Issue> issues, int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(true);
            }
        }
    }

    public void closeIssueID(List<Issue> issues, int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(false);
            }
        }
    }

    public boolean add(Issue items) {

        return this.issues.add(items);
    }

    public List<Issue> getAll() {

        return issues;
    }


    public Issue findById(int id) {
        for (Issue item : issues) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {

        issues.removeIf(items -> items.getId() == id);
    }

    public List<Issue> findClose(List<Issue> issues) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.isStatus() == false) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> findOpen(List<Issue> issues) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.isStatus() == true) {
                result.add(issue);
            }
        }
        return result;
    }
}
