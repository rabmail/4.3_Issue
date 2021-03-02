package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.manager.domain.Issue;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TestIssue {
    private Collection<Issue> issues = new ArrayList<>();
    private Issue Is1 = new Issue(1, "Vasa", "Java", "Pupkin", "123", false);
    private Issue Is2 = new Issue(2, "Pupkin", "Java", "Ivanov", "123", true);
    private Issue Is3 = new Issue(3, "Pupkin", "Java", "Semenov", "321", true);
    private Issue Is4 = new Issue(4, "Vasa", "Java", "Pupkin", "123", false);
    private Issue Is5 = new Issue(5, "Ivan", "Delphi", "Vasa", "321", true);

    @Test
    public void shouldSaveAll() {
        issues.add(Is1);
        issues.add(Is2);
        issues.add(Is3);
        issues.add(Is4);
        issues.add(Is5);

        Issue[] actual = issues.toArray(new Issue[0]);
        Issue[] expected = new Issue[]{Is1, Is2, Is3, Is4, Is5};
        assertArrayEquals(actual, expected);
    }
}
