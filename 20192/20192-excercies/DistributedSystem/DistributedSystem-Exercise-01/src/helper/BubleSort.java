package helper;

public class BubleSort implements NumberSorter{

	@Override
	public int[] sort(int[] input) {
		int n = input.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n ; j++) {
				if(input[j] < input[i]) {
					input[j] = input[j] + input[i];
					input[i] = input[j] - input[i];
					input[j] = input[j] - input[i];
				}
			}
		}
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
		return input;
	}

}
