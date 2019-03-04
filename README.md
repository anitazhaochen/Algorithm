# 算法 使用 Java 实现 及 Java 笔记

## 判断一个正整数是否是回文数
    
    algorithm.IsPalindrome
    
## 给定一个数组无序数组 arr，和一个整数aim，返回哪两个位置的数可以加出 aim 。假设一组数只有一组答案
    
    algorithm.TowSum  
    
## 给定一个链表 list。

    如果： 
        
     list = 1 调整后为 1
     
     list = 1->2 调整为 1 -> 2
     
     list = 1->2->3 调整为 1 -> 2 -> 3
    
     list = 1->2->3->4 调整为 1->3->2->4
     
     list = 1-2->3->4->5 调整为 1->3->2->4->5
     
     algorithm.LinkListApart
 
## 把一棵搜索二叉树，转化成有序的双向链表

    algorithm.BstToDoubleLinkedList
    
## 给定数组 arr 和整数 num，返回有多少个子数组满足一下情况
    
    max(arr[i ... j) - min(arr[i ... j] <= num
    
    max(arr[i ... j] 表示子数组arr[i ... j] 中的最大值，min 同理。
    
    算法复杂度为 O（N）的解法
    
## LeetCode 127 单词接龙

   [leetCode](https://leetcode.com/problems/word-ladder/)
   
   广度优先遍历，深度优先遍历
   
   algorithm.WrodLadder
    
## LeetCode 564 绝对值最近的一个回文数

   [LeetCode](https://leetcode.com/problems/find-the-closest-palindrome/)
   
   algorithm.FindTheClosestPalindrome
   
   
## 丑数

[LeetCode](https://leetcode.com/problems/ugly-number/)

algorithm.UglyNumber

## 数组中重复的数字

[Nowcoder](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

algorithm.ArrayInRepeatNum

## Semaphore 信号量（控制并发线程数）

com.enjoyms.study.CyclicBarrierDemo

## CyclicBarrier 等待线程

com.enjoyms.study.CyclicBarrierDemo

## Exchanger 线程间交换数据

com.enjoyms.study.ExchangerTest

## [Java 动态代理底层](https://enjoyms.com/2019/01/19/Java%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E6%80%BB%E7%BB%93/)

com.enjoyms.proxy.Main


## [通过函数交换两个数字的值（反射）](https://enjoyms.com/2019/03/04/Java%E5%85%B3%E4%BA%8E%E4%B8%A4%E4%B8%AA%E6%95%B0%E9%80%9A%E8%BF%87%E5%87%BD%E6%95%B0%E4%BA%A4%E6%8D%A2%E5%BC%95%E5%8F%91%E7%9A%84%E9%97%AE%E9%A2%98/)

com.enjoyms.study.SwapTwoNum

