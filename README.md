<h2>Java -- Insertion and Quick Sort</h2>

A simple Java program that does an Inerstion and Quick sort on a given array. Tester method included with timer. Each sort is its own method. <br>

<strong>Insertion Sort</strong> = insertionSort(double arr[], long start, long end)<br>
<strong>Quick Sort</strong> = quickSort(double arr[], long start, long end) <br>

Insertion Sorts have an <i>average</i> efficency of <strong>O(n^2)</strong>. <br>
Quick Sorts have an <i>average</i> efficency of <strong>O(n log n)</strong>. <br>

*The quick sort method is recursive that calls <strong>split()</strong> to break each array into 2 halves and then sub-haves for the left-hand side of the pivot point. The pivot point is the last item in the array. It is usally best to use the first, last, or random item. Don't waste time trying to find the best pivot point. It wastes memory and efficency. 
