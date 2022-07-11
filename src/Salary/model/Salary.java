package Salary.model;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salary {
    private Enum martialStatus;
    private Enum residence;
    private Integer dependants;
    private Double baseSalary;
    private Double foodAllowance;
    private Boolean foodAllowanceAsCard;
    private Double allowances;

    public Salary() {
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    private Integer monthlyWorkingDays;

    public Salary(Enum martialStatus, Enum residence,
                  Integer dependants, Double baseSalary,
                  Double foodAllowance, Boolean foodAllowanceAsCard,
                  Double allowances, Integer monthlyWorkingDays) {
        this.martialStatus = martialStatus;
        this.residence = residence;
        this.dependants = dependants;
        this.baseSalary = baseSalary;
        this.foodAllowance = foodAllowance;
        this.foodAllowanceAsCard = foodAllowanceAsCard;
        this.allowances = allowances;
        this.monthlyWorkingDays = monthlyWorkingDays;
    }

    public Enum getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(Enum martialStatus) {
        this.martialStatus = martialStatus;
    }

    public Enum getResidence() {
        return residence;
    }

    public void setResidence(Enum residence) {
        this.residence = residence;
    }

    public Integer getDependants() {
        return dependants;
    }

    public void setDependants(Integer dependants) {
        this.dependants = dependants;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void getBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getFoodAllowance() {
        return foodAllowance;
    }

    public void setFoodAllowance(Double foodAllowance) {
        this.foodAllowance = foodAllowance;
    }

    public Boolean getFoodAllowanceAsCard() {
        return foodAllowanceAsCard;
    }

    public void setFoodAllowanceAsCard(Boolean foodAllowanceAsCard) {
        this.foodAllowanceAsCard = foodAllowanceAsCard;
    }

    public Double getAllowances() {
        return allowances;
    }

    public void setAllowances(Double allowances) {
        this.allowances = allowances;
    }

    public Integer getMonthlyWorkingDays() {
        return monthlyWorkingDays;
    }

    public void setMonthlyWorkingDays(Integer monthlyWorkingDays) {
        this.monthlyWorkingDays = monthlyWorkingDays;
    }

    public void martialStatus(martialStatus martialStatus) {

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
                System.out.print("Food allowance (insert min and max range here): \n");
                fa = Double.parseDouble(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (fa <= 0 || !valid);
        return fa;
    }

    public int foodAllowanceCardMenu() {
        Scanner scan = new Scanner(System.in);
        int card = 0;
        boolean valid;
        do {
            valid = true;
            try {
                System.out.print("Food allowance payed in CARD?\n[1] -- yes\n[2] -- no\n");
                card = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Invalid value " + e.getMessage().toLowerCase());
                valid = false;
            }
        } while (card < 1 || card > 2 || !valid);
        return card;
    }

    public double allowancesMenu() {
        Scanner scan = new Scanner(System.in);
        double al = 0;
        boolean valid;
        do {
            valid = true;
            try {
                System.out.print("Allowances: (add range if exists, cant it be 0?): \n");
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
                System.out.print("Monthly working days: (range maybe max 22?)\n");
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
//        XSSFWorkbook workbook = new XSSFWorkbook(filePath + "\\docs\\test.xlsx");
        // artifact will look into jar file path folder
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
                return taxData.get(i*6+dependants);
            }
            else if (baseSalary >= baseSalaryData.get(baseSalaryData.size()-1)) {
                return taxData.get((baseSalaryData.size()-1)*6+dependants);
            }
        }
        return 0.0;
    }

    public Double calculateGrossSalary(Double baseSalary, Double foodAllowance, Boolean foodAllowanceAsCard, Double allowances, Integer monthlyWorkingDays) {
        double total;
        if (foodAllowance < 4.77 || foodAllowanceAsCard) {
            total = baseSalary + (foodAllowance * monthlyWorkingDays);
            total = total - (baseSalary * 0.11) + allowances;
        }else{
            total = baseSalary - (foodAllowance * monthlyWorkingDays) - (baseSalary * 0.11) + allowances;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "martialStatus=" + martialStatus +
                ", residence=" + residence +
                ", dependants=" + dependants +
                ", baseSalary=" + baseSalary +
                ", foodAllowance=" + foodAllowance +
                ", foodAllowanceAsCard=" + foodAllowanceAsCard +
                ", allowances=" + allowances +
                ", monthlyWorkingDays=" + monthlyWorkingDays +
                '}';
    }
}
