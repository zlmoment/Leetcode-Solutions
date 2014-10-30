// A very thoughtful solution

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length, lenB = B.length;
        if ((lenA + lenB) % 2 == 1) {
            int mid = (lenA + lenB) / 2 + 1;
            return median(A, 0, lenA-1, B, 0, lenB-1, mid);
        } else {
            int mid = (lenA + lenB) / 2;
            return (median(A, 0, lenA-1, B, 0, lenB-1, mid) + 
                    median(A, 0, lenA-1, B, 0, lenB-1, mid+1)) / 2.0;
        }
    }
    
    public double median(int[] A, int startA, int endA, int[] B, int startB, int endB, int mid) {
        if (endA < startA) {
            return B[startB + mid - 1];
        }
        if (endB < startB) {
            return A[startA + mid - 1];
        }
        if (endA - startA > endB - startB) {
            return median(B, startB, endB, A, startA, endA, mid);
        }
        if (mid == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int midA = Math.min(mid/2, endA - startA + 1);
        int midB = mid - midA;
        if (A[startA + midA - 1] < B[startB + midB - 1]) {
            return median(A, startA + midA, endA, B, startB, endB, mid - midA);
        } else if (A[startA + midA - 1] > B[startB + midB - 1]) {
            return median(A, startA, endA, B, startB + midB, endB, mid - midB);
        }
        return A[startA + midA - 1];
    }
}