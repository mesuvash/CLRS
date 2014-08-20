package org.clrs.algorithms;

import java.util.Arrays;

public class MaxSequenceSumIterative {

	public static int[] getMaxSubarrayWithLastElement(int[] xs, int start,
			int end) {
		int max_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_start_index = end;
		for (int i = end; i >= start; i--) {
			sum += xs[i];
			if (sum > max_sum) {
				max_sum = sum;
				max_start_index = i;
			}
		}
		return new int[] { max_start_index, end, max_sum };
	}

	public static int[] getMaxSubarray(int[] xs, int start, int end) {
		int[] temp;
		int max_start = 0, max_end = 0, max_sum = Integer.MIN_VALUE;
		for (int i = 0; i < xs.length; i++) {
			temp = getMaxSubarrayWithLastElement(xs, max_start, i);
			if (temp[2] > max_sum)	{
				max_start = temp[0];
				max_end = temp[1];
				max_sum = temp[2];
			}
		}
		return new int[] {max_start, max_end, max_sum};
	}

	public static void main(String[] args) {
		int[] x = new int[]{13, -3 , -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4,  7};
		System.out.println(Arrays.toString(MaxSequenceSumIterative
				.getMaxSubarray(x, 0, x.length - 1)));

	}

}
