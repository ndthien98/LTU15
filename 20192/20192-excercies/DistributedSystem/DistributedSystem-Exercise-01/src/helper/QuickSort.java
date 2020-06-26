package helper;

public class QuickSort implements NumberSorter {

	@Override
	public int[] sort(int[] input) {
		sort(input,0,input.length-1);
		return input;
	}

	private void sort(int arr[], int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			sort(arr, low, pivot - 1);
			sort(arr, pivot + 1, high);
		}
	}

	private int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {

			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}
}
