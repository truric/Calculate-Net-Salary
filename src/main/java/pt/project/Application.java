package pt.project;

import pt.project.salary.MartialStatus;
import pt.project.salary.Salary;

import java.util.logging.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int continueMenu = 1;
        Scanner scan = new Scanner(System.in);
        Logger log = java.util.logging.Logger.getLogger(Salary.class.getName());

        do {
            Salary salary = new Salary();
            int martialStatus = salary.martialStatusMenu();
            int dependants = salary.dependantsMenu();
            double baseSalary = salary.baseSalaryMenu();
            double foodAllowance = salary.foodAllowanceMenu();
            boolean card = salary.foodAllowanceCardMenu();
            double allowances = salary.allowancesMenu();
            int monthlyWorkingDays = salary.monthlyWorkingDaysMenu();
            double tax = salary.calculateWithholdingTax(getMartialStatusIntInput(martialStatus), dependants, baseSalary);
            double grossSalary = salary.calculateGrossSalary(baseSalary, foodAllowance, card, allowances, monthlyWorkingDays);
            String netSalary = calculateNetSalary(foodAllowance, baseSalary, grossSalary, tax, card, monthlyWorkingDays);

            log.info(netSalary);
            log.info(LOG_CONTINUE_MENU);

            continueMenu = Integer.parseInt(scan.next());

        } while (continueMenu != 2);
    }

    private static String calculateNetSalary(double foodAllowance, double baseSalary, double grossSalary, double tax,
                                             boolean card, int monthlyWorkingDays) {
        double netSalary;
        if (card && foodAllowance <= Salary.MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) {
            netSalary = grossSalary - (baseSalary * tax) - (baseSalary * 0.11);
        } else {
            netSalary = grossSalary - (grossSalary * tax) - (grossSalary * 0.11);
        }

        if (!card && foodAllowance > Salary.MINIMUM_LEGAL_FOOD_ALLOWANCE) {
            netSalary += Salary.MINIMUM_LEGAL_FOOD_ALLOWANCE * monthlyWorkingDays;
        } else if (card && foodAllowance > Salary.MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) {
            netSalary += Salary.MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD * monthlyWorkingDays;
        }

        return String.format("%nGross salary %.2f €%nNet salary: %.2f €%nIRS tax: %.2f %%", grossSalary,
                netSalary, tax * 100);
    }

    // receives input integer and outputs Enum martialStatus, so it navigates to the correct sheet index
    public static MartialStatus getMartialStatusIntInput(int x) {
        return switch (x) {
            case 1 -> MartialStatus.MARRIED_ONE_IS_WORKING;
            case 2 -> MartialStatus.MARRIED;
            case 3 -> MartialStatus.SINGLE_WITH_DEFICIENCY;
            case 4 -> MartialStatus.MARRIED_ONE_IS_WORKING_WITH_DEFICIENCY;
            case 5 -> MartialStatus.MARRIED_BOTH_WITH_DEFICIENCY;
            // default = 0 = SINGLE
            default -> MartialStatus.SINGLE;
        };
    }

    public static final String LOG_CONTINUE_MENU = """
            Continue?\s
            [1] -- yes
            [2] -- no
            -->\s""";
}