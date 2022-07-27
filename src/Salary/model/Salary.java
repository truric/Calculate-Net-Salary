package Salary.model;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salary {

    public static double MINIMUM_LEGAL_FOOD_ALLOWANCE = 4.77;
    public static double MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD = 7.63;

    public Salary() {
    }

    // receives Enum martialStatus input and outputs integer number of sheet, default = 0 = SINGLE
    public int getMartialStatusEnumInput(martialStatus martialStatus) {
        int x = 0;
        switch(martialStatus){
            case SINGLE:
                x = 0;
                break;
            case MARRIED_ONE_IS_WORKING:
                x = 1;
                break;
            case MARRIED:
                x = 2;
                break;
            case SINGLE_WITH_DEFICIENCY:
                x = 3;
                break;
            case MARRIED_ONE_IS_WORKING_WITH_DEFICIENCY:
                x = 4;
                break;
            case MARRIED_BOTH_WITH_DEFICIENCY:
                x = 5;
                break;
        }
        return x;
    }

    public int martialStatusMenu() {
        Scanner scan = new Scanner(System.in);
        int ms = 0;
        boolean valid;
        do {
            valid = true;
            try {
                System.out.print("Martial Status: " +
                        "\n[0] -- Single" +
                        "\n[1] -- Married One is Working" +
                        "\n[2] -- Married" +
                        "\n[3] -- Single and has Deficiency" +
                        "\n[4] -- Married One is Working and has Deficiency" +
                        "\n[5] -- Married both have Deficiency\n--> "
                );
            ms = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (ms < 0 || ms > 5 || !valid);
        return ms;
    }

    public int dependantsMenu() {
        Scanner scan = new Scanner(System.in);
        int dep = 0;
        boolean valid;
        do {
            valid = true;
            try {
                System.out.print("Number of dependents (0 to 5 range): ");
                dep = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }

        } while (dep < 0 || !valid || dep > 5);
        return dep;
    }

    public double baseSalaryMenu() {
        Scanner scan = new Scanner(System.in);
        double bs = 0;
        boolean valid;
        do {
            valid = true;
            try {
                System.out.print("Base Salary: ");
                bs = Double.parseDouble(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (bs <= 0 || !valid);
        return bs;
    }

    public double foodAllowanceMenu() {
        Scanner scan = new Scanner(System.in);
        double fa = 0;
        boolean valid;
        do {
            valid = true;
            try {
//                System.out.print("Food allowance (insert min and max range here): \n");
                System.out.print("Food allowance: ");
                fa = Double.parseDouble(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (fa <= 0 || !valid);
        return fa;
    }

    public boolean foodAllowanceCardMenu() {
        Scanner scan = new Scanner(System.in);
        int card = 0;
        boolean valid, answer = true;
        do {
            valid = true;
            try {
                System.out.print("Food allowance payed in CARD?\n[1] -- yes\n[2] -- no\n--> ");
                card = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (card < 1 || card > 2 || !valid);
        if (card == 1)
            return answer = true;
        else
            return answer = false;
    }

    public double allowancesMenu() {
        Scanner scan = new Scanner(System.in);
        double al = 0;
        boolean valid;
        do {
            valid = true;
            try {
//                System.out.print("Allowances: (add range if exists, cant it be 0?): \n");
                System.out.print("Allowances: ");
                al = Double.parseDouble(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (al < 0 || !valid);
        return al;
    }

    public int monthlyWorkingDaysMenu() {
        Scanner scan = new Scanner(System.in);
        int mwd = 0;
        boolean valid;
        do {
            valid = true;
            try {
//                System.out.print("Monthly working days: (range maybe max 22?)\n");
                System.out.print("Monthly working days: ");
                mwd = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (mwd <= 0 || !valid);
        return mwd;
    }

    public Double calculateWithholdingTax(martialStatus martialStatus, Integer dependants, Double baseSalary) throws IOException {
        String filePath = System.getProperty("user.dir");
        // if jar file is created, artifact will look into jar file path folder, change .xlsx file path here
        XSSFWorkbook workbook = new XSSFWorkbook(filePath + "\\docs\\test.xlsx");
        int sheetNumber = getMartialStatusEnumInput(martialStatus);
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        int rowsTotal = sheet.getPhysicalNumberOfRows();
        List<Double> taxData = new ArrayList<>();
        List<Double> baseSalaryData = new ArrayList<>();
        int i, j;

        for (i = 2; i < rowsTotal; i++) { // rowsTotal = 38
            baseSalaryData.add(sheet.getRow(i).getCell(1).getNumericCellValue());
            for (j = 2; j < 8; j++) { //0.0% i=2 j=2
                taxData.add(sheet.getRow(i).getCell(j).getNumericCellValue());
            }
        }

        for (i = 0; i < baseSalaryData.size()-1; i++) {
            if (baseSalary <= baseSalaryData.get(i)) {
//                every i row has 6 possible values
//                this way there's no need for nested loops
                return taxData.get(i*6+dependants);
            }
            else if (baseSalary >= baseSalaryData.get(baseSalaryData.size()-1)) {
                return taxData.get((baseSalaryData.size()-1)*6+dependants);
            }
        }
        return 0.0;
    }

    public Double calculateGrossSalary(Double baseSalary, Double foodAllowance, Boolean foodAllowanceAsCard, Double allowances, Integer monthlyWorkingDays) {
        double total = 0;
        if (foodAllowance < MINIMUM_LEGAL_FOOD_ALLOWANCE) {
            total = baseSalary + (foodAllowance * monthlyWorkingDays) + allowances;
        }else if (foodAllowanceAsCard && foodAllowance > MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) {
            total = baseSalary + (foodAllowance - MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) * monthlyWorkingDays + allowances;
        }else if (foodAllowanceAsCard && foodAllowance < MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD && foodAllowance > MINIMUM_LEGAL_FOOD_ALLOWANCE) {
            total = baseSalary + (foodAllowance * monthlyWorkingDays) + allowances;
        }else if (!foodAllowanceAsCard && foodAllowance > MINIMUM_LEGAL_FOOD_ALLOWANCE) {
            total = baseSalary + (foodAllowance - MINIMUM_LEGAL_FOOD_ALLOWANCE) * monthlyWorkingDays + allowances;
        }
        return total;
    }
}
