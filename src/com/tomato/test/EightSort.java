package com.tomato.test;

import java.util.ArrayList;
import java.util.List;

/*
 * java 程序员必须熟练的八种排序算法：
 * 内部排序（只使用内存）：1.插入排序：①直接插入排序  ②希尔排序
 * 	2.选择排序：①简单选择排序    ②推排序
 * 	3.交换排序：①冒泡排序  ②快速排序
 * 	4.归并排序
 * 	5.基数排序
 * 外部排序（内存和外存结合使用）：
 * 
*/
public class EightSort {

    public static void main(String[] args) {
	int[] arry = {12,2,12,33,21,344,11,333,55,61,46,18,3,1,9,2344};
	//测试直接插入排序
	insertSort(arry);
	System.out.println();
	//测试希尔排序
	shellSort(arry);
	System.out.println();
	//测试简单选择排序
	selectSort(arry);
	System.out.println();
	//测试冒泡排序
	bubbleSort(arry);
	System.out.println();
	//测试基数排序
	radixSort(arry);
	//测试快速排序
	quickSort(arry, 0, arry.length-1);
	//测试归并排序
	_sort(arry, 0, arry.length-1);
	//测试堆排序
	heapSort(arry);
	//打印数组
	for(int i:arry)System.out.print(i+",");

    }
    
    /**
     * 方法名： insertSort
     * 方法描述：插入排序中的直接插入排序：
     *	基本思想：
     *		在要排序的一组数中，假设前面的（n-1）[n>=2]已经是排好顺序的，现在是要把第n个数字
     *		插到前面有序的数中，使得这n个数也是排好序的。如此反复直到排好所有的顺序。
     * @param arry
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 26, 2015 10:33:33 AM
     */
    private static void insertSort(int[] arry){
	int temp = 0;
	for(int i = 1;i <arry.length;i++){
	    int j = i-1;
	    temp = arry[i];
	    for(;j>=0&&temp<arry[j];j--){//将大于temp的数整体向后移一个单位
		arry[j+1] = arry[j];
	    }
	    arry[j+1] = temp;
	}
	for(int i:arry){
	    System.out.print(i+"、");	    
	}
    }
    
    /**
     * 方法名： shellSort
     * 方法描述：希尔排序（最小增量排序）：插入排序的一种</p>
     * 	基本思想：该算法是先将需要排序的算法按照某个增量d（n/2，n为要排序的个数）分成若干组，每一组的记录下标相差d，</p>
     * 		对每一组的全部元素进行直接插入排序，然后再用较小的增量（d/2）进行分组，再在每个小组中�兄苯硬迦�/p>
     * 		排序，当最小增量为1时，进行直接排完序后，整个排序就完成了。</p>
     * @param arry
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 26, 2015 1:27:49 PM
     */
    private static void shellSort(int[] arry){
	double d1 = arry.length;
	int temp = 0;
	while(true){
	    d1 = Math.ceil(d1/2);
	    int d = (int) d1;
	    //将需要排序的数组按照增量d分组
	    for(int i = 0;i < d;i++){
		//start接下来就是一个直接插入排序
		for(int z = i+d;z <arry.length;z+=d){
		    int j = z - d;
		    temp = arry[z];
		    for(;j>=0&&temp<arry[j];j-=d){
			arry[j+d] = arry[j];
		    }
		    arry[j+d] = temp;
		}
		//end直接插入排序完成
	    }
	    if(d==1) break;
	}
	for(int i:arry){
	    System.out.print(i+"、");	    
	}
    }
    
    /**
     * 方法名： selectSort
     * 方法描述：简单选择排序：是选择排序的一种。</p>
     * 	基本思想：就是在需要排序的数字中选择出最小的那个，然后和第一个位置的数进行调换位置，</p>
     * 		然后再剩下的中选择最下的数字，然后再与第二个数字进行位置调换。如此循环</p>
     * 		直到倒数第二个数字与倒数第一个数字调换位置为止。</p>
     * @param arry
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 26, 2015 2:38:14 PM
     */
    private static void selectSort(int[] arry){
	int pos = 0;//用来记录最小数的位置的
	for(int i = 0;i < arry.length;i++){
	  int j = i+1;
	  pos = i;
	  int temp = arry[i];
	  //在剩下的数字中找出最小的数字
	  for(;j<arry.length;j++){
	      if(arry[j] < temp){
		  temp = arry[j];
		  pos = j;
	      }
	  }
	  //找出的最小数字与第i个位置调换
	  arry[pos] = arry[i];
	  arry[i] = temp;
	}
	//打印排好序的数组
	for(int i:arry){
	    System.out.print(i+"、");	    
	}	
    }
    /**
     * 方法名： heapSort
     * 方法描述：推排序：是一种树形选择排序的一种，也是对直接选择排序的一种改进。</p>
     * 	基本思想：
     * @param arry
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 26, 2015 3:03:49 PM
     */
    private static void heapSort(int[] arry){
	int arrayLength = arry.length;
	// 循环建堆
	for (int i = 0; i < arrayLength - 1; i++) {
	    // 建堆
	    buildMaxHeap(arry, arrayLength - 1 - i);
	    // 交换堆顶和最后一个元素
	    swap(arry, 0, arrayLength - 1 - i);
	}
    }
    
    /**
     * 方法名： swap
     * 方法描述：交换，从堆中踢出最大数：
     * @param arry
     * @param i
     * @param j
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 27, 2015 10:50:56 AM
     */
    private static void swap(int[] arry, int i, int j) {
	int tmp = arry[i];
	arry[i] = arry[j];
	arry[j] = tmp;
    }

    /**
     * 方法名： buildMaxHeap
     * 方法描述：对arry数组从0到lastIndex建大顶堆
     * @param arry
     * @param lastIndex
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 27, 2015 10:51:18 AM
     */
    private static void buildMaxHeap(int[] arry, int lastIndex) {
	// TODO Auto-generated method stub
	// 从lastIndex处节点（最后一个节点）的父节点开始
	for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
	    // k保存正在判断的节点
	    int k = i;
	    // 如果当前k节点的子节点存在
	    while (k * 2 + 1 <= lastIndex) {
		// k节点的左子节点的索引
		int biggerIndex = 2 * k + 1;
		// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
		if (biggerIndex < lastIndex) {
		    // 若果右子节点的值较大
		    if (arry[biggerIndex] < arry[biggerIndex + 1]) {
			// biggerIndex总是记录较大子节点的索引
			biggerIndex++;
		    }
		}
		// 如果k节点的值小于其较大的子节点的值
		if (arry[k] < arry[biggerIndex]) {
		    // 交换他们
		    swap(arry, k, biggerIndex);
		    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
		    k = biggerIndex;
		} else {
		    break;
		}
	    }
	}
    }

    
    /**
     * 方法名： bubbleSort
     * 方法描述：冒泡排序：</p>
     * 	基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，</p>
     * 		让较大的数往下沉，较小的�厦啊＜矗好康绷较嗔诘氖冉虾蠓⑾炙堑呐判蛴肱判蛞笙喾词保徒腔セ弧�/p>
     * @param arry
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 26, 2015 4:08:08 PM
     */
    private static void bubbleSort(int[] arry){
	int temp = 0;
	for (int i = 0; i < arry.length - 1; i++) {
	    for (int j = 0; j < arry.length - i - 1; j++) {
		if (arry[j] > arry[j + 1]) {
		    temp = arry[j];
		    arry[j] = arry[j + 1];
		    arry[j + 1] = temp;
		}
	    }
	}
	//打印排好序的数组
	for (int i : arry) {
	    System.out.print(i + "、");
	}
    }
    
    /**
     * 方法名： quickSort
     * 方法描述：快速排序：</br>
     * 	基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,</br>
     * 		一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用</br>
     * 		同样的方法递归地排序划分的两部分。
     * @param arry
     * @param low 不为空的数组最小的下标(0)
     * @param high 数组长度
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 26, 2015 4:41:23 PM
     */
    private static void quickSort(int[] arry,int low,int high){
	//arry数组必须不为空，可以进行不为空判断
	if(low < high){
	    int middle = getMiddle(arry, low, high);//将数组一分为二
	    quickSort(arry, low, middle-1);//对低字表进行排序
	    quickSort(arry, middle+1, high);//对高字表进行排序
	}
    }
    
    /**
     * 方法名： getMiddle
     * 方法描述：用于快速排序的递归算法
     * @param arry
     * @param low
     * @param high
     * @return int
     * @Author: IT_黄鹂
     * @create Date: Jan 27, 2015 9:15:41 AM
     */
    private static int getMiddle(int[] arry,int low,int high){
	int temp = arry[low];//一数组的第一个数为中轴
	while(low < high){
	  while(low < high&&arry[high]>=temp)high--;
	  arry[low] = arry[high];//将比中轴小的移到低端
	  while(low < high&&arry[low] <=temp)low++;
	  arry[high] = arry[low];//将比中轴的大的移到高端
	}
	arry[low] = temp;//将中轴位置标注
	return low;//返回中轴
    }
    
    /**
     * 方法名： _sort
     * 方法描述：归并排序：</br>
     * 	基本思想：归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干</br>
     * 		个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。</br>
     * @param arry
     * @param left
     * @param right
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 27, 2015 9:43:23 AM
     */
    private static void _sort(int[] arry,int left,int right){
	if (left < right) {
	    // 找出中间索引
	    int center = (left + right) / 2;
	    // 对左边数组进行递归
	    _sort(arry, left, center);
	    // 对右边数组进行递归
	    _sort(arry, center + 1, right);
	    // 合并
	    merge(arry, left, center, right);

	}
    }
    
    /**
     * 方法名： merge
     * 方法描述：归并排序
     * @param arry
     * @param left
     * @param center
     * @param right
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 27, 2015 9:51:47 AM
     */
    private static void merge(int[] arry, int left, int center, int right) {
	int[] tmpArr = new int[arry.length];
	int mid = center + 1;
	// third记录中间数组的索引
	int third = left;
	int tmp = left;
	while (left <= center && mid <= right) {

	    // 从两个数组中取出最小的放入中间数组
	    if (arry[left] <= arry[mid]) {
		tmpArr[third++] = arry[left++];
	    } else {
		tmpArr[third++] = arry[mid++];
	    }
	}
	// 剩余部分依次放入中间数组
	while (mid <= right) {
	    tmpArr[third++] = arry[mid++];
	}
	while (left <= center) {
	    tmpArr[third++] = arry[left++];
	}
	// 将中间数组中的内容复制回原数组
	while (tmp <= right) {
	    arry[tmp] = tmpArr[tmp++];
	}	
    }
    
    /**
     * 方法名： radixSort
     * 方法描述：基数排序：</br>
     * 	基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，</br>
     * 		依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。</br>
     * @param arry
     * @return void
     * @Author: IT_黄鹂
     * @create Date: Jan 27, 2015 9:55:47 AM
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void radixSort(int[] arry) {
	// 首先确定排序的趟数;
	int max = arry[0];
	for (int i = 1; i < arry.length; i++) {
	    if (arry[i] > max) {
		max = arry[i];
	    }
	}

	int time = 0;
	// 判断位数;
	while (max > 0) {
	    max /= 10;
	    time++;
	}

	// 建立10个队列;
	List<ArrayList> queue = new ArrayList<ArrayList>();
	for (int i = 0; i < 10; i++) {
	    ArrayList<Integer> queue1 = new ArrayList<Integer>();
	    queue.add(queue1);
	}

	// 进行time次分配和收集;
	for (int i = 0; i < time; i++) {

	    // 分配数组元素;
	    for (int j = 0; j < arry.length; j++) {
		// 得到数字的第time+1位数;
		int x = arry[j] % (int) Math.pow(10, i + 1)
			/ (int) Math.pow(10, i);
		ArrayList<Integer> queue2 = queue.get(x);
		queue2.add(arry[j]);
		queue.set(x, queue2);
	    }
	    int count = 0;// 元素计数器;
	    // 收集队列元素;
	    for (int k = 0; k < 10; k++) {
		while (queue.get(k).size() > 0) {
		    ArrayList<Integer> queue3 = queue.get(k);
		    arry[count] = queue3.get(0);
		    queue3.remove(0);
		    count++;
		}
	    }
	}
	
	//打印数组
	for(int i:arry){
	    System.out.print(i+",");
	}
    }
}
