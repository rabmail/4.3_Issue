package ru.netology.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue  {
    private int id;
    private String dataCreation;
    private Author author;
    private Set<Author> assignee;
    private Set<Label>label;
    private String project;
    private boolean status; //если true активно else false


}
