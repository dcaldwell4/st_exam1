package Exam1;

public class TollCalculator {
    public double calculateDiscount(double weight, boolean isEV, boolean isCarpool) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }

        double discountPercent = 0.0;

        // fault #1 - boundary values
        //if (weight > 1200 && weight <= 3500)
        if (weight >= 1200 && weight < 3500) {
            if (isEV && isCarpool) {
                discountPercent = 0.15;
            } else if (isEV || isCarpool) {
                discountPercent = 0.10;
            }
        }
        // fault #2 - equivalence partition
        //else if (weight > 3500)
        else if (weight < 3500) {
            if (isEV && isCarpool) {
                // fault #3 - Decision Table
                // discountPercent = 0.25;
                discountPercent = 0.5;
            } else {
                discountPercent = 0.05;
            }
        }

        return discountPercent;
    }
}
