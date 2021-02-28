package ru.manager.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue  implements Comparable<Issue>{
    private int id;
    private String author;
    private String label;
    private String assignee;
    private String project;
    private boolean status; //если true активно else false




    @Override
    public int compareTo(Issue o) {
            return id - o.id;
    }

}
