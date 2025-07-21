package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"one", "1"},
                output
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"1"},
                output
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInputs() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "579"},
                output
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(579);
    }

    @Test
    void whenValidNegativeInputs() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[] {"-1", "2", "-579"},
                output
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(-1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(-579);
    }
}