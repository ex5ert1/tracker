package ru.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JobAscByNameTest {

    @Test
    void testAscByName() {
        Job job1 = new Job("A", 1);
        Job job2 = new Job("B", 2);

        assertThat(new JobAscByName().compare(job1, job2)).isLessThan(0);
        assertThat(new JobAscByName().compare(job2, job1)).isGreaterThan(0);
    }
}