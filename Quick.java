import java.io.*;
import java.util.*;

public class Quick {
	private static void swap(int[]data, int i0,int v0, int i1, int v1) {
		data[i0] = v1;
		data[i1] = v0;
	}

	public static int partition(int[] data, int start, int end) {
		Random rand = new Random();
		int i = rand.nextInt(end - start + 1) + start; //chosing pivot index
		int pivotVal = data[i]; //pivot value
		swap(data,i,pivotVal,start,data[start]); //to start, put the pivot at the beginning
		i = start;
		pivotVal = end;
		while (i < pivotVal) { //go through entire array
			if (data[i+1] > data[i]) { //larger number ahead of smaller
				swap(data,i+1,data[i+1],pivotVal,data[pivotVal]); //puts bigger numbers farther ahead
				pivotVal--; //decrement boundary
			}
			else {
				swap(data,i+1,data[i+1],i,data[i]); //put smaller number before larger
				i++; //increment lo index
			}
		}
		int p = start; //to fix the partition index
		for (int q = start + 1; q <= end; q++) { //travel thru rest
			if (data[q] < data[start]) {
				p = q; //get correct index if current val is smaller than start
			}
			else if (data[q] > data[start]) {
				q = end + 1; //get correct index if current val is greater than start
			}
		}
		swap(data,start,data[start],p,data[p]); //swap the starting value and the corrected index to complete
		return p; //partition index
	}

	public static int quickSelectH(int[]data, int k, int lo, int hi) {
		int pivot = 0;
		while (pivot != k) {
			pivot = partition(data,lo,hi);
			if (pivot < k) {
				lo = pivot + 1;
			}
			else {
				hi = pivot - 1;
			}
		}
		return data[k];
	}

	public static int quickselect(int[]data, int k) {
		return quickSelectH(data,k,0,data.length-1);
	}

	public static void quickSortH(int[]data, int lo, int hi) {
		if (lo < hi) {
			int p = partition(data,lo,hi);
			quickSortH(data,lo,p-1);
			quickSortH(data,p+1,hi);

		}
	}

	public static void quicksort(int[] data) {
		quickSortH(data, 0, data.length-1);
	}

	public static String toStringDebug(int[] data){
      String result = "";
      for (int i = 0; i < data.length; i++){
          result += data[i];
      }
      return result;
    }
}