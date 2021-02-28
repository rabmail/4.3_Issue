package ru.manager.repository;

import ru.manager.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class RepositoryIssue {
    private List<Issue> items = new ArrayList<>();



    public boolean addAll(Collection<? extends Issue> items) {
        return this.items.addAll(items);
    }


    public void save(Issue item) {
        items.add(item);
    }

    public List<Issue> getAll() {
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
