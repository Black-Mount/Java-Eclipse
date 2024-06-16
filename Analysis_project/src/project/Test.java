package project;

import java.util.ArrayList;

public class Test {

    // Method to calculate the average stock price
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;

        // Iterate through each price in the array
        for (float price : prices) {
            sum += price; // Add each price to the sum
        }

        // Calculate the average by dividing the total sum by the number of prices
        return sum / prices.length;
    }

    // Method to find the maximum stock price
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0]; // Initialize maxPrice with the first element of the array

        // Iterate through each price in the array
        for (float price : prices) {
            if (price > maxPrice) {
                maxPrice = price; // Update maxPrice if current price is greater
            }
        }

        // Return the maximum price found
        return maxPrice;
    }

    // Method to count occurrences of a specific price
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;

        // Iterate through each price in the array
        for (float price : prices) {
            if (price == targetPrice) {
                count++; // Increment count if current price matches the target price
            }
        }

        // Return the total count of occurrences
        return count;
    }

    // Method to compute cumulative sum of stock prices in ArrayList
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;

        // Iterate through each price in the ArrayList
        for (float price : prices) {
            sum += price; // Add each price to the running sum
            cumulativeSum.add(sum); // Add the cumulative sum to the result ArrayList
        }

        // Return the ArrayList containing cumulative sums
        return cumulativeSum;
    }

    public static void main(String[] args) {
        // Example usage
        float[] stockPricesArray = { 45.7f, 48.2f, 50.5f, 52.1f, 47.8f, 49.3f, 51.6f, 46.9f, 48.7f, 50.2f };
        ArrayList<Float> stockPricesList = new ArrayList<>();
        stockPricesList.add(45.7f);
        stockPricesList.add(48.2f);
        stockPricesList.add(50.5f);
        stockPricesList.add(52.1f);
        stockPricesList.add(47.8f);
        stockPricesList.add(49.3f);
        stockPricesList.add(51.6f);
        stockPricesList.add(46.9f);
        stockPricesList.add(48.7f);
        stockPricesList.add(50.2f);

        // Calculate average price from array
        float avgPriceArray = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price (Array): " + avgPriceArray);

        // Find maximum price from array
        float maxPriceArray = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price (Array): " + maxPriceArray);

        // Count occurrences of a specific price from array
        float targetPrice = 50.5f;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + " (Array): " + occurrences);

        // Compute cumulative sum from ArrayList
        ArrayList<Float> cumulativeSumList = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices (ArrayList): " + cumulativeSumList);
    }
}

