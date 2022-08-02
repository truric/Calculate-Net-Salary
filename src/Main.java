import Salary.model.Salary;
import Salary.model.martialStatus;

//disable DEBUG messages
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int continueMenu = 1;
        Scanner scan = new Scanner(System.in);

        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.ERROR);

        do {

            Salary salary = new Salary();

            int ms = salary.martialStatusMenu();
            int dep = salary.dependantsMenu();
            double bs = salary.baseSalaryMenu();
            double fa = salary.foodAllowanceMenu();
            boolean card = salary.foodAllowanceCardMenu();
            double al = salary.allowancesMenu();
            int mwd = salary.monthlyWorkingDaysMenu();

            double tax = salary.calculateWithholdingTax(getMartialStatusIntInput(ms), dep, bs);
            double GrossSalary = salary.calculateGrossSalary(bs, fa, card, al, mwd);
            double NetSalary = GrossSalary - (GrossSalary * tax) - (GrossSalary * 0.11);

            if (!card && fa > MINIMUM_LEGAL_FOOD_ALLOWANCE) {
                NetSalary += MINIMUM_LEGAL_FOOD_ALLOWANCE * mwd;
            } else if (card && fa > MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) {
                NetSalary += MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD * mwd;
            }

            System.out.format("\nIRS tax: %.2f\uFF05", tax * 100);
            System.out.format("\nGross salary %.2f \u20AC", GrossSalary);
            System.out.format("\nNet salary: %.2f \u20AC", NetSalary);

            System.out.print("\n\nContinue?\n[1] -- yes\n[2] -- no\n--> ");
            continueMenu = Integer.parseInt(scan.next());

        }while (continueMenu != 2);
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
    public static double MINIMUM_LEGAL_FOOD_ALLOWANCE = 4.77;
    public static double MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD = 7.63;
}