package ru.skypro;

public class Employee {

    public static int count;
    private final String foi;
    private int depart; // {1...5}
    private double salary;
    private final int id;

    public Employee(String foi, int depart, double salary) {
        this.foi = foi;
        this.depart = depart;
        this.salary = salary;
        id = ++count;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFoi() {
        return foi;
    }

    public int getDepart() {
        return depart;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "ID: " + id +
                ", ФИО: " + foi +
                ", Отдел: " + depart +
                ", Зарплата: " + salary +
                '}';
    }
}
