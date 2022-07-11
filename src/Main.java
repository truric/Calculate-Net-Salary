import Salary.model.Salary;
import Salary.model.martialStatus;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Salary salary = new Salary();

        int ms = salary.martialStatusMenu();
        int dep = salary.dependantsMenu();
        double bs = salary.baseSalaryMenu();
        double fa = salary.foodAllowanceMenu();
        int card = salary.foodAllowanceCardMenu();

        boolean cardAnswer;
        // card = 1 ? cardAnswer = true : cardAnswer = false
        cardAnswer = card == 1;

        double al = salary.allowancesMenu();
        int mwd = salary.monthlyWorkingDaysMenu();

        Double tax = salary.calculateWithholdingTax(getMartialStatusIntInput(ms), dep, bs);
        Double GrossSalary = salary.calculateGrossSalary(bs,fa,cardAnswer, al, mwd);
        Double NetSalary = GrossSalary - ((tax * 0.01) * GrossSalary);

        System.out.println("tax: " + tax + "%");
        System.out.format("Gross salary %.2f", GrossSalary);
        System.out.format("\nNet salary: %.2f", NetSalary);

    }

    // receives input integer and outputs Enum martialStatus, so it navigates to the correct sheet index
    public static martialStatus getMartialStatusIntInput(int x) {
        // default = 0 = SINGLE
        martialStatus msResult = martialStatus.SINGLE;
        switch(x){
            case 1:
                msResult = martialStatus.MARRIED_ONE_IS_WORKING;
                break;
            case 2:
                msResult = martialStatus.MARRIED;
                break;
            case 3:
                msResult = martialStatus.SINGLE_WITH_DEFICIENCY;
                break;
            case 4:
                msResult = martialStatus.MARRIED_ONE_IS_WORKING_WITH_DEFICIENCY;
                break;
            case 5:
                msResult = martialStatus.MARRIED_BOTH_WITH_DEFICIENCY;
                break;
        }
        return msResult;
    }
}