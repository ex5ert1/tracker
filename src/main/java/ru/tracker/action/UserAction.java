package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.core.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);

}
