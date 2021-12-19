package dev.bui.saola;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;

    public Student() {}

    Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student)o;
        return Objects.equals(this.id, s.id) && Objects.equals(this.name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Student{name='" + this.name + "'}";
    }
}
