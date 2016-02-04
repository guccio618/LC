import java.util.Arrays;
import java.util.Random;


public class Q000_Algorithm_Sort {
	
	/************************ Select Sort ************************/
	// 时间O(n^2)，空间O(1)，稳定
	void select_sort(int[] p){
		for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (p[i] > p[j]) {
                    swap(p, i, j);
                }
            }
        }
	}

	/*********************** Insert Sort **************************/
	// 时间O(n^2)，空间O(1)，稳定
	void insert_sort(int[] p) {      
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

	
	/*********************** Bubble Sort **************************/
	// 时间O(n^2)，空间O(1)，稳定
	void bubble_sort(int[] p) {      
		for (int i = 0; i < p.length - 1; i++) {
			for (int j = p.length - 1; j >= i + 1; j--) {
				if (p[j] < p[j - 1]) {
					swap(p, j-1, j);
				}
			}
		}
	}
	
	
	/*********************** Merge Sort **************************/
	// 时间稳定在O(n*logn)，空间O(n)，稳定； 但如果n足够大，开辟space O(n)费时
	// Divide and Conquer; 先局部有序，再整体有序
	void recursive_merge_sort(int[] p, int x, int y){     
		if(x < y){
			int m = (x+y) / 2;
			recursive_merge_sort(p, x, m);
			recursive_merge_sort(p, m+1, y);
			merge_sort(p, x, m, y);
		}
	}
	
	void merge_sort(int[] p, int x, int m, int y){
		int a = m-x+1;
		int b = y-m;
		int[] L = new int[a+1];
		int[] R = new int[b+1];
		for(int i = 0; i < a; i++)
			L[i] = p[x+i];
		for(int j = 0; j < b; j++)
			R[j] = p[m+1+j];
		L[a] = R[b] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for(int k = x; k <= y; k++){
			if(L[i] < R[j]) 
				p[k] = L[i++];
			else 
				p[k] = R[j++];		
		}
	}

	
	/*********************** Random Quick Sort **************************/
	// 时间最理想O(n*logn)，最差O(n^2)，空间O(logn)，不稳定; worse case 是整个序列倒序，此时快速排序退化成冒泡排序
	// Divide and Conquer； 先整体有序，再局部有序； 如果不是worse case，其速度快于merge sort
	public int partition(int[] p, int x, int y) {
		int i = x - 1;
		int temp;
		int pivot = p[y];
		for (int j = x; j < y; j++) {
			if (p[j] <= pivot) {
				i++;
				temp = p[i];
				p[i] = p[j];
				p[j] = temp;
			}
		}
		temp = p[i + 1];
		p[i + 1] = p[y];
		p[y] = temp;
		return i + 1;
	}

	public int randomized_partition(int[] p, int x, int y) {
		int n = y - x + 1;
		int temp;
		int gap = new Random().nextInt(n); // 0~n-1间的随机数
		temp = p[y];
		p[y] = p[x + gap];
		p[x + gap] = temp;
		return partition(p, x, y);
	}

	public void quickSort(int[] p, int x, int y) {
		if (x < y) {
			int r = randomized_partition(p, x, y); // 也可以用 random_partition
			quickSort(p, x, r - 1);
			quickSort(p, r + 1, y);
		}
	}
	
	/*********************** Quick Sort **************************/
	// 时间最理想O(n*logn)，最差O(n^2)，空间O(logn)，不稳定; worse case 是整个序列倒序，此时快速排序退化成冒泡排序
	// Divide and Conquer； 先整体有序，再局部有序； 如果不是worse case，其速度快于merge sort
	public void quickSort2(int[] x, int left, int right){   
		if(left >= right) return;                         
		int i = left, j = right;
		double pivot = (x[left]+x[right])/2.0;  // pivot必须用double
		while(i < j){
			while(i < right && x[i] < pivot) i++;  // 右边界的判定
			while(j > left && x[j] >= pivot) j--;  // 左边界的判定
			if(i < j){
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
			}
		}
		if(j > left)                         // 分割
			quickSort2(x, left, j);
		if(right > j+1)
			quickSort2(x, j+1, right);		
	}
	
	
	/*********************** Heap Sort **************************/
	
	void heapSort(int[] array) {         // 时间O(n*logn)，空间O(1)，不稳定
		build_Max_heap(array);   // 构建堆,除了叶子外，其他叶子以上部分已经完成排序，
		int n = array.length;    // 按照从大到小，至上而下排序
		for (int i = n-1; i >= 1; i--) {  // 叶子无法排序，因此每次将位于root的最大的节点
			swap(array, 0, i);            // 和最后的节点替换，然后重新进行排序
			heapify(array, 0, i);
		}
	}

	void build_Max_heap(int[] array) {    // 仅完成叶子以上节点从大到小排序
		int n = array.length; 
		for (int i = n/2-1; i >= 0; i--){
			heapify(array, i, n);
		}
	}

	void heapify(int[] A, int i, int max) {
		int left = 2*i+1;              // 左孩子的下标（如果存在的话）
		int right = 2*i+2;             // 右孩子的下标（如果存在的话）
		int largest = i;            
		if (left < max && A[left] > A[i])
			largest = left;
		if (right < max && A[right] > A[largest])
			largest = right;
		if (largest != i) {
			swap(A, largest, i);
			heapify(A, largest, max);
		}
	}
	

    /***********************   radix sort   **************************/	
	
    // 基于count_sort的radix sort
	private void radixSort(int[] array,int radix, int bit_num) {  // array为待排序数; radix代表基数，如10进制radix就为10;          
        int length = array.length;  		                      // bit_num代表排序元素的最大位数;
        int[] temp = new int[length];       //用于暂存元素  
        int[] count = new int[radix];       //用于计数排序  
        int divide = 1;  
          
        for (int i = 0; i < bit_num; i++) {  	              
            System.arraycopy(array, 0, temp, 0, length);  
            Arrays.fill(count, 0);  
              
            for (int j = 0; j < length; j++) {  
                int tempKey = (temp[j] / divide) % radix;  // 按位排序，从第1位开始
                count[tempKey]++;  
            }  
              
            for (int j = 1; j < radix; j++) {  
                count [j] = count[j] + count[j-1];         // 统计每个位上的数应该排的位置，例如比7大的有多少个
            }  
                       
            for (int j = length - 1; j >= 0; j--) {  
                int tempKey = (temp[j] / divide) % radix;  
                count[tempKey]--;  
                array[count[tempKey]] = temp[j];           // 排在array里的第几位
            }                
            divide = divide * radix;                  
        }  
  
    }  	
	
	public void swap(int[] x, int i, int j){
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	
	/***********************   main   **************************/
	
	public static void main(String[] args){
		Q000_Algorithm_Sort t = new Q000_Algorithm_Sort();
		
		int [] array = {2,5,3,3,3,2,35,2,1,36,6,4,9,6,7}; 
		
		int [] array0 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array0[i] = array[i];
		t.select_sort(array0);
		System.out.print("Select Sort: ");
		for(int i = 0; i < array0.length; ++i)
			System.out.print(array0[i] + ", ");
		System.out.println();
		
		int [] array1 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array1[i] = array[i];
		t.insert_sort(array1);
		System.out.print("Insert Sort: ");
		for(int i = 0; i < array1.length; ++i)
			System.out.print(array1[i] + ", ");
		System.out.println();
		
		int [] array2 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array2[i] = array[i];
		t.bubble_sort(array2);
		System.out.print("Bubble Sort: ");
		for(int i = 0; i < array2.length; ++i)
			System.out.print(array2[i] + ", ");
		System.out.println();
		
		int [] array3 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array3[i] = array[i];
		t.recursive_merge_sort(array3, 0, array3.length-1);
		System.out.print("Merge Sort:  ");
		for(int i = 0; i < array3.length; ++i)
			System.out.print(array3[i] + ", ");
		System.out.println();
		
		int [] array4 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array4[i] = array[i];
		t.quickSort(array4, 0, array4.length-1);
		System.out.print("Quick Sort:  ");
		for(int i = 0; i < array4.length; ++i)
			System.out.print(array4[i] + ", ");
		System.out.println();
		
		int [] array5 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array5[i] = array[i];
		t.quickSort(array5, 0, array5.length-1);
		System.out.print("Quick Sort2:  ");
		for(int i = 0; i < array5.length; ++i)
			System.out.print(array5[i] + ", ");
		System.out.println();
		
		int [] array6 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array6[i] = array[i];
		t.heapSort(array6);
		System.out.print("Heap Sort:   ");
		for(int i = 0; i < array6.length; ++i)
			System.out.print(array6[i] + ", ");
		System.out.println();
		
		int [] array7 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array7[i] = array[i];
		t.radixSort(array7, 10, 2);
		System.out.print("Radix Sort:  ");
		for(int i = 0; i < array7.length; ++i)
			System.out.print(array7[i] + ", ");
		System.out.println();
	}	
}
