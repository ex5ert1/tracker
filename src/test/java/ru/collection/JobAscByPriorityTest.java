package ru.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JobAscByPriorityTest {

    @Test
    void testAscByPriority() {
        Job job1 = new Job("X", 1);
        Job job2 = new Job("Y", 2);

        assertThat(new JobAscByPriority().compare(job1, job2)).isLessThan(0);
        assertThat(new JobAscByPriority().compare(job2, job1)).isGreaterThan(0);
    }
}