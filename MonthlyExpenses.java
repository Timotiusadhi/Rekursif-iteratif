public class MonthlyExpenses {

    // Iterative algorithm
    public static int calculateTotalIterative(int[] expenses) {
        int total = 0;
        for (int expense : expenses) {
            total += expense;
        }
        return total;
    }

    // Recursive algorithm
    public static int calculateTotalRecursive(int[] expenses, int index) {
        if (index == expenses.length) { // Base case
            return 0;
        }
        return expenses[index] + calculateTotalRecursive(expenses, index + 1);
    }

    public static void main(String[] args) {
        // Define input sizes
        int[] inputSizes = {10, 100, 1000, 10000};
        
        System.out.println("Size\tIterative (ns)\tRecursive (ns)");
        for (int size : inputSizes) {
            // Generate random expenses for the given size
            int[] expenses = new int[size];
            for (int i = 0; i < size; i++) {
                expenses[i] = (int) (Math.random() * 10000); // Random values between 0-9999
            }

            // Measure time for iterative
            long startIterative = System.nanoTime();
            calculateTotalIterative(expenses);
            long endIterative = System.nanoTime();
            long timeIterative = endIterative - startIterative;

            // Measure time for recursive
            long startRecursive = System.nanoTime();
            calculateTotalRecursive(expenses, 0);
            long endRecursive = System.nanoTime();
            long timeRecursive = endRecursive - startRecursive;

            // Print results
            System.out.printf("%d\t%d\t\t%d\n", size, timeIterative, timeRecursive);
        }
    }
}