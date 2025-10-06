package ru.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void testCombinedAscByNameThenPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("FirstTest", 0),
                new Job("FurstBug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void testCombinedDescByNameThenPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("SecondTest", 0),
                new Job("SecondBug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void testCombinedAscByPriorityThenName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("ThirdTest", 0),
                new Job("ThirdBug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void testCombinedDescByPriorityThenName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("FourthTest", 0),
                new Job("FourthBug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}