package main.algorithms.models;

import main.ds.array.Array;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(final Object student) {
        if (this == student) {
            return true;
        }

        if (student == null) {
            return false;
        }

        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student anotherStudent = (Student) student;

        return this.name.equals(anotherStudent.name);
    }

    @Override
    public int compareTo(final Student another) {
//        if (this.score < another.score) {
//            return -1;
//        } else if (this.score == another.score) {
//            return 0;
//        }
//        return 1;
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addFirst(new Student("Alice", 90));
        arr.addFirst(new Student("Bob", 100));
        arr.addFirst(new Student("Charlie", 68));
        System.out.println(arr);
    }
}
