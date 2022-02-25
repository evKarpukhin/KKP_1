package ru.skypro;

public class Main {

    public static void showInfoEmployee(Employee[] employee) {
        for (Employee e: employee) {
            System.out.println(e);
        }
    }

    public static double getAmountsMonth(Employee[] employee){
        double summa=0.0;
        for (Employee e: employee) {
            summa += e.getSalary() ;
        }
        return summa;
    }

    public static void showMinSalaryEmployee(Employee[] employee){
        double minSumma = employee[0].getSalary();
        int minId = employee[0].getId() - 1;
        for (int i = 0; i <= employee.length - 1; i++) {
            if (minSumma > employee[i].getSalary() ) {
                minSumma = employee[i].getSalary();
                minId = i;
            }
        }
        System.out.println("Минимальная зарплата " + employee[minId]);
    }

    public static void showMaxSalaryEmployee(Employee[] employee){
        double maxSumma = employee[0].getSalary();
        int maxId = employee[0].getId() - 1;
        for (int i = 0; i <= employee.length - 1; i++) {
            if (maxSumma < employee[i].getSalary() ) {
                maxSumma = employee[i].getSalary();
                maxId = i;
            }
        }
        System.out.println("Максимальная зарплата " + employee[maxId]);
    }

    public static double avgSalary(Employee[] employee){
        return getAmountsMonth(employee) / employee.length;
    }

    public static void showFioForAll(Employee[] employee) {
        for (Employee e: employee) {
            System.out.println("Ф.И.О. сотрудника " + e.getId() + ": " + e.getFoi());
        }
    }

    public static void increaseSalaryForAll(double increase, Employee[] employee){
        for (int i = 0; i <= employee.length - 1; i++) {
            employee[i].setSalary(employee[i].getSalary() * (1+increase));
        }

    }

    public static double startSalary(Employee[] employee, int depart) {
        double result = 0.0;
        for (int i = 0; i <= employee.length - 1; i++) {
            if ((depart == employee[i].getDepart())) {
                result = employee[i].getSalary();
                break;
            }
        }
        return result;
    }

    public static double minSalaryInDepart(Employee[] employee, int depart) {
        double result = startSalary(employee, depart);
        for (int i = 0; i <= employee.length-1; i++) {
            if ( depart == employee[i].getDepart() &&  result > employee[i].getSalary() ) {
                    result = employee[i].getSalary();
                }
        }
        return result;
    }


    public static double maxSalaryInDepart(Employee[] employee, int depart) {
        double result = startSalary(employee, depart);
        for (int i = 0; i <= employee.length-1; i++) {
            if ( depart == employee[i].getDepart() &&  result < employee[i].getSalary() ) {
                result = employee[i].getSalary();
            }
        }
        return result;
    }

    public static double salaryDepart(Employee[] employee, int depart) {
        double result = 0.0;
        for (Employee e : employee) {
            if (e.getDepart() == depart ) {
                result += e.getSalary();
            }
        }
        return result;
    }

    public static double avgSalaryDepart(Employee[] employee, int depart) {
        double result = 0.0;
        int countEmployee = 0;
        for (Employee e : employee) {
            if (e.getDepart() == depart ) {
                result += e.getSalary();
                countEmployee++;
            }
        }
        return result/countEmployee;
    }

    public static void incSalaryDepart(Employee[] employee, int depart, double increase) {
        for (int i = 0; i <= employee.length - 1; i++) {
            if (employee[i].getDepart() == depart ){
              employee[i].setSalary(employee[i].getSalary() * (1+increase));
            }
        }
    }

    public static void showEmployeeDepart(Employee[] employee, int depart) {
        for (Employee e: employee) {
            if (e.getDepart() == depart) {
                System.out.println(e.getId() +", "+ e.getFoi() +", "+ e.getSalary() ) ;
            }
        }
    }

    private static void showEmployeeDepartMinSalary(Employee[] employee, double salary) {
        for (Employee e: employee) {
            if (e.getSalary() < salary) {
                System.out.println(e.getId() +", "+ e.getFoi() +", "+ e.getSalary() ) ;
            }
        }
    }

    private static void showEmployeeDepartMaxSalary(Employee[] employee, double salary) {
        for (Employee e: employee) {
            if (e.getSalary() >= salary) {
                System.out.println(e.getId() +", "+ e.getFoi() +", "+ e.getSalary() ) ;
            }
        }
    }


// Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).

    public static void main(String[] args) {
        Employee[] employee = new Employee[10];

        employee[0] = new Employee("Иванов Иван Иванович", 1, 1111.32);
        employee[1] = new Employee("Семен Семенович Горбунков",  2, 0.55);
        employee[2] = new Employee("Иванов Иван Васильевич", 3, 12.43);
        employee[3] = new Employee("Сафронов Перт Викторович",  4, 21.43);
        employee[4] = new Employee("Ситников Алексей Макарович",  5, 0.01);
        employee[5] = new Employee("Коржаков Дмитрий Владимирович",  1, 31.56);
        employee[6] = new Employee("Терехова Маргарита Михайловны",  2, 61.67);
        employee[7] = new Employee("Жуков Станислав Петрович",  3, 441.17);
        employee[8] = new Employee("Юдина Елена Дмитриевна",  4, 15.10);
        employee[9] = new Employee("Судаков Василий Андреевич",  5, 0.11);

// Base
        showInfoEmployee(employee);
        System.out.println("Сумму затрат на зарплаты в месяц: " + getAmountsMonth(employee) );
        showMinSalaryEmployee(employee);
        showMaxSalaryEmployee(employee);
        System.out.println("Среднее значение зарплат: " + avgSalary(employee));
        showFioForAll(employee);
// Middle
        increaseSalaryForAll(.1, employee);
        System.out.println("Увеличение з/п всем Сотрудникам на 10%: ");
        showInfoEmployee(employee);

//        2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
//        1. Сотрудника с минимальной зарплатой.
        System.out.println("Мин. з.п. сотрудника в отделе № " +employee[3].getDepart() + " равна: "  + minSalaryInDepart(employee, employee[3].getDepart()));
//        2. Сотрудника с максимальной зарплатой.
        System.out.println("Макс. з.п. сотрудника в отделе № " +employee[3].getDepart() + " равна: "  + maxSalaryInDepart(employee, employee[3].getDepart()));

//        3. Сумму затрат на зарплату по отделу.
        System.out.println("Сумму затрат на зарплату по отделу № " +employee[3].getDepart() + " равна: "  + salaryDepart(employee, employee[3].getDepart()));

//        4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        System.out.println("Среднюю зарплату по отделу № " +employee[3].getDepart() + " равна: "  + avgSalaryDepart(employee, employee[3].getDepart()));

//        5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        double increase = 0.25;
        System.out.println("Проиндексирована зарплата всех сотрудников отдела № " +employee[3].getDepart() +  " на процент " + increase * 100  + " = ");
        incSalaryDepart(employee, employee[3].getDepart(), increase);
        showInfoEmployee(employee);

//        6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
        System.out.println("Сотрудники отдела № " + employee[3].getDepart()+ ": ");
        showEmployeeDepart(employee, employee[3].getDepart());

//        Получить в качестве параметра число и найти:
//        Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        double value = 20.5;
        System.out.println("Всех сотрудников с зарплатой < " + value);
        showEmployeeDepartMinSalary(employee, value);

//        Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
        System.out.println("Всех сотрудников с зарплатой >=  " + value);
        showEmployeeDepartMaxSalary(employee, value);


// Hard, // in process

    }

}
