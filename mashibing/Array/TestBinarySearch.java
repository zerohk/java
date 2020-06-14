public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int pos = binarySearch(arr, 15);
        System.out.println("15在数组的位置是：" + (pos + 1));
    }
    public static int binarySearch(int[] arr,int i){
        int start = 0;
        int end = arr.length - 1;
        int medium = (start + end) / 2;
        while(start <= end){
            if(i == arr[medium])
                return medium;
            if(i < arr[medium]){
                end = medium - 1;
            }
            if(i > arr[medium]){
                start = medium + 1;
            }
            medium = (start + end) / 2;
        }
        return -1;
    }
}
