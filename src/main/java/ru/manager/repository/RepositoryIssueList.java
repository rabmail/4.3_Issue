package ru.manager.repository;

import ru.manager.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class RepositoryIssueList extends ArrayList{
    private List<Issue> items = new ArrayList<>();

    public boolean addAll2(Collection<? extends Issue> items) {
        return this.items.addAll(items);
    }

    public void addAll3(Collection<? extends Issue> item) {
        items.addAll(item);
    }

    public void save(Issue item) {
        items.add(item);
    }


    //
//    public static RepositoryIssue save0(Issue item) {
//        RepositoryIssue repositoryIssueList= new RepositoryIssue();
//        repositoryIssueList.add(item);
//        return repositoryIssueList;
 //   }

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
