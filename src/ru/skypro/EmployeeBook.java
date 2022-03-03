package ru.skypro;

import java.util.SortedSet;
import java.util.TreeSet;

public class EmployeeBook {

    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public Employee[] getEmployees() {
        return employees;
    }


    // Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    public void  showEmployeeInDepart(){
        SortedSet<Integer> ssDeparts = new TreeSet<>();
        for (Employee e: employees) {
            if (e != null) {
                ssDeparts.add(e.getDepart());
            }
        }
        for (int currDepart : ssDeparts) {
            System.out.println("Сотрудники отдела " + currDepart + ": ");
            for (Employee e : employees) {
                if (e != null) {
                    if (e.getDepart() == currDepart) {
                        System.out.println(e.getFoi());
                    }
                }
            }
        }
    }

// Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее.
// Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
    public void addEmployee(String foi, int depart, double salary){
        if (size >= employees.length) {
            System.out.println("Штат укомплектован. Свободных мест нет.");
            return;
        }
        Employee employee = new Employee(foi, depart, salary);

        for (int i = 0; i <= employees.length-1; i++) {
            if ( employees[i] == null ) {
                employees[i] = employee;
                size++;
                System.out.println("Сотрудник c ID=" + employees[i].getId() +  " и ФИО: " + foi + " добавлен.");
                break;
            }
        }
    }

// Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
    public void killEmployee(int id, String fio){
        for (int i = 0; i < employees.length; i++) {
            if ( employees[i] != null ) {
                if (employees[i].getFoi().equals(fio) && employees[i].getId() == id) {
                    employees[i] = null;
                    size--;
                    System.out.println("Сотрудник Номер: " + id + " ФИО: " + fio + " удален.");
                    return;
                }
            }
        }
        System.out.println("Сотрудник Номер: " + id + " ФИО: " + fio + " не найден.");
    }

// Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
// Изменить зарплату/Отдел.
    public void changeDepartSalary(String fio, int depart, double salary, int code){
        boolean isFound = false;
        for (int i = 0; i <= employees.length-1; i++) {
            if (employees[i] != null) {
                if ( employees[i].getFoi().equalsIgnoreCase(fio) ) {
                    switch (code) {
                        case 0 -> {
                            employees[i].setDepart(depart);
                            isFound = true;
                            System.out.println("Для сотрудника ФИО: " + fio + " изменен отдел на  " + employees[i].getDepart());
                        }
                        case 1 -> {
                            employees[i].setSalary(salary);
                            isFound = true;
                            System.out.println("Для сотрудника ФИО: " + fio + " изменена зарплата на " + employees[i].getSalary());
                        }
                        case 2 -> {
                            employees[i].setDepart(depart);
                            System.out.println("Для сотрудника ФИО: " + fio + " изменен отдел на  " + employees[i].getDepart());
                            employees[i].setSalary(salary);
                            System.out.println("Для сотрудника ФИО: " + fio + " изменена зарплата на " + employees[i].getSalary());
                            isFound = true;
                        }
                        default -> System.out.println("Неверный код!");
                    }
                }
            }
        }
        if (! isFound) {
            System.out.println("Сотрудник с ФИО: " + fio + " не найден!");
        }
    }

    public void showInfoEmployee(Employee[] employee) {
        for (Employee e: employee) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public double getAmountsMonth(Employee[] employee){
        double summa=0.0;
        for (Employee e: employee) {
            if (e != null) {
                summa += e.getSalary();
            }
        }
        return summa;
    }


    private double getSumma(Employee[] employee) {
        double result=0;
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
                result =  employee[i].getSalary();
            }
        }
        return result;
    }

    private int getIdSumme(Employee[] employee){
        int result = 0;
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
                result =  employee[i].getId();
            }
        }
        return result;
    }

    public void showMinSalaryEmployee(Employee[] employee){
        double minSumma = getSumma(employee);
        int minId = getIdSumme(employee);
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
                if (minSumma > employee[i].getSalary()) {
                    minSumma = employee[i].getSalary();
                    minId = i;
                }
            }
        }
        System.out.println("Минимальная зарплата " + employee[minId]);
    }

    public void showMaxSalaryEmployee(Employee[] employee){
        double maxSumma = getSumma(employee);
        int maxId = getIdSumme(employee);
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
                if (maxSumma < employee[i].getSalary()) {
                    maxSumma = employee[i].getSalary();
                    maxId = i;
                }
            }
        }
        System.out.println("Максимальная зарплата " + employee[maxId]);
    }

    public double avgSalary(Employee[] employee){
        return getAmountsMonth(employee) / size;
    }

    public void showFioForAll(Employee[] employee) {
        for (Employee e: employee) {
            if (e != null ) {
            System.out.println("Ф.И.О. сотрудника " + e.getId() + ": " + e.getFoi());
            }
        }
    }

    public void increaseSalaryForAll(double increase, Employee[] employee){
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
            employee[i].setSalary(employee[i].getSalary() * (1+increase));
            }
        }

    }

    public double startSalary(Employee[] employee, int depart) {
        double result = 0.0;
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
                if ((depart == employee[i].getDepart())) {
                    result = employee[i].getSalary();
                    break;
                }
            }
        }
        return result;
    }

    public double minSalaryInDepart(Employee[] employee, int depart) {
        double result = startSalary(employee, depart);
        for (int i = 0; i <= employee.length-1; i++) {
            if (employee[i] != null) {
                if (depart == employee[i].getDepart() && result > employee[i].getSalary()) {
                    result = employee[i].getSalary();
                }
            }
        }
        return result;
    }

    public double maxSalaryInDepart(Employee[] employee, int depart) {
        double result = startSalary(employee, depart);
        for (int i = 0; i <= employee.length-1; i++) {
            if (employee[i] != null) {
                if (depart == employee[i].getDepart() && result < employee[i].getSalary()) {
                    result = employee[i].getSalary();
                }
            }
        }
        return result;
    }

    public double salaryDepart(Employee[] employee, int depart) {
        double result = 0.0;
        for (Employee e : employee) {
            if (e != null) {
                if (e.getDepart() == depart) {
                    result += e.getSalary();
                }
            }
        }
        return result;
    }

    public double avgSalaryDepart(Employee[] employee, int depart) {
        double result = 0.0;
        int countEmployee = 0;
        for (Employee e : employee) {
            if (e != null) {
                if (e.getDepart() == depart) {
                    result += e.getSalary();
                    countEmployee++;
                }
            }
        }
        return result/countEmployee;
    }

    public void incSalaryDepart(Employee[] employee, int depart, double increase) {
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i] != null) {
                if (employee[i].getDepart() == depart) {
                    employee[i].setSalary(employee[i].getSalary() * (1 + increase));
                }
            }
        }
    }

    public void showEmployeeDepart(Employee[] employee, int depart) {
        for (Employee e: employee) {
            if (e != null) {
                if (e.getDepart() == depart) {
                    System.out.println(e.getId() + ", " + e.getFoi() + ", " + e.getSalary());
                }
            }
        }
    }

    public void showEmployeeDepartMinSalary(Employee[] employee, double salary) {
        for (Employee e: employee) {
            if (e != null) {
                if (e.getSalary() < salary) {
                    System.out.println(e.getId() + ", " + e.getFoi() + ", " + e.getSalary());
                }
            }
        }
    }

    public void showEmployeeDepartMaxSalary(Employee[] employee, double salary) {
        for (Employee e: employee) {
            if (e != null) {
                if (e.getSalary() >= salary) {
                    System.out.println(e.getId() + ", " + e.getFoi() + ", " + e.getSalary());
                }
            }
        }
    }

}
