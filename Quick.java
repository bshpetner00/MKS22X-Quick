import java.io.*;
import java.util.*;

public class Quick {
	private static void swap(int[]data, int i0,int v0, int i1, int v1) {
		data[i0] = v1;
		data[i1] = v0;
	}

	public static int partition(int[] data, int start, int end) {
		Random rand = new Random();
		int i = rand.nextInt(data.length); //chosing pivot index
		int pivot = data[i]; //pivot value
		swap(data,i,pivot,start,data[start]); //to start, put the pibot at the beginning
		while (start < end) { //go through entire array
			if (data[start+1] > data[start]) { //larger number ahead of smaller
				swap(data,start+1,data[start+1],end,data[end]); //puts bigger numbers farther ahead
				end--; //decrement hi index
			}
			else {
				swap(data,start+1,data[start+1],start,data[start]); //put smaller number before larger
				start++; //increment lo index
			}
		}
		return start; //loop complete, start marks the spot
	}

	public static int quickSelect(int[]data, int k) {
		int start = 0;
		int end = data.length-1;
		int pivot = partition(data,start,end);
		while (pivot <= k) {
			pivot = partition(data,start,end);
			if (pivot < k) {
				start = pivot + 1;
			}
			else {
				end = pivot - 1;
			}
		}
		return data[k];
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