import Salary.model.Salary;
import Salary.model.martialStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Salary salary = new Salary();

        Scanner scan = new Scanner(System.in);
        System.out.print("Martial Status: \n[1] -- Single\n[2] -- Married\n");
        int ms = scan.nextInt();
        System.out.print("Number of dependents: ");
        int dep = scan.nextInt();
        System.out.print("Base Salary: ");
        double bs = scan.nextDouble();
        System.out.print("Food allowance: ");
        double fa = scan.nextDouble();
        System.out.print("Food allowance payed in CARD?\n[1] -- yes\n[2] -- no\n");
        int card = scan.nextInt();
        boolean cardAnswer;
        cardAnswer = card == 1;
        System.out.print("Allowances: ");
        double al = scan.nextDouble();
        System.out.print("Monthly working days: ");
        int wd = scan.nextInt();
        Double tax;
        if (ms == 1) {
            tax = salary.calculateWithholdingTax(martialStatus.SINGLE, dep, bs);

        }else {
            tax = salary.calculateWithholdingTax(martialStatus.MARRIED, dep, bs);
        }

        Double GrossSalary = salary.calculateGrossSalary(bs,fa,cardAnswer, al, wd);

        System.out.println("\n");
        System.out.println("tax: " + tax + "%");

        System.out.format("Gross salary %.2f", GrossSalary);
        double NetSalary = GrossSalary - ((tax * 0.01) * GrossSalary);
        System.out.format("\nNet salary: %.2f", NetSalary);

    }
}