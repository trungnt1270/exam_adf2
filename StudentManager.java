package com.company;


import java.util.List;
import java.util.Scanner;


public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDao studentDao;


    public StudentManager() {
        studentDao = new StudentDao();
        studentList = studentDao.read();
    }

    /**
     * add student by id
     *
     * @param: student id
     */
    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " + id);
        String FirstName = inputFirstName();
        String LastName = inputLastName();
        int age = inputAge();

        Student student = new Student(id, FirstName, LastName, age);
        studentList.add(student);
        studentDao.write(studentList);
        System.out.println();
    }

    /**
     * delete student by id
     *
     * @param id: student id
     */
    public void delete(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentDao.write(studentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    /**
     * show list student to screen
     */
    public void show() {
        System.out.println("    id|       FistName       |        LastName      |  Age  |");
        for (Student student : studentList) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getFirstName());
            System.out.format("%20s | ", student.getLastName());
            System.out.format("%5d | ", student.getAge());
            System.out.println();
        }
    }

    /**
     * input student id
     *
     * @return student id
     */
    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }


    private String inputFirstName() {
        System.out.print("Input FirstName: ");
        return scanner.nextLine();
    }

    private String inputLastName() {
        System.out.print("Input LastName: ");
        return scanner.nextLine();
    }


    /**
     * input student age
     *
     * @return student age
     */
    private int inputAge() {
        System.out.print("Input student age: ");
        while (true) {
            try {
                int age = Integer.parseInt((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    // getter && setter
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}