package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.manager.domain.Issue;
import ru.manager.repository.RepositoryIssueList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class TestIssue {

    @Mock
    private Collection<Issue> issues = new ArrayList<>();

    @InjectMocks
    private RepositoryIssueList managerIssue;
    private Issue is1 = new Issue(1, "Vasa", "Java", "Pupkin", "123", false);
    private Issue is2 = new Issue(2, "Pupkin", "Java", "Ivanov", "123", true);
    private Issue is3 = new Issue(3, "Pupkin", "Java", "Semenov", "321", true);
    private Issue is4 = new Issue(4, "Vasa", "Java", "Pupkin", "123", false);
    private Issue is5 = new Issue(5, "Ivan", "Delphi", "Vasa", "321", true);


    @Test
    public void shouldAdd() {
        Issue[] actual = new Issue[]{is1, is2, is3, is4, is5};
        Issue[] expected = new Issue[]{is1,is2,is3,is4,is5};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveById() {
        issues.add(is1);
        issues.add(is2);
        issues.add(is3);
        issues.add(is4);
        issues.add(is5);
        issues.remove(is4);
        Issue[] actual = issues.toArray(new Issue[0]);
        Issue[] expected = new Issue[]{is1, is2, is3, is5};
        assertArrayEquals(actual, expected);
    }
}

