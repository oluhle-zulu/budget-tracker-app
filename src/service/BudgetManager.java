package service;

import java.util.*;
import model.Expense;

public class BudgetManager {

    private ArrayList<Expense> expenses;

    // CONSTRUCTOR
    public BudgetManager() {
        expenses = new ArrayList<>();
    }

    // ADD EXPENSE
    public void addExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null.");
        }

        expenses.add(expense);
    }

    // REMOVE EXPENSE
    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    // GET ALL EXPENSES
    public ArrayList<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    // CALCULATE TOTAL PLANNED SPENDING
    public double getTotalPlannedAmount() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getPlannedAmount();
        }

        return total;
    }

    // CALCULATE TOTAL ACTUAL SPENDING
    public double getTotalActualAmount() {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.isPurchased()) {
                total += expense.getActualAmount();
            }
        }

        return total;
    }

}

