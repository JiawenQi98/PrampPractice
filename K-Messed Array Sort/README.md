# Problem:

Given an array of integers *arr* where each element is at most *k* places away from its sorted position, code an efficient function *sortKMessedArray* that sorts *arr*. For instance, for an input array of size *10* and *k = 2*, an element belonging to index *6* in the sorted array will be located at either index *4, 5, 6, 7 or 8* in the input array.

# Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Method:

- Insertion Sort: O(N * K).  Insertion Sort performs really well for small values of k but it is not recommended for large value of k (use it for k < 12).
- Min Heap: O(N * log(K)). The idea is to construct a min-heap of size k+1 and insert first k+1 elements into the heap. Then we remove min from the heap and insert next element from the array into the heap and continue the process until both array and heap are exhausted. Each pop operation from the heap should insert the corresponding top element in its correct position in the array.
