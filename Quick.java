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
}