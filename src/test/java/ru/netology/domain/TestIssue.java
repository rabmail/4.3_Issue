package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ManagerIssue;
import ru.netology.repository.RepositoryIssueList;

import java.util.*;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestIssue {

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
    private Issue is3 = new Issue(3, "14.03.2021", au3, assignees, labels, "java", false);
    private Issue is4 = new Issue(4, "08.02.2021", au1, assignees, labels, "C++", true);
    private Issue is5 = new Issue(5, "08.02.2021", au5, assignees, labels, "java", false);

    @Nested
    class AllIssue {
        @BeforeEach
        public void setUp() {
            labels.add(lb1);
            labels.add(lb2);
            labels.add(lb3);
            labels.add(lb4);
            labels.add(lb5);

            assignees.add(au1);
            assignees.add(au2);
            assignees.add(au3);
            assignees.add(au4);
            assignees.add(au5);

            manager.add(is1);
            manager.add(is2);
            manager.add(is3);
            manager.add(is4);
            manager.add(is5);
        }
        @Test
        void shouldFilterAutorYes() {
            List<Issue> actual = manager.filterAuthor(au1);
            List<Issue> expected = new ArrayList<>();
            expected.add(is1);
            expected.add(is4);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAutorNo() {
            List<Issue> actual = manager.filterAuthor(au4);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeYes() {
            List<Issue> actual = manager.filterAuthor(au1);
            List<Issue> expected = new ArrayList<>();
            expected.add(is1);
            expected.add(is4);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterAssigneeNo() {
            List<Issue> actual = manager.filterAuthor(au4);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelYes() {
            List<Issue> actual = manager.filterAuthor(au1);
            List<Issue> expected = new ArrayList<>();
            expected.add(is1);
            expected.add(is4);
            assertEquals(expected, actual);
        }

        @Test
        void shouldFilterLabelNo() {
            List<Issue> actual = manager.filterAuthor(au4);
            List<Issue> expected = new ArrayList<>();
            assertEquals(expected, actual);
        }
    }

}