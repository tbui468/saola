package dev.bui.saola;

class InstructorNotFoundException extends RuntimeException {
    InstructorNotFoundException(Long id) {
        super("Could not find instructor " + id);
    }
}
