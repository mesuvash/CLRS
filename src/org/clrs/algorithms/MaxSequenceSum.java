package org.clrs.algorithms;

import java.lang.reflect.Array;

public class MaxSequenceSum {

	public static int[] getMaxCrossingSum(int[] xs, int low, int high, int mid) {
		int max_left = Integer.MIN_VALUE;
		int max_left_index = mid, sum = 0;
		int i;
		for (i = mid; i > low; i--) {
			sum += xs[i];
			if (sum >= max_left) {
				max_left = sum;
				max_left_index = i;
			}
		}
		
		int max_right = Integer.MIN_VALUE;
		int max_right_index = mid;
		sum = 0;
		for (i = mid + 1; i < high; i++) {
			sum += xs[i];
			if (sum >= max_right) {
				max_right = sum;
				max_right_index = i;
			}
		}
		int[] result = {max_left_index, max_right_index, max_left+max_right};
		return result;
	}

	public static int[] getMaxSequence(int[] xs, int low, int high){
		int[] left_result,right_result, crossing_result;
		int mid;
		
		if (high == low){
			return new int[]{low, high, xs[low]};
		}
		else{
			mid = (high + low )/ 2;
			left_result = getMaxSequence(xs, low, mid);
			right_result = getMaxSequence(xs, mid+1, high);
			crossing_result = getMaxCrossingSum(xs, low, high, mid);
			if ((left_result[2] >= right_result[2]) && (left_result[2] >= crossing_result[2])){
				return left_result;
			}
			else if((right_result[2] > left_result[2]) && (right_result[2] >= crossing_result[2])){
				return right_result;
			}
			else{
				return crossing_result;
			}
		}

	}
	
	public static void main(String[] args) {
		int[] x = new int[]{13, -3 , -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4,  7};
		System.out.println(MaxSequenceSum.getMaxSequence(x,0, x.length-1)[2]);
	}
}
