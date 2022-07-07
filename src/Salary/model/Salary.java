package Salary.model;

import static Salary.model.martialStatus.SINGLE;

public class Salary {
    private Enum martialStatus;
    private Enum residence;
//    private Integer spouses;
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

    public Salary(Enum martialStatus, Enum residence, Integer dependants, Double baseSalary, Double foodAllowance, Boolean foodAllowanceAsCard, Double allowances, Integer monthlyWorkingDays) {
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

    public Double calculateWithholdingTax(martialStatus martialStatus, Integer dependants, Double baseSalary) {
        switch(martialStatus){
            case SINGLE:
                if (baseSalary <= 710.00) {
                    return 0.0;
                } else if (baseSalary <= 720.00 && dependants == 0) {
                    return 1.8;
                } else if (baseSalary <= 720.00 && dependants == 1) {
                    return 0.2;
                } else if (baseSalary <= 740.00 && dependants == 0) {
                    return 4.5;
                } else if (baseSalary <= 740.00 && dependants == 1) {
                    return 0.6;
                } else if (baseSalary <= 754.00 && dependants == 0) {
                    return 6.3;
                } else if (baseSalary <= 754.00 && dependants == 1) {
                    return 0.8;
                } else if (baseSalary <= 822.00 && dependants == 0) {
                    return 7.9;
                } else if (baseSalary <= 822.00 && dependants == 1) {
                    return 4.5;
                } else if (baseSalary <= 822.00 && dependants == 2) {
                    return 1.0;
                } else if (baseSalary <= 931.00 && dependants == 0) {
                    return 10.1;
                } else if (baseSalary <= 931.00 && dependants == 1) {
                    return 6.7;
                } else if (baseSalary <= 931.00 && dependants == 2) {
                    return 3.5;
                } else if (baseSalary <= 1015.00 && dependants == 0) {
                    return 11.3;
                } else if (baseSalary <= 1015.00 && dependants == 1) {
                    return 7.9;
                } else if (baseSalary <= 1015.00 && dependants == 2) {
                    return 5.7;
                } else if (baseSalary <= 1015.00 && dependants == 3) {
                    return 1.4;
                } else if (baseSalary <= 1075.00 && dependants == 0) {
                    return 12.1;
                } else if (baseSalary <= 1075.00 && dependants == 1) {
                    return 8.8;
                } else if (baseSalary <= 1075.00 && dependants == 2) {
                    return 6.5;
                } else if (baseSalary <= 1075.00 && dependants == 3) {
                    return 3.3;
                } else if (baseSalary <= 1154.00 && dependants == 0) {
                    return 13.1;
                } else if (baseSalary <= 1154.00 && dependants == 1) {
                    return 10.7;
                } else if (baseSalary <= 1154.00 && dependants == 2) {
                    return 8.3;
                } else if (baseSalary <= 1154.00 && dependants == 3) {
                    return 5.1;
                } else if (baseSalary <= 1154.00 && dependants == 4) {
                    return 2.7;
                } else if (baseSalary <= 1154.00 && dependants >= 5) {
                    return 0.2;
                } else if (baseSalary <= 1237.00 && dependants == 0) {
                    return 14.1;
                } else if (baseSalary <= 1237.00 && dependants == 1) {
                    return 11.8;
                } else if (baseSalary <= 1237.00 && dependants == 2) {
                    return 9.3;
                } else if (baseSalary <= 1237.00 && dependants == 3) {
                    return 6.1;
                } else if (baseSalary <= 1237.00 && dependants == 4) {
                    return 3.6;
                } else if (baseSalary <= 1237.00 && dependants >= 5) {
                    return 1.2;
                } else if (baseSalary <= 1333.00 && dependants == 0) {
                    return 15.2;
                } else if (baseSalary <= 1333.00 && dependants == 1) {
                    return 12.8;
                } else if (baseSalary <= 1333.00 && dependants == 2) {
                    return 10.5;
                } else if (baseSalary <= 1333.00 && dependants == 3) {
                    return 7.0;
                } else if (baseSalary <= 1333.00 && dependants == 4) {
                    return 4.6;
                } else if (baseSalary <= 1333.00 && dependants >= 5) {
                    return 2.2;
                } else if (baseSalary <= 1437.00 && dependants == 0) {
                    return 16.2;
                } else if (baseSalary <= 1437.00 && dependants == 1) {
                    return 13.8;
                } else if (baseSalary <= 1437.00 && dependants == 2) {
                    return 11.4;
                } else if (baseSalary <= 1437.00 && dependants == 3) {
                    return 8.0;
                } else if (baseSalary <= 1437.00 && dependants == 4) {
                    return 6.5;
                } else if (baseSalary <= 1437.00 && dependants >= 5) {
                    return 4.0;
                } else if (baseSalary <= 1577.00 && dependants == 0) {
                    return 17.2;
                } else if (baseSalary <= 1577.00 && dependants == 1) {
                    return 14.8;
                } else if (baseSalary <= 1577.00 && dependants == 2) {
                    return 12.3;
                } else if (baseSalary <= 1577.00 && dependants == 3) {
                    return 10.0;
                } else if (baseSalary <= 1577.00 && dependants == 4) {
                    return 7.5;
                } else if (baseSalary <= 1577.00 && dependants >= 5) {
                    return 5.0;
                } else if (baseSalary <= 1727.00 && dependants == 0) {
                    return 18.6;
                } else if (baseSalary <= 1727.00 && dependants == 1) {
                    return 16.3;
                } else if (baseSalary <= 1727.00 && dependants == 2) {
                    return 14.8;
                } else if (baseSalary <= 1727.00 && dependants == 3) {
                    return 11.4;
                } else if (baseSalary <= 1727.00 && dependants == 4) {
                    return 8.9;
                } else if (baseSalary <= 1727.00 && dependants >= 5) {
                    return 6.5;
                } else if (baseSalary <= 1887.00 && dependants == 0) {
                    return 19.9;
                } else if (baseSalary <= 1887.00 && dependants == 1) {
                    return 18.2;
                } else if (baseSalary <= 1887.00 && dependants == 2) {
                    return 17.3;
                } else if (baseSalary <= 1887.00 && dependants == 3) {
                    return 14.5;
                } else if (baseSalary <= 1887.00 && dependants == 4) {
                    return 12.5;
                } else if (baseSalary <= 1887.00 && dependants >= 5) {
                    return 11.7;
                } else if (baseSalary <= 1995.00 && dependants == 0) {
                    return 20.9;
                } else if (baseSalary <= 1995.00 && dependants == 1) {
                    return 19.3;
                } else if (baseSalary <= 1995.00 && dependants == 2) {
                    return 18.2;
                } else if (baseSalary <= 1995.00 && dependants == 3) {
                    return 15.5;
                } else if (baseSalary <= 1995.00 && dependants == 4) {
                    return 14.5;
                } else if (baseSalary <= 1995.00 && dependants >= 5) {
                    return 12.5;
                } else if (baseSalary <= 2109.00 && dependants == 0) {
                    return 21.9;
                } else if (baseSalary <= 2109.00 && dependants == 1) {
                    return 20.2;
                } else if (baseSalary <= 2109.00 && dependants == 2) {
                    return 19.2;
                } else if (baseSalary <= 2109.00 && dependants == 3) {
                    return 16.4;
                } else if (baseSalary <= 2109.00 && dependants == 4) {
                    return 15.5;
                } else if (baseSalary <= 2109.00 && dependants >= 5) {
                    return 13.5;
                } else if (baseSalary <= 2238.00 && dependants == 0) {
                    return 22.8;
                } else if (baseSalary <= 2238.00 && dependants == 1) {
                    return 21.3;
                } else if (baseSalary <= 2238.00 && dependants == 2) {
                    return 20.3;
                } else if (baseSalary <= 2238.00 && dependants == 3) {
                    return 17.5;
                } else if (baseSalary <= 2238.00 && dependants == 4) {
                    return 16.5;
                } else if (baseSalary <= 2238.00 && dependants >= 5) {
                    return 14.5;
                } else if (baseSalary <= 2389.00 && dependants == 0) {
                    return 23.8;
                } else if (baseSalary <= 2389.00 && dependants == 1) {
                    return 22.2;
                } else if (baseSalary <= 2389.00 && dependants == 2) {
                    return 21.3;
                } else if (baseSalary <= 2389.00 && dependants == 3) {
                    return 18.5;
                } else if (baseSalary <= 2389.00 && dependants == 4) {
                    return 17.6;
                } else if (baseSalary <= 2389.00 && dependants >= 5) {
                    return 15.5;
                } else if (baseSalary <= 2558.00 && dependants == 0) {
                    return 24.8;
                } else if (baseSalary <= 2558.00 && dependants == 1) {
                    return 24.2;
                } else if (baseSalary <= 2558.00 && dependants == 2) {
                    return 22.2;
                } else if (baseSalary <= 2558.00 && dependants == 3) {
                    return 20.4;
                } else if (baseSalary <= 2558.00 && dependants == 4) {
                    return 18.5;
                } else if (baseSalary <= 2558.00 && dependants >= 5) {
                    return 17.6;
                } else if (baseSalary <= 2792.00 && dependants == 0) {
                    return 25.8;
                } else if (baseSalary <= 2792.00 && dependants == 1) {
                    return 25.1;
                } else if (baseSalary <= 2792.00 && dependants == 2) {
                    return 23.3;
                } else if (baseSalary <= 2792.00 && dependants == 3) {
                    return 21.4;
                } else if (baseSalary <= 2792.00 && dependants == 4) {
                    return 19.4;
                } else if (baseSalary <= 2792.00 && dependants >= 5) {
                    return 18.5;
                } else if (baseSalary <= 3132.00 && dependants == 0) {
                    return 27.0;
                } else if (baseSalary <= 3132.00 && dependants == 1) {
                    return 26.4;
                } else if (baseSalary <= 3132.00 && dependants == 2) {
                    return 24.5;
                } else if (baseSalary <= 3132.00 && dependants == 3) {
                    return 22.5;
                } else if (baseSalary <= 3132.00 && dependants == 4) {
                    return 20.6;
                } else if (baseSalary <= 3132.00 && dependants >= 5) {
                    return 19.6;
                } else if (baseSalary <= 3566.00 && dependants == 0) {
                    return 28.6;
                } else if (baseSalary <= 3566.00 && dependants == 1) {
                    return 28.3;
                } else if (baseSalary <= 3566.00 && dependants == 2) {
                    return 26.8;
                } else if (baseSalary <= 3566.00 && dependants == 3) {
                    return 25.2;
                } else if (baseSalary <= 3566.00 && dependants == 4) {
                    return 24.6;
                } else if (baseSalary <= 3566.00 && dependants >= 5) {
                    return 23.00;
                } else if (baseSalary <= 4156.00 && dependants == 0) {
                    return 29.7;
                } else if (baseSalary <= 4156.00 && dependants == 1) {
                    return 29.5;
                } else if (baseSalary <= 4156.00 && dependants == 2) {
                    return 27.7;
                } else if (baseSalary <= 4156.00 && dependants == 3) {
                    return 26.2;
                } else if (baseSalary <= 4156.00 && dependants == 4) {
                    return 25.6;
                } else if (baseSalary <= 4156.00 && dependants >= 5) {
                    return 25.0;
                } else if (baseSalary <= 4692.00 && dependants == 0) {
                    return 31.4;
                } else if (baseSalary <= 4692.00 && dependants == 1) {
                    return 31.0;
                } else if (baseSalary <= 4692.00 && dependants == 2) {
                    return 29.4;
                } else if (baseSalary <= 4692.00 && dependants == 3) {
                    return 27.6;
                } else if (baseSalary <= 4692.00 && dependants == 4) {
                    return 27.0;
                } else if (baseSalary <= 4692.00 && dependants >= 5) {
                    return 26.5;
                } else if (baseSalary <= 5241.00 && dependants == 0) {
                    return 32.3;
                } else if (baseSalary <= 5241.00 && dependants == 1) {
                    return 31.8;
                } else if (baseSalary <= 5241.00 && dependants == 2) {
                    return 31.3;
                } else if (baseSalary <= 5241.00 && dependants == 3) {
                    return 28.9;
                } else if (baseSalary <= 5241.00 && dependants == 4) {
                    return 28.0;
                } else if (baseSalary <= 5241.00 && dependants >= 5) {
                    return 27.4;
                } else if (baseSalary <= 5933.00 && dependants == 0) {
                    return 33.3;
                } else if (baseSalary <= 5933.00 && dependants == 1) {
                    return 32.8;
                } else if (baseSalary <= 5933.00 && dependants == 2) {
                    return 32.2;
                } else if (baseSalary <= 5933.00 && dependants == 3) {
                    return 29.8;
                } else if (baseSalary <= 5933.00 && dependants == 4) {
                    return 29.2;
                } else if (baseSalary <= 5933.00 && dependants >= 5) {
                    return 28.4;
                } else if (baseSalary <= 6788.00 && dependants == 0) {
                    return 35.3;
                } else if (baseSalary <= 6788.00 && dependants == 1) {
                    return 34.9;
                } else if (baseSalary <= 6788.00 && dependants == 2) {
                    return 34.1;
                } else if (baseSalary <= 6788.00 && dependants == 3) {
                    return 32.2;
                } else if (baseSalary <= 6788.00 && dependants == 4) {
                    return 31.8;
                } else if (baseSalary <= 6788.00 && dependants == 5) {
                    return 31.5;
                } else if (baseSalary <= 8011.00 && dependants == 0) {
                    return 36.3;
                } else if (baseSalary <= 8011.00 && dependants == 1) {
                    return 35.9;
                } else if (baseSalary <= 8011.00 && dependants == 2) {
                    return 35.5;
                } else if (baseSalary <= 8011.00 && dependants == 3) {
                    return 34.2;
                } else if (baseSalary <= 8011.00 && dependants == 4) {
                    return 32.8;
                } else if (baseSalary <= 8011.00 && dependants >= 5) {
                    return 32.4;
                } else if (baseSalary <= 9647.00 && dependants == 0) {
                    return 38.2;
                } else if (baseSalary <= 9647.00 && dependants == 1) {
                    return 37.8;
                } else if (baseSalary <= 9647.00 && dependants == 2) {
                    return 37.4;
                } else if (baseSalary <= 9647.00 && dependants == 3) {
                    return 36.2;
                } else if (baseSalary <= 9647.00 && dependants == 4) {
                    return 35.8;
                } else if (baseSalary <= 9647.00 && dependants >= 5) {
                    return 34.4;
                } else if (baseSalary <= 11384.00 && dependants == 0) {
                    return 39.2;
                } else if (baseSalary <= 11384.00 && dependants == 1) {
                    return 38.8;
                } else if (baseSalary <= 11384.00 && dependants == 2) {
                    return 38.4;
                } else if (baseSalary <= 11384.00 && dependants == 3) {
                    return 37.5;
                } else if (baseSalary <= 11384.00 && dependants == 4) {
                    return 36.7;
                } else if (baseSalary <= 11384.00 && dependants >= 5) {
                    return 35.4;
                } else if (baseSalary <= 19024.00 && dependants == 0) {
                    return 40.2;
                } else if (baseSalary <= 19024.00 && dependants == 1) {
                    return 39.8;
                } else if (baseSalary <= 19024.00 && dependants == 2) {
                    return 39.4;
                } else if (baseSalary <= 19024.00 && dependants == 3) {
                    return 38.5;
                } else if (baseSalary <= 19024.00 && dependants == 4) {
                    return 38.1;
                } else if (baseSalary <= 19024.00 && dependants >= 5) {
                    return 36.4;
                } else if (baseSalary <= 20403.00 && dependants == 0) {
                    return 41.2;
                } else if (baseSalary <= 20403.00 && dependants == 1) {
                    return 40.8;
                } else if (baseSalary <= 20403.00 && dependants == 2) {
                    return 40.4;
                } else if (baseSalary <= 20403.00 && dependants == 3) {
                    return 39.5;
                } else if (baseSalary <= 20403.00 && dependants == 4) {
                    return 39.1;
                } else if (baseSalary <= 20403.00 && dependants >= 5) {
                    return 37.3;
                } else if (baseSalary <= 22954.00 && dependants == 0) {
                    return 41.9;
                } else if (baseSalary <= 22954.00 && dependants == 1) {
                    return 41.7;
                } else if (baseSalary <= 22954.00 && dependants == 2) {
                    return 41.4;
                } else if (baseSalary <= 22954.00 && dependants == 3) {
                    return 40.5;
                } else if (baseSalary <= 22954.00 && dependants == 4) {
                    return 40.1;
                } else if (baseSalary <= 22954.00 && dependants >= 5) {
                    return 38.5;
                } else if (baseSalary <= 25504.00 && dependants == 0) {
                    return 42.9;
                } else if (baseSalary <= 25504.00 && dependants == 1) {
                    return 42.7;
                } else if (baseSalary <= 25504.00 && dependants == 2) {
                    return 42.3;
                } else if (baseSalary <= 25504.00 && dependants == 3) {
                    return 41.4;
                } else if (baseSalary <= 25504.00 && dependants == 4) {
                    return 41.1;
                } else if (baseSalary <= 25504.00 && dependants >= 5) {
                    return 39.7;
                } else if (baseSalary > 25504.00 && dependants == 0) {
                    return 43.8;
                } else if (baseSalary > 25504.00 && dependants == 1) {
                    return 43.6;
                } else if (baseSalary > 25504.00 && dependants == 2) {
                    return 43.3;
                } else if (baseSalary > 25504.00 && dependants == 3) {
                    return 42.4;
                } else if (baseSalary > 25504.00 && dependants == 4) {
                    return 42.0;
                } else if (baseSalary > 25504.00 && dependants >= 5) {
                    return 40.7;
                }
                break;
            case SINGLE_WITH_DEFICIENCY:
                break;
            case MARRIED:
                if (baseSalary <= 931.00 && dependants == 1) {
                    return 7.3;
                }
                if (baseSalary <= 1237.00 && dependants == 1) {
                    return 12.4;
                }

                break;
            case MARRIED_ONE_IS_WORKING:

                break;
            case MARRIED_ONE_IS_WORKING_WITH_DEFICIENCY:

                break;
            case MARRIED_BOTH_WITH_DEFICIENCY:

                break;
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
