# 介绍&常用方法

java.util.List接口，继承自Collection接口

## 三个特点

1.有序的集合。存储元素与取出元素的顺序是一致的

2.有索引。包含了一些带索引的方法

3.允许重复元素存在。

## 常用方法

- `public void add(int index, E element)`: 将指定的元素，添加到该集合中的指定位置上。
- `public E get(int index)`:返回集合中指定位置的元素。
- `public E remove(int index)`: 移除列表中指定位置的元素, 返回的是被移除的元素。
- `public E set(int index, E element)`:用指定元素替换集合中指定位置的元素,返回值的更新前的元素。

```java
package space.buercheng.java.list.demo01;

import java.util.ArrayList;
import java.util.List;

public class TestMethods {
    public static void main(String[] args) {
        //创建一个List集合
        List<String> list = new ArrayList<>();
        //add方法添加元素
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("d");
        list.add("a");
        //打印集合
        System.out.println(list);//有序集合，允许重复元素存在：[a, b, b, d, a]
        //在指定位置插入元素
        list.add(4,"JAVA");//[a, b, b, d, JAVA, a]
        System.out.println(list);
        //使用索引获取指定索引处的元素
        System.out.println(list.get(0));//a
        System.out.println(list.get(1));//b
        //使用索引指定改变位置的值，并返回改变前的值
        System.out.println(list.set(3,"C"));//d
        //移除指定位置的元素，并返回被移除的元素
        System.out.println(list.remove(5));//a
    }
}
```

# List集合的子类

## ArrayList

`java.util.ArrayList`集合数据存储的结构是**数组结构**。**元素增删慢，查找快**，由于日常开发中使用最多的功能为查询数据、遍历数据，所以`ArrayList`是最常用的集合。

许多程序员开发时非常随意地使用ArrayList完成任何需求，并不严谨，这种用法是不提倡的。

## LinkedList

1.底层是一个链表结构，查询慢，增删快

2.里边包含了大量操作首尾元素的方法

注意:使用LinkedList集合特有的方法，不能使用多态

* `public void addFirst(E e)`:将指定元素插入此列表的开头。
* `public void addLast(E e)`:将指定元素添加到此列表的结尾。
* `public E getFirst()`:返回此列表的第一个元素。
* `public E getLast()`:返回此列表的最后一个元素。
* `public E removeFirst()`:移除并返回此列表的第一个元素。
* `public E removeLast()`:移除并返回此列表的最后一个元素。
* `public E pop()`:从此列表所表示的堆栈处弹出一个元素。
* `public void push(E e)`:将元素推入此列表所表示的堆栈。
* `public boolean isEmpty()`：如果列表不包含元素，则返回true。

LinkedList是List的子类，List中的方法LinkedList都是可以使用，这里就不做详细介绍，我们只需要了解LinkedList的特有方法即可。在开发时，LinkedList集合也可以作为堆栈，队列的结构使用。（了解即可）

```java
package space.buercheng.java.list.demo02;

import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        //创建LinkedList集合时，不能使用多态
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        System.out.println(linkedList);
        method1(linkedList);
        method2(linkedList);

    }

    private static void method1(LinkedList<String> linkedList) {
        //获取LinkedList首元素
        System.out.println(linkedList.getFirst());//a
        //获取LinkedList尾元素
        System.out.println(linkedList.getLast());//e
        //获取指定位置元素
        System.out.println(linkedList.get(2));//c
    }

    public static void method2(LinkedList<String> linkedList){
        /**
         * 以下两个方法效果一致：
         * public void addFirst(E e):将指定元素插入此列表的开头。
         * public void push(E e):将元素推入此列表所表示的堆栈。
         * 以下两个方法效果也一致：
         * public E removeFirst():删除并返回此列表的第一个元素
         * public E pop():从此列表所表示的堆栈处弹出一个元素
         * */
        /*linkedList.addFirst("www");
        System.out.println(linkedList);//[www, a, b, c, d, e]*/
        linkedList.push("www");
        System.out.println(linkedList);//[www, a, b, c, d, e]
        /*String first = linkedList.removeFirst();
        System.out.println("第一个元素是：" + first);//第一个元素是：www
        System.out.println(linkedList);//[a, b, c, d, e]*/
        String first = linkedList.pop();
        System.out.println("第一个元素是：" + first);//第一个元素是：www
        System.out.println(linkedList);//[a, b, c, d, e]
        /**
         *  public void addLast(E e):将指定元素添加到此列表的结尾。
         *  public E removeLast():删除并返回此列表的最后一个元素
         * */
        linkedList.addLast("www");
        System.out.println(linkedList);//[a, b, c, d, e, www]
        linkedList.removeLast();
        System.out.println(linkedList);//[a, b, c, d, e]
    }
}

```

