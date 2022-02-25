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

    private static void showFioForAll(Employee[] employee) {
        for (Employee e: employee) {
            System.out.println("Ф.И.О. сотрудника " + e.getId() + ": " + e.getFoi());
        }
    }


    public static void main(String[] args) {
        Employee[] employee = new Employee[10];

        employee[0] = new Employee("Иванов Иван Иванович", 1, 1111.32);
        employee[1] = new Employee("Семен Семенович Горбунков",  2, 0.05);
        employee[2] = new Employee("Иванов Иван Васильевич", 3, 12.43);
        employee[3] = new Employee("Сафронов Перт Викторович",  4, 21.43);
        employee[4] = new Employee("Ситников Алексей Макарович",  5, 0.01);
        employee[5] = new Employee("Коржаков Дмитрий Владимирович",  1, 31.56);
        employee[6] = new Employee("Терехова Маргарита Михайловны",  2, 61.67);
        employee[7] = new Employee("Жуков Станислав Петрович",  3, 441.17);
        employee[8] = new Employee("Юдина Елена Дмитриевна",  4, 0.10);
        employee[9] = new Employee("Судаков Василий Андреевич",  5, 0.11);
//        System.out.println(Employee.count);

        showInfoEmployee(employee);
        System.out.println("Сумму затрат на зарплаты в месяц: " + getAmountsMonth(employee) );
        showMinSalaryEmployee(employee);
        showMaxSalaryEmployee(employee);
        System.out.println("Среднее значение зарплат: " + avgSalary(employee));
        showFioForAll(employee);

    }
}
