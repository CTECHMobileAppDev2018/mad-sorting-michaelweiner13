import java.util.Arrays;

class Sort {

    // Method to do an INSERTION SORT on a given array
    public void insertionSort(double arr[], long start, long end) {
      for (int i = 1; i < arr.length; i++) { // Loop through the array starting at the second item to be able to comapre it to the first item

        // Declare and initalize a variable to store the value of the array item of the current position of the loop to compare it to the item to the left
        // Must be initalized as a double to match the array type of the array coming in as an argument when the method is called
        double compareKey = arr[i];
        int alpha = i - 1; // Declare and initalize a variable to hold the array index for the item to the left of the loop

        // Checks to see if the poistion of the item can be moved left AND that item to the right is smaller than that of the item to the left -- IF TRUE swap the right item with the left
        while (alpha >= 0 && arr[alpha] > compareKey) {
          arr[alpha + 1] = arr[alpha];
          --alpha; // Decrease alpha by one to check to see if it can be moved again IF it meets the requirments of the while loop
        }
        arr[alpha + 1] = compareKey; // Set the previous item that was to the left to the position to the right -- compareKey acts a 'temp' variable holder
      }
    }

    // Method to do a QUICK SORT on a given array
    // Calls split()
    public void quickSort(double arr[], long start, long end) {
      if (start < end) { // Check to make sure sort is not starting past the end
          int pivotIndex = split(arr, start, end); // Call split() to find the pivot point for arr[]

          quickSort(arr, start, pivotIndex - 1); // Recursivly sort the left side of the array (start to pivotIndex - 1)
          quickSort(arr, pivotIndex + 1, end); // Recursivly sort the right side of the array (pivotIndex + 1 to end)
          // The pivotPoint is not sorted as it will be sorted already -- Waste of time to sort another item
      }

    }

    // Splits arr[] into to 2 sections around a pivot point to sort 2 smaller sections
    public int split( double arr[], long start, long end) {

      // Sets the pivot point to the last item in arr[]
      double pivotPoint = arr[(int) end];

      // Declare and initalize a variable to set the starting point of the loop impossible
      // Used int the for loop below to aid in swapping array elements
      int alpha = (int) start - 1;

      // Loop through every item in the array
      // If array element is smaller than the pivot point it will be moved left; If array item is larger it will be moved right
      for (int beta = (int)start; beta < end; beta++) {
        if (arr[beta] <= pivotPoint) { // Checks to see if the current array item being looped through is less than the pivot point
          alpha++; // Increase i to be 0; This will allow the item to be moved left (since it is smaller than the pivot point)

          double temp = arr[alpha]; // Store the smaller value into temp
          arr[alpha] = arr[beta]; // Move the larger value into the array to the right
          arr[beta] = temp; // Set the smaller vlaue into the array to the left
        }
      }

      double temp = arr[alpha + 1]; // Store the value of the smaller item
      arr[alpha + 1] = arr[(int)end]; // Set the larger value one poistion to the right
      arr[(int)end] = temp; // Set the smaller value to the left using 'temp' as a middle man

      // Return the position of the pivotPoint
      return alpha + 1;
    }


    // Test insertionSort() and quickSort()
    public static void main(String args[]) {
        double arr[] = {10.0, 7.1, 8.6, 9.9, 1.8, 5.0};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr)); // Print out original array

        // Create a sorted array to compare the sort() array too
        double sortedArr[] = arr.clone();
        Arrays.sort(sortedArr);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(sortedArr)); // Print what the sorted array should look life

        System.out.println(); // Print blank line to make output easier to read


        // INSERTION SORT
        Sort sorter = new Sort(); // Create an Insertion Sort object

        long insertionStartTime = System.nanoTime(); // Start timer before the method is called
        sorter.insertionSort(arr, 0, arr.length); // Call sort() on sorter
        long insertionEndTime = System.nanoTime(); // End timer after the method terminates

        System.out.println("*** Your Insertion Sort - Sorted Array: ");
        System.out.println(Arrays.toString(arr)); // Print the sorted array using the sort() method created above

        System.out.println(); // Print blank line to make output easier to read


        // QUICK SORT
        Sort sorter1 = new Sort(); // Create an Insertion Sort object

        long quickSortStartTime = System.nanoTime(); // Start timer before quickSort()is called
        sorter1.quickSort(arr, 0, arr.length - 1); // Call sort() on sorter
        long quickSortEndTime = System.nanoTime(); // End timer after quickSort() terminates

        System.out.println("*** Your Quick Sort - Sorted Array: ");
        System.out.println(Arrays.toString(arr)); // Print the sorted array using the sort() method created above

        System.out.println(); // Print blank line to make output easier to read

        // Print out times for each method's total execution time
        System.out.println("*************");
        System.out.println("*** TIMES ***");
        System.out.println("*************");
        System.out.println("Insertion Sort took: " + (insertionEndTime - insertionStartTime) + " nanoseconds");
        System.out.println("Quick Sort took: " + (quickSortEndTime - quickSortStartTime) + " nanoseconds");
    }
}
