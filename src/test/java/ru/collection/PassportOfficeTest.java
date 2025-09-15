package ru.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDuplicatePassport() {
        Citizen citizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        assertThat(office.add(citizen)).isTrue();
        assertThat(office.add(citizen)).isFalse();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }
}