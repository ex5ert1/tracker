package ru.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JobDescByNameTest {

    @Test
    void testDescByName() {
        Job job1 = new Job("А", 1);
        Job job2 = new Job("B", 2);

        assertThat(new JobAscByName().compare(job1, job2)).isLessThan(0);
        assertThat(new JobAscByName().compare(job2, job1)).isGreaterThan(0);
    }
}