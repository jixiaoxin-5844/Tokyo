package com.hyt.punchapp.view.activity.main;

import java.util.Arrays;

/**
 * author : Hyt
 * time : 2021/03/20
 * version : 1.0
 */
public class aa {

    public static void main(String[] args) {
        int[] arr = {5, 21, 6, 4};
        int[] tmp = new int[arr.length];
        System.out.println("原始数据: " + Arrays.toString(arr));
        customMergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("归并排序: " + Arrays.toString(arr));
    }


    /**
     * @param a     要排序的数组
     * @param tmp   临时存储
     * @param start 开始下标
     * @param end   结束下标
     */
    public static void customMergeSort(int[] a, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 对左侧子序列进行递归排序
            customMergeSort(a, tmp, start, mid);            // a  tmp   0  1                 // a  tmp   0  0
                                                                                             // a  tmp   1  1
                                                                                             // a  tmp   0  0  1
            // 对右侧子序列进行递归排序
            customMergeSort(a, tmp, mid + 1, end);    // a  tmp   2  3                  // a  tmp   2  2
                                                                                              // a  tmp   3  3
                                                                                              // a  tmp   2  3  3
            // 合并
            customDoubleMerge(a, tmp, start, mid, end);     //a   tmp   0   1  3
        }
    }

    /**
     * @param a     要排序的数组
     * @param tmp   临时存储
     * @param left  左边下标
     * @param mid   中间下标
     * @param right 右边下标
     */                                                        // 0         1         3
    public static void customDoubleMerge(int[] a, int[] tmp, int left, int mid, int right) {
        int p1 = left;     // 0
        int p2 = mid + 1;  // 2
        int k = left;      // 0
        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }
        while (p1 <= mid)
            tmp[k++] = a[p1++];
        while (p2 <= right)
            tmp[k++] = a[p2++];
        // 复制回原素组
        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }
}
