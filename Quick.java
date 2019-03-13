import java.io.*;
import java.util.*;

public class Quick {
	private static void swap(int[]data, int i0,int v0, int i1, int v1) {
		data[i0] = v1;
		data[i1] = v0;
	}
	public static int partition(int[] data, int start, int end) {
		Random rand = new Random();
		int i = rand.nextInt(end - start) + start;
		int key = data[i];
		swap(data,i,key,start,data[start]);
		for (int j = start; j < end; j++) {
			if (key > data[j]) {
				int val = data[j];
				for (int m = j-1; m > start; m--) {
					if (m == start+1) {
						data[m] = val;
					}
					else {
						data[m] = data[m - 1];
					}
				}
			}
		}
		for (int x = start; x < end; x++) {
			if (data[x] == key) {
				return x;
			}
		}
		return -1;
	}
}