package salary.model;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Salary {
    private static final Logger log = Logger.getLogger(Salary.class.getName());
    public static final double MINIMUM_LEGAL_FOOD_ALLOWANCE = 4.77;
    public static final double MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD = 7.63;
    public static final String INVALID_VALUE = "Invalid value ";

    public Salary() {
    }

    // receives Enum martialStatus input and outputs integer number of sheet, default = 0 = SINGLE
    public int getMartialStatusEnumInput(MartialStatus martialStatus) {
        return switch (martialStatus) {
            case SINGLE -> 0;
            case MARRIED_ONE_IS_WORKING -> 1;
            case MARRIED -> 2;
            case SINGLE_WITH_DEFICIENCY -> 3;
            case MARRIED_ONE_IS_WORKING_WITH_DEFICIENCY -> 4;
            case MARRIED_BOTH_WITH_DEFICIENCY -> 5;
        };
    }

    public int martialStatusMenu() {
        Scanner scan = new Scanner(System.in);
        int ms = 0;
        boolean valid;
        do {
            valid = true;
            try {
                log.info("""
                        Martial Status:\s
                        [0] -- Single
                        [1] -- Married One is Working
                        [2] -- Married
                        [3] -- Single and has Deficiency
                        [4] -- Married One is Working and has Deficiency
                        [5] -- Married both have Deficiency
                        -->\s"""
                );
                ms = Integer.parseInt(scan.next());
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
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
                log.info("Number of dependents (0 to 5 range): ");
                dep = Integer.parseInt(scan.next());
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
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
                log.info("Base Salary: ");
                bs = Double.parseDouble(scan.next());
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (bs <= 0 || !valid);
        return bs;
    }

    public double foodAllowanceMenu() {
        Scanner scan = new Scanner(System.in);
        double foodAllowance = 0;
        boolean valid;
        do {
            valid = true;
            try {
                log.info("Food allowance: ");
                foodAllowance = Double.parseDouble(scan.next());
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (foodAllowance <= 0 || !valid || foodAllowance >= 10);
        return foodAllowance;
    }

    public boolean foodAllowanceCardMenu() {
        Scanner scan = new Scanner(System.in);
        int card = 0;
        boolean valid, answer = true;
        do {
            valid = true;
            try {
                log.info("Food allowance payed in CARD?\n[1] -- yes\n[2] -- no\n--> ");
                card = Integer.parseInt(scan.next());
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
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
        double allowances = 0;
        boolean valid;
        do {
            valid = true;
            try {
                log.info("Allowances (0 for no value): ");
                allowances = Double.parseDouble(scan.next());
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (allowances < 0 || !valid);
        return allowances;
    }

    public int monthlyWorkingDaysMenu() {
        Scanner scan = new Scanner(System.in);
        int monthlyWorkingDays = 0;
        boolean valid;
        do {
            valid = true;
            try {
                do {
                    log.info("Monthly working days: ");
                    monthlyWorkingDays = Integer.parseInt(scan.next());
                } while (monthlyWorkingDays < 0 || monthlyWorkingDays > 23);
            } catch (Exception e) {
                log.severe(INVALID_VALUE + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (monthlyWorkingDays <= 0 || !valid);
        return monthlyWorkingDays;
    }

    public double calculateWithholdingTax(MartialStatus martialStatus, int dependants, double baseSalary) {
        String filePath = System.getProperty("user.dir");
        // if jar file is created, artifact will look into jar file path folder, change .xlsx file path here
        try (XSSFWorkbook workbook = new XSSFWorkbook(filePath + "\\docs\\test.xlsx")) {

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
        } catch (IOException e) {
            log.severe("Could not load xlsx file");
        }
        return 0.0;
    }

    public double calculateGrossSalary(double baseSalary, double foodAllowance, boolean foodAllowanceAsCard, double allowances, int monthlyWorkingDays) {
        double total;
        if (foodAllowance <= MINIMUM_LEGAL_FOOD_ALLOWANCE) {
            total = baseSalary + (foodAllowance * monthlyWorkingDays) + allowances;
        } else if (foodAllowanceAsCard && foodAllowance > MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) {
            total = baseSalary + (foodAllowance - MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) * monthlyWorkingDays + allowances;
        } else if (foodAllowanceAsCard && foodAllowance <= MAXIMUM_EXEMPTED_FOOD_ALLOWANCE_PAID_IN_CARD) {
            total = baseSalary + (foodAllowance * monthlyWorkingDays) + allowances;
//        last condition -> (!foodAllowanceAsCard && foodAllowance > MINIMUM_LEGAL_FOOD_ALLOWANCE)
        } else {
            total = baseSalary + (foodAllowance - MINIMUM_LEGAL_FOOD_ALLOWANCE) * monthlyWorkingDays + allowances;
        }
        return total;
    }
}