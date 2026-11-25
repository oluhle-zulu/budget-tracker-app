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
        if (expenseName == null || expenseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Expense name cannot be empty.");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }

        if (plannedAmount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        this.expenseName = expenseName.trim();
        this.category = category;
        this.plannedAmount = plannedAmount;
        this.actualAmount = 0;
        this.purchased = false;
        this.purchasingDate = null;
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
    
   public boolean isPurchased() {
    return purchased;
    }

    public LocalDate getPurchasingDate(){
        return purchasingDate;
    }
    //SETTERS
     public void setPlannedAmount(double plannedAmount) {

        if (plannedAmount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        this.plannedAmount = plannedAmount;
    }

    // MARK EXPENSE AS PURCHASED
    public void markAsPurchased(double actualAmount, LocalDate purchasingDate) {

        if (actualAmount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        if (purchasingDate == null) {
            throw new IllegalArgumentException("Purchase date cannot be null.");
        }

        this.actualAmount = actualAmount;
        this.purchasingDate = purchasingDate;
        this.purchased = true;
    }
}




