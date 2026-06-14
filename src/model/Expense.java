package model;
import java.time.*;
public class Expense{

    private String expenseName;
    private double plannedAmount;
    private double actualAmount;
   private boolean purchased;
    private LocalDate purchasingDate;
    public enum Category{

    FOOD,
    TRANSPORT,
    ENTERTAINMENT,
    EDUCATION,
    OTHER
};
private Category category;
    
    //CONSTRUCTOR
    public Expense(String expenseName, Category category, double plannedAmount){
        this.expenseName= expenseName;
        this.category= category;
        this.plannedAmount= plannedAmount;

    }

    //GETTERS
    public String getExpenseName(){
        return expenseName;

    }

    public Category getCategory(){
        return category;
    }
    
    public double getPlannedAmount(){
        return plannedAmount;
    }

    public double getActualAmount(){
        return actualAmount;
    }
    
    public boolean getPurchased(){
        return purchased;
    }

    public LocalDate getPurchasingDate(){
        return purchasingDate;
    }
    //SETTERS
    public void setPurchased(boolean purchased){
        this.purchased= purchased;
        
    }
    
    public void setPurchasingDate(LocalDate purchasingDate){
        this.purchasingDate= purchasingDate;
    
    }




}