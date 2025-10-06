package ru.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JobDescByPriorityTest {

    @Test
    void testDescByPriority() {
        Job job1 = new Job("X", 1);
        Job job2 = new Job("Y", 2);

        assertThat(new JobDescByPriority().compare(job1, job2)).isGreaterThan(0);
        assertThat(new JobDescByPriority().compare(job2, job1)).isLessThan(0);
    }
}