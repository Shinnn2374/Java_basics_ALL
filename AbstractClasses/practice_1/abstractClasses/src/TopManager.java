public class TopManager  implements Employee{
    public static int FIX_SALARY = 1500000;
    Company company = new Company();
    public int getMonthSalary() {
        return FIX_SALARY + company.getIncome() > 10000000 ? (int) (FIX_SALARY * 1.5) : 0;
    }
}
