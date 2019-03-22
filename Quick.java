//I brainstormed with Alex Thomp for creating my quickselect 

import java.io.*;
import java.util.*;

public class Quick {
	private static void swap(int[]data, int i0,int v0, int i1, int v1) {
		data[i0] = v1;
		data[i1] = v0;
	}

  private static int medianI(int[]data, int start, int end) {
    int mid = (end+start)/2;
    if ((start - end) * (mid - start) >= 0) // a >= b and a <= c OR a <= b and a >= c
      return start;
    else if ((end - start) * (mid - end) >= 0) // b >= a and b <= c OR b <= a and b >= c
      return end;
    else {
      return mid;
    }
  }

	public static int partition(int[] data, int start, int end) {
      Random rand = new Random();
      int pivotInd = medianI(data,start,end);
      int pivotVal = data[pivotInd];
      swap(data, pivotInd, pivotVal, start, data[start]);
      pivotInd = start + 1;
      int upperBound = end;
      while (pivotInd != upperBound){
        int rando = rand.nextInt(2); 
        if (data[pivotInd] > pivotVal || data[pivotInd] == pivotVal && rando == 0){
          swap(data, pivotInd, data[pivotInd], upperBound, data[upperBound]);
          upperBound--;
        }else{
          pivotInd++;
        }
      }
      if (data[pivotInd] < pivotVal) {
        swap(data, pivotInd, data[pivotInd], start, data[start]);
        return pivotInd;
      }
      swap(data, pivotInd-1, data[pivotInd-1], start, data[start]);
      return pivotInd-1;
  }

	public static int quickselect(int[]data, int k) {
    int[] crew = data;
    quicksort(crew);
    return crew[k];
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
}