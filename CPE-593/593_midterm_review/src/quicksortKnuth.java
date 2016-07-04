public class quicksortKnuth {
	final int k = 0;
		
	public void Quicksort(int[] x, int left, int right) {
		if (left >= right)
			return;
		int i = left, j = right;
		int pivot = (x[left] + x[right]) / 2; // pivot必须用double
		while (i < j) {
			while (x[i] < pivot && i < right)
				i++; // 右边界的判定
			while (x[j] >= pivot && j > left)
				j--; // 左边界的判定
			if (i < j) {
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
			}
		}
		if (j - left > k) // 分割
			Quicksort(x, left, j);
		else
			insert_sort(x, left, j);
		if (right - (j + 1) > k)
			Quicksort(x, j + 1, right);
		else
			insert_sort(x, j + 1, right);
	}

	public void insert_sort(int[] p, int start, int end) {
		int j, key;
		for (int i = start + 1; i <= end; i++) {
			j = i - 1;
			key = p[i];
			while (j >= 0 && p[j] > key) {
				p[j + 1] = p[j];
				j--;
			}
			p[j + 1] = key;
		}
	}
	
	public static void main(String[] args){
		int[] array = {9,3,7,6,2,2,2,3,3,2,2,4,39,6,3,5,2,1,7,6};
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
		System.out.println();
		quicksortKnuth t = new quicksortKnuth();
		t.Quicksort(array, 0 , array.length-1);
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
		System.out.println();
		
		int[] array2 = {9,3,7,6,2,2,2,9,6,3,5,2,1,7,6};
		for(int i = 0; i < array2.length; ++i)
			System.out.print(array2[i] + ", ");
		System.out.println();
		quicksortKnuth2 t2 = new quicksortKnuth2();
		t2.quicksortKnuthFunc(array2, 0 , array2.length-1);
		for(int i = 0; i < array2.length; ++i)
			System.out.print(array2[i] + ", ");
		System.out.println();
	}
}


class quicksortKnuth2{
	final int k = 7;
	
	public void quicksortKnuthFunc(int[] x, int left, int right){
		Quicksort(x, left, right);
		insert_sort(x);
	}
	
	public void Quicksort(int[] x, int left, int right) {
		if (left >= right)
			return;
		int i = left, j = right;
		double pivot = (x[left] + x[right]) / 2.0; // pivot必须用double
		while (i < j) {
			while (x[i] < pivot && i < right)
				i++; // 右边界的判定
			while (x[j] >= pivot && j > left)
				j--; // 左边界的判定
			if (i < j) {
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
			}
		}
		if (j - left > k) // 分割
			Quicksort(x, left, j);
		if (right - (j + 1) > k)
			Quicksort(x, j + 1, right);
	}

	public void insert_sort(int[] p) {
		int j, key;
		for (int i = 1; i < p.length; i++) {
			j = i - 1;
			key = p[i];
			while (j >= 0 && p[j] > key) {
				p[j + 1] = p[j];
				j--;
			}
			p[j + 1] = key;
		}
	}
}
