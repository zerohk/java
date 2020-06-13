//进三退一的简单版本
public class Count3Quit1 {
    public static void main(String[] args) {
    //定义一个布尔类型的数组，大小为500，表示500个孩子，用true或false来表示孩子是否还在形成的圈中
    boolean[] arr = new boolean[500];
    //用一个for循环给每个值赋值true，表示现在500个孩子都在圈中
    for(int i = 0;i < arr.length;i++){
        arr[i] = true;
    }
    //left表示留下的孩子数量，即数组的长度
    int left = arr.length;
    //计数用，每逢三就归零
    int  numberCount = 0;
    //索引值
    int index = 0;
    //当圈中只剩一个孩子时，停止循环
    while(left > 1){
    //当值为true时，表示孩子在圈中，numberCount+1；
        if(arr[index] == true){
            numberCount++;
        }
        //逢三归零
        if(numberCount == 3){
            numberCount = 0;
            //逢三归零，同时把这一孩子排除出圈中，即把该孩子的值设为false；
            arr[index] = false;
            //剩下的人数-1；
            left--;
        }
        //索引+1
        index++;
        //当到达最后一个孩子时，索引归零，重头开始
        if(index == arr.length){
            index = 0;
        }
    }
    //最后为true的那一个就是留下的孩子，i是他的数组下标，再加一就是他的编号

    for(int i = 0;i < arr.length;i++){
        if(arr[i] == true)
            System.out.println(i);
    }
    }
}
