public class Q000_Algorithm_Premutation {
	public void permute(int[] array, int len){
		if(len == 0)
			print(array);

		for(int i = 0; i <= len; ++i){
			swap(array, i, len);
			permute(array, len-1);
			swap(array, i, len);
		}
	}

	public void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void print(int[] array){
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args){
		Q000_Algorithm_Premutation p = new Q000_Algorithm_Premutation();
		int[] array = {1, 2, 3};
		p.permute(array, 2);
		//p.print(array);
	}
}
