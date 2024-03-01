import java.util.Arrays;
import java.util.HashSet;

public class MaximumProfit {
    private int[] prices;
    private int[] categories;

    public MaximumProfit(int[] prices, int[] categories) {
        this.prices = prices;
        this.categories = categories;
    }

    // Calculate the maximum profit
    /*
     * To find maximum profit optimally, we need sort the prices arry in ascending order and
     * iterate through the prices array. For each price, we check if it's associated category is
     * different, if it is we increment the different category count and multiply the
     * price with the different category count to get the profit. We then add the profit to
     * the maxProfit variable. We return the maxProfit variable at the end of the iteration.
     */
    public int findMaximumProfit() {
        int maxProfit = 0;
        // combine prices and categories into tuples
        int[][] tuples = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            tuples[i][0] = prices[i];
            tuples[i][1] = categories[i];
        }

        // sort the tuples by price
        Arrays.sort(tuples, (a, b) -> a[0] - b[0]);

        // Keep track of the different categories visited
        HashSet<Integer> differentCategories = new HashSet<>();

        // Keep track of the different categories
        int differentCategoryCount = 0;

        // iterate through the sorted tuples
        for (int i = 0; i < tuples.length; i++) {
            int price = tuples[i][0];
            int category = tuples[i][1];

            // if the category is different, increment the different category count
            if (!differentCategories.contains(category)) {
                differentCategories.add(category);
                differentCategoryCount++;
            }

            // calculate the profit and add it to the maxProfit
            maxProfit += price * differentCategoryCount;
        }

        // return the maxProfit
        return maxProfit;
    }
}
