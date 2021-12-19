package dev.bui.saola;

public class LessonNotFoundException extends RuntimeException {
    LessonNotFoundException(Long id) {
        super("Could not find lesson " + id);
    }
}
