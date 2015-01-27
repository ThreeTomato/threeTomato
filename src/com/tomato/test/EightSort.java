package com.tomato.test;

import java.util.ArrayList;
import java.util.List;

/*
 * java ����Ա���������İ��������㷨��
 * �ڲ�����ֻʹ���ڴ棩��1.�������򣺢�ֱ�Ӳ�������  ��ϣ������
 * 	2.ѡ�����򣺢ټ�ѡ������    ��������
 * 	3.�������򣺢�ð������  �ڿ�������
 * 	4.�鲢����
 * 	5.��������
 * �ⲿ�����ڴ�������ʹ�ã���
 * 
*/
public class EightSort {

    public static void main(String[] args) {
	int[] arry = {12,2,12,33,21,344,11,333,55,61,46,18,3,1,9,2344};
	//����ֱ�Ӳ�������
	insertSort(arry);
	System.out.println();
	//����ϣ������
	shellSort(arry);
	System.out.println();
	//���Լ�ѡ������
	selectSort(arry);
	System.out.println();
	//����ð������
	bubbleSort(arry);
	System.out.println();
	//���Ի�������
	radixSort(arry);
	//���Կ�������
	quickSort(arry, 0, arry.length-1);
	//���Թ鲢����
	_sort(arry, 0, arry.length-1);
	//���Զ�����
	heapSort(arry);
	//��ӡ����
	for(int i:arry)System.out.print(i+",");

    }
    
    /**
     * �������� insertSort
     * �������������������е�ֱ�Ӳ�������
     *	����˼�룺
     *		��Ҫ�����һ�����У�����ǰ��ģ�n-1��[n>=2]�Ѿ����ź�˳��ģ�������Ҫ�ѵ�n������
     *		�嵽ǰ����������У�ʹ����n����Ҳ���ź���ġ���˷���ֱ���ź����е�˳��
     * @param arry
     * @return void
     * @Author: IT_���
     * @create Date: Jan 26, 2015 10:33:33 AM
     */
    private static void insertSort(int[] arry){
	int temp = 0;
	for(int i = 1;i <arry.length;i++){
	    int j = i-1;
	    temp = arry[i];
	    for(;j>=0&&temp<arry[j];j--){//������temp�������������һ����λ
		arry[j+1] = arry[j];
	    }
	    arry[j+1] = temp;
	}
	for(int i:arry){
	    System.out.print(i+"��");	    
	}
    }
    
    /**
     * �������� shellSort
     * ����������ϣ��������С�������򣩣����������һ��</p>
     * 	����˼�룺���㷨���Ƚ���Ҫ������㷨����ĳ������d��n/2��nΪҪ����ĸ������ֳ������飬ÿһ��ļ�¼�±����d��</p>
     * 		��ÿһ���ȫ��Ԫ�ؽ���ֱ�Ӳ�������Ȼ�����ý�С��������d/2�����з��飬����ÿ��С���н���ֱ�Ӳ���</p>
     * 		���򣬵���С����Ϊ1ʱ������ֱ����������������������ˡ�</p>
     * @param arry
     * @return void
     * @Author: IT_���
     * @create Date: Jan 26, 2015 1:27:49 PM
     */
    private static void shellSort(int[] arry){
	double d1 = arry.length;
	int temp = 0;
	while(true){
	    d1 = Math.ceil(d1/2);
	    int d = (int) d1;
	    //����Ҫ��������鰴������d����
	    for(int i = 0;i < d;i++){
		//start����������һ��ֱ�Ӳ�������
		for(int z = i+d;z <arry.length;z+=d){
		    int j = z - d;
		    temp = arry[z];
		    for(;j>=0&&temp<arry[j];j-=d){
			arry[j+d] = arry[j];
		    }
		    arry[j+d] = temp;
		}
		//endֱ�Ӳ����������
	    }
	    if(d==1) break;
	}
	for(int i:arry){
	    System.out.print(i+"��");	    
	}
    }
    
    /**
     * �������� selectSort
     * ������������ѡ��������ѡ�������һ�֡�</p>
     * 	����˼�룺��������Ҫ�����������ѡ�����С���Ǹ���Ȼ��͵�һ��λ�õ������е���λ�ã�</p>
     * 		Ȼ����ʣ�µ���ѡ�����µ����֣�Ȼ������ڶ������ֽ���λ�õ��������ѭ��</p>
     * 		ֱ�������ڶ��������뵹����һ�����ֵ���λ��Ϊֹ��</p>
     * @param arry
     * @return void
     * @Author: IT_���
     * @create Date: Jan 26, 2015 2:38:14 PM
     */
    private static void selectSort(int[] arry){
	int pos = 0;//������¼��С����λ�õ�
	for(int i = 0;i < arry.length;i++){
	  int j = i+1;
	  pos = i;
	  int temp = arry[i];
	  //��ʣ�µ��������ҳ���С������
	  for(;j<arry.length;j++){
	      if(arry[j] < temp){
		  temp = arry[j];
		  pos = j;
	      }
	  }
	  //�ҳ�����С�������i��λ�õ���
	  arry[pos] = arry[i];
	  arry[i] = temp;
	}
	//��ӡ�ź��������
	for(int i:arry){
	    System.out.print(i+"��");	    
	}	
    }
    /**
     * �������� heapSort
     * ������������������һ������ѡ�������һ�֣�Ҳ�Ƕ�ֱ��ѡ�������һ�ָĽ���</p>
     * 	����˼�룺
     * @param arry
     * @return void
     * @Author: IT_���
     * @create Date: Jan 26, 2015 3:03:49 PM
     */
    private static void heapSort(int[] arry){
	int arrayLength = arry.length;
	// ѭ������
	for (int i = 0; i < arrayLength - 1; i++) {
	    // ����
	    buildMaxHeap(arry, arrayLength - 1 - i);
	    // �����Ѷ������һ��Ԫ��
	    swap(arry, 0, arrayLength - 1 - i);
	}
    }
    
    /**
     * �������� swap
     * �����������������Ӷ����߳��������
     * @param arry
     * @param i
     * @param j
     * @return void
     * @Author: IT_���
     * @create Date: Jan 27, 2015 10:50:56 AM
     */
    private static void swap(int[] arry, int i, int j) {
	int tmp = arry[i];
	arry[i] = arry[j];
	arry[j] = tmp;
    }

    /**
     * �������� buildMaxHeap
     * ������������arry�����0��lastIndex���󶥶�
     * @param arry
     * @param lastIndex
     * @return void
     * @Author: IT_���
     * @create Date: Jan 27, 2015 10:51:18 AM
     */
    private static void buildMaxHeap(int[] arry, int lastIndex) {
	// TODO Auto-generated method stub
	// ��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
	for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
	    // k���������жϵĽڵ�
	    int k = i;
	    // �����ǰk�ڵ���ӽڵ����
	    while (k * 2 + 1 <= lastIndex) {
		// k�ڵ�����ӽڵ������
		int biggerIndex = 2 * k + 1;
		// ���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����
		if (biggerIndex < lastIndex) {
		    // �������ӽڵ��ֵ�ϴ�
		    if (arry[biggerIndex] < arry[biggerIndex + 1]) {
			// biggerIndex���Ǽ�¼�ϴ��ӽڵ������
			biggerIndex++;
		    }
		}
		// ���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
		if (arry[k] < arry[biggerIndex]) {
		    // ��������
		    swap(arry, k, biggerIndex);
		    // ��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
		    k = biggerIndex;
		} else {
		    break;
		}
	    }
	}
    }

    
    /**
     * �������� bubbleSort
     * ����������ð������</p>
     * 	����˼�룺��Ҫ�����һ�����У��Ե�ǰ��δ�ź���ķ�Χ�ڵ�ȫ���������϶��¶����ڵ����������ν��бȽϺ͵�����</p>
     * 		�ýϴ�������³�����С������ð������ÿ�������ڵ����ȽϺ������ǵ�����������Ҫ���෴ʱ���ͽ����ǻ�����</p>
     * @param arry
     * @return void
     * @Author: IT_���
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
	//��ӡ�ź��������
	for (int i : arry) {
	    System.out.print(i + "��");
	}
    }
    
    /**
     * �������� quickSort
     * ������������������</br>
     * 	����˼�룺ѡ��һ����׼Ԫ��,ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��,ͨ��һ��ɨ�裬���������зֳ�������,</br>
     * 		һ���ֱȻ�׼Ԫ��С,һ���ִ��ڵ��ڻ�׼Ԫ��,��ʱ��׼Ԫ�������ź�������ȷλ��,Ȼ������</br>
     * 		ͬ���ķ����ݹ�����򻮷ֵ������֡�
     * @param arry
     * @param low ��Ϊ�յ�������С���±�(0)
     * @param high ���鳤��
     * @return void
     * @Author: IT_���
     * @create Date: Jan 26, 2015 4:41:23 PM
     */
    private static void quickSort(int[] arry,int low,int high){
	//arry������벻Ϊ�գ����Խ��в�Ϊ���ж�
	if(low < high){
	    int middle = getMiddle(arry, low, high);//������һ��Ϊ��
	    quickSort(arry, low, middle-1);//�Ե��ֱ��������
	    quickSort(arry, middle+1, high);//�Ը��ֱ��������
	}
    }
    
    /**
     * �������� getMiddle
     * �������������ڿ�������ĵݹ��㷨
     * @param arry
     * @param low
     * @param high
     * @return int
     * @Author: IT_���
     * @create Date: Jan 27, 2015 9:15:41 AM
     */
    private static int getMiddle(int[] arry,int low,int high){
	int temp = arry[low];//һ����ĵ�һ����Ϊ����
	while(low < high){
	  while(low < high&&arry[high]>=temp)high--;
	  arry[low] = arry[high];//��������С���Ƶ��Ͷ�
	  while(low < high&&arry[low] <=temp)low++;
	  arry[high] = arry[low];//��������Ĵ���Ƶ��߶�
	}
	arry[low] = temp;//������λ�ñ�ע
	return low;//��������
    }
    
    /**
     * �������� _sort
     * �����������鲢����</br>
     * 	����˼�룺�鲢��Merge�������ǽ����������������ϣ������ϲ���һ���µ���������Ѵ��������з�Ϊ����</br>
     * 		�������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ�����������С�</br>
     * @param arry
     * @param left
     * @param right
     * @return void
     * @Author: IT_���
     * @create Date: Jan 27, 2015 9:43:23 AM
     */
    private static void _sort(int[] arry,int left,int right){
	if (left < right) {
	    // �ҳ��м�����
	    int center = (left + right) / 2;
	    // �����������еݹ�
	    _sort(arry, left, center);
	    // ���ұ�������еݹ�
	    _sort(arry, center + 1, right);
	    // �ϲ�
	    merge(arry, left, center, right);

	}
    }
    
    /**
     * �������� merge
     * �����������鲢����
     * @param arry
     * @param left
     * @param center
     * @param right
     * @return void
     * @Author: IT_���
     * @create Date: Jan 27, 2015 9:51:47 AM
     */
    private static void merge(int[] arry, int left, int center, int right) {
	int[] tmpArr = new int[arry.length];
	int mid = center + 1;
	// third��¼�м����������
	int third = left;
	int tmp = left;
	while (left <= center && mid <= right) {

	    // ������������ȡ����С�ķ����м�����
	    if (arry[left] <= arry[mid]) {
		tmpArr[third++] = arry[left++];
	    } else {
		tmpArr[third++] = arry[mid++];
	    }
	}
	// ʣ�ಿ�����η����м�����
	while (mid <= right) {
	    tmpArr[third++] = arry[mid++];
	}
	while (left <= center) {
	    tmpArr[third++] = arry[left++];
	}
	// ���м������е����ݸ��ƻ�ԭ����
	while (tmp <= right) {
	    arry[tmp] = tmpArr[tmp++];
	}	
    }
    
    /**
     * �������� radixSort
     * ������������������</br>
     * 	����˼�룺�����д��Ƚ���ֵ����������ͳһΪͬ������λ���ȣ���λ�϶̵���ǰ�油�㡣Ȼ�󣬴����λ��ʼ��</br>
     * 		���ν���һ���������������λ����һֱ�����λ��������Ժ�,���оͱ��һ���������С�</br>
     * @param arry
     * @return void
     * @Author: IT_���
     * @create Date: Jan 27, 2015 9:55:47 AM
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void radixSort(int[] arry) {
	// ����ȷ�����������;
	int max = arry[0];
	for (int i = 1; i < arry.length; i++) {
	    if (arry[i] > max) {
		max = arry[i];
	    }
	}

	int time = 0;
	// �ж�λ��;
	while (max > 0) {
	    max /= 10;
	    time++;
	}

	// ����10������;
	List<ArrayList> queue = new ArrayList<ArrayList>();
	for (int i = 0; i < 10; i++) {
	    ArrayList<Integer> queue1 = new ArrayList<Integer>();
	    queue.add(queue1);
	}

	// ����time�η�����ռ�;
	for (int i = 0; i < time; i++) {

	    // ��������Ԫ��;
	    for (int j = 0; j < arry.length; j++) {
		// �õ����ֵĵ�time+1λ��;
		int x = arry[j] % (int) Math.pow(10, i + 1)
			/ (int) Math.pow(10, i);
		ArrayList<Integer> queue2 = queue.get(x);
		queue2.add(arry[j]);
		queue.set(x, queue2);
	    }
	    int count = 0;// Ԫ�ؼ�����;
	    // �ռ�����Ԫ��;
	    for (int k = 0; k < 10; k++) {
		while (queue.get(k).size() > 0) {
		    ArrayList<Integer> queue3 = queue.get(k);
		    arry[count] = queue3.get(0);
		    queue3.remove(0);
		    count++;
		}
	    }
	}
	
	//��ӡ����
	for(int i:arry){
	    System.out.print(i+",");
	}
    }
}
