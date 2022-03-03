package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Иванов Иван Иванович", 1, 1111.32);
        employeeBook.addEmployee("Семен Семенович Горбунков",  2, 0.55);
        employeeBook.addEmployee("Иванов Иван Васильевич", 3, 12.43);
        employeeBook.addEmployee("Сафронов Перт Викторович",  4, 21.43);
        employeeBook.addEmployee("Ситников Алексей Макарович",  5, 0.01);
        employeeBook.addEmployee("Коржаков Дмитрий Владимирович",  1, 31.56);
        employeeBook.addEmployee("Терехова Маргарита Михайловны",  2, 61.67);
        employeeBook.addEmployee("Жуков Станислав Петрович",  3, 441.17);
        employeeBook.addEmployee("Юдина Елена Дмитриевна",  4, 15.10);
//        employeeBook.addEmployee("Судаков Василий Андреевич",  5, 0.11);
//        employeeBook.addEmployee("Мамон Мамон Мамон",  5, 1.11); // 11 Error

// Base
        employeeBook.showInfoEmployee(employeeBook.getEmployees());
        System.out.println("Сумму затрат на зарплаты в месяц: " + employeeBook.getAmountsMonth(employeeBook.getEmployees()) );
        employeeBook.showMinSalaryEmployee(employeeBook.getEmployees());
        employeeBook.showMaxSalaryEmployee(employeeBook.getEmployees());
        System.out.println("Среднее значение зарплат: " + employeeBook.avgSalary(employeeBook.getEmployees()));
        employeeBook.showFioForAll(employeeBook.getEmployees());
// Middle
        employeeBook.increaseSalaryForAll(.1, employeeBook.getEmployees());
        System.out.println("Увеличение з/п всем Сотрудникам на 10%: ");
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

//        2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
//        1. Сотрудника с минимальной зарплатой.
        System.out.println("Мин. з.п. сотрудника в отделе № " + 1 + " равна: "  +  employeeBook.minSalaryInDepart(employeeBook.getEmployees(), 1));
//        2. Сотрудника с максимальной зарплатой.
        System.out.println("Макс. з.п. сотрудника в отделе № " + 1 + " равна: "  +  employeeBook.maxSalaryInDepart(employeeBook.getEmployees(), 1));

//        3. Сумму затрат на зарплату по отделу.
        System.out.println("Сумму затрат на зарплату по отделу № " + 1 + " равна: "  +  employeeBook.salaryDepart(employeeBook.getEmployees(), 1));

//        4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        System.out.println("Среднюю зарплату по отделу № " + 1 + " равна: "  +  employeeBook.avgSalaryDepart(employeeBook.getEmployees(), 1));

//        5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        double increase = 0.25;
        System.out.println("Проиндексирована зарплата всех сотрудников отдела № " + 1 +  " на процент " + increase * 100  + " = ");
        employeeBook.incSalaryDepart(employeeBook.getEmployees(), 1, increase);
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

//        6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        System.out.println("Сотрудники отдела № " + 1 + ": ");
        employeeBook.showEmployeeDepart(employeeBook.getEmployees(), 1);

//        Получить в качестве параметра число и найти:
//        Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        double value = 20.5;
        System.out.println("Всех сотрудников с зарплатой < " + value);
        employeeBook.showEmployeeDepartMinSalary(employeeBook.getEmployees(), value);

//        Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
        System.out.println("Всех сотрудников с зарплатой >=  " + value);
        employeeBook.showEmployeeDepartMaxSalary(employeeBook.getEmployees(), value);


// Hard
        employeeBook.addEmployee("Судаков Василий Андреевич",  5, 0.11);
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

        employeeBook.killEmployee(5, "Ситников Алексей Макарович");
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

        employeeBook.addEmployee("Ситников Алексей Макарович",  5, 0.01 );
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

        employeeBook.killEmployee(2, "Семен Семенович Горбунков");
        employeeBook.killEmployee(4, "Сафронов Перт Викторович");
        employeeBook.killEmployee(6, "Коржаков Дмитрий Владимирович");
        employeeBook.killEmployee(8, "Жуков Станислав Петрович");
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

        employeeBook.addEmployee("Семен Семенович Горбунков",  2, 0.55);
        employeeBook.addEmployee("Коржаков Дмитрий Владимирович",  1, 31.56);
        employeeBook.addEmployee("Жуков Станислав Петрович",  3, 441.17);
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

//        5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
//        1. Изменить зарплату.
//        2. Изменить отдел.
//        Придумать архитектуру. Сделать или два метода, или один, но продумать его.
        employeeBook.changeDepartSalary("Семен Семенович Горбунков", 50, 1001.50,0);
        employeeBook.changeDepartSalary("Артем Семенович Горбунков", 50, 1001.50,0);
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

        employeeBook.changeDepartSalary("Семен Семенович Горбунков", 50, 1001.50,0);
        employeeBook.changeDepartSalary("Коржаков Дмитрий Владимирович", 50, 2002.50,1);
        employeeBook.changeDepartSalary("Жуков Станислав Петрович", 80, 3003.50,2);
        employeeBook.showInfoEmployee(employeeBook.getEmployees());

// Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
        employeeBook.showEmployeeInDepart();

    }

}
