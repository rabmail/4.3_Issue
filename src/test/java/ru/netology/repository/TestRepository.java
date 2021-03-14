package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Author;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.manager.ManagerIssue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRepository {

    RepositoryIssueList repository = new RepositoryIssueList();
    ManagerIssue manager = new ManagerIssue(repository);

    private Author au1 = new Author(1, "Vasa");
    private Author au2 = new Author(2, "Pupkin");
    private Author au3 = new Author(3, "Vasa2");
    private Author au4 = new Author(4, "Ivan");
    private Author au5 = new Author(5, "Vasiliy Pupkin");
    private Set<Author> assignees = new HashSet<>();
    private Set<Integer> number = new HashSet<>();

    private Label lb1 = new Label(1, "Test1");
    private Label lb2 = new Label(2, "Test2");
    private Label lb3 = new Label(3, "Test3");
    private Label lb4 = new Label(4, "Test4");
    private Label lb5 = new Label(5, "Test5");
    private Set<Label> labels = new HashSet<>();

    private Issue is1 = new Issue(1, "14.02.2021", au1, assignees, labels, "java", false);
    private Issue is2 = new Issue(2, "14.01.2021", au2, assignees, labels, "delphi", true);
    private Issue is3 = new Issue(3, "14.03.2021", au3, assignees, labels, "java", true);
    private Issue is4 = new Issue(4, "08.02.2021", au1, assignees, labels, "C++", false);
    private Issue is5 = new Issue(5, "08.02.2021", au5, assignees, labels, "java", true);

    @Nested
    class AllIssue {
        @BeforeEach
        public void set() {
            labels.addAll(List.of(lb1, lb2, lb3, lb4, lb5));
            assignees.addAll(List.of(au1, au2, au3, au4, au5));

            manager.add(is1);
            manager.add(is2);
            manager.add(is3);
            manager.add(is4);
            manager.add(is5);
        }

        @Test
        void shouldAllOpenIssue() {
            List<Issue> actual = repository.findOpen(repository.getAll());
            List<Issue> expected = new ArrayList<>();
            expected.addAll(List.of(is2,is3,is5));
            assertEquals(expected, actual);
        }

        @Test
        void shouldAllCloseIssue() {
            List<Issue> actual = repository.findClose(repository.getAll());
            List<Issue> expected = new ArrayList<>();
            expected.addAll(List.of(is1,is4));
            assertEquals(expected, actual);
        }
        @Test
        void shouldOpenIssue() {
           repository.openIssueID(repository.getAll(),1);
            List<Issue> actual = repository.getAll();
            List<Issue> expected = new ArrayList<>();
            expected.add(new Issue(1, "14.02.2021", au1, assignees, labels, "java", true));
            expected.add(is2);
            expected.add(is3);
            expected.add(is4);
            expected.add(is5);
            assertEquals(expected, actual);
        }

        @Test
        void shouldCloseIssue() {
            repository.closeIssueID(repository.getAll(),2);
            List<Issue> actual = repository.getAll();
            List<Issue> expected = new ArrayList<>();
            expected.add(is1);
            expected.add(new Issue(2, "14.01.2021", au2, assignees, labels, "delphi",false));
            expected.add(is3);
            expected.add(is4);
            expected.add(is5);
            assertEquals(expected, actual);
        }


    }

}
