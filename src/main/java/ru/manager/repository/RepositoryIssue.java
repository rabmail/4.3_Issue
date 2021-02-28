package ru.manager.repository;

import ru.manager.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class RepositoryIssue {
    private Collection<Issue> items = new ArrayList<>();

    public void save(Issue item) {
        items.add(item);
    }

    public Collection<Issue> findAll() {
        return items;
    }

    public Issue findById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        items.removeIf(items -> items.getId() == id);
    }


}
