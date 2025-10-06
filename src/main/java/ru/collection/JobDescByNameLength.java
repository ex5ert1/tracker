package ru.collection;

import java.util.Comparator;

public class JobDescByNameLength implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getName().length(), o1.getName().length());
    }

    public static Comparator<Job> getCombinedComparator() {
        return new JobDescByNameLength()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
    }
}
