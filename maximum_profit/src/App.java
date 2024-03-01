public class App {
    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = {2, 1, 4, 4};
        int[] categories1 = {3, 1, 2, 3};
        MaximumProfit maximumProfit1 = new MaximumProfit(prices1, categories1);
        System.out.println(maximumProfit1.findMaximumProfit()); // 29

        // Test case 2
        int[] prices2 = {3, 2, 4};
        int[] categories2 = {2, 1, 2};
        MaximumProfit maximumProfit2 = new MaximumProfit(prices2, categories2);
        System.out.println(maximumProfit2.findMaximumProfit()); // 16

        // Test case 3
        int[] prices3 = {2, 7, 3, 4};
        int[] categories3 = {3, 2, 2, 3};
        MaximumProfit maximumProfit3 = new MaximumProfit(prices3, categories3);
        System.out.println(maximumProfit3.findMaximumProfit()); // 30
    }
}
