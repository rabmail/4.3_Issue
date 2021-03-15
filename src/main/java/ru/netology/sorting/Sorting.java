package ru.netology.sorting;

import lombok.SneakyThrows;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting implements Comparator<Issue> {

    @SneakyThrows
    @Override
    public int compare(Issue o1, Issue o2) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        final Date date1 = format.parse(o1.getDataCreation());
        final Date date2 = format.parse(o2.getDataCreation());
        return date1.compareTo(date2);
    }

}