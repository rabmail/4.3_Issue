package ru.manager.repository;

import ru.manager.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class RepositoryIssueList extends ArrayList{
    private List<Issue> items = new ArrayList<>();

    public boolean add(Issue items) {

        return this.items.add(items);
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
