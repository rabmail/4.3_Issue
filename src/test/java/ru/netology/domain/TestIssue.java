package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.manager.domain.Issue;
import ru.manager.repository.RepositoryIssue;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestIssue {

    private RepositoryIssue repository = new RepositoryIssue();
    private Issue Is1 = new Issue(1, "Vasa", "Java", "Pupkin", "123", false);
    private Issue Is2 = new Issue(2, "Pupkin", "Java", "Ivanov", "123", true);
    private Issue Is3 = new Issue(3, "Pupkin", "Java", "Semenov", "321", true);
    private Issue Is4 = new Issue(4, "Vasa", "Java", "Pupkin", "123", false);
    private Issue Is5 = new Issue(5, "Ivan", "Delphi", "Vasa", "321", true);

    @Test
    public void shouldSaveAll() {
        List<Issue> returned = List.of(Is1, Is2, Is3, Is4, Is5);
      //  Issue[] actual = repository.findAll();

        Issue[] expected = new Issue[]{Is1, Is2, Is3, Is4, Is5};
      //  assertArrayEquals(actual, expected);
    }
}
    //    @Test
//    void shouldRemoveByIdException(){
//        repository.save(Prod1);
//        repository.save(Prod2);
//        repository.save(Prod3);
//        repository.save(Prod4);
//        repository.save(Prod5);
//        ProductManager managers = new ProductManager(repository);
//        int id = 8;
//        assertThrows(NotFoundException.class, () -> managers.removeById(id));
//    }
//

