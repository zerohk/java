# 特点

1.不允许存储重复元素

2.没有索引，无带索引的方法，不能使用普通for循环

# HashSet

java.util.HashSet继承自Set接口。

## 特点

1.不允许存储重复元素

2.没有索引。可使用迭代器和for-each遍历

3.是一个无序集合，存储元素和取出元素顺序可能不一致

4。底层是一个哈希表结构，查询速度很快

## 哈希值

一个十进制的整数，由系统随机给出（就是对象的地址值，是一个逻辑地址值，是模拟出来的地址，不是实际存储的物理地址）

Object类中的hashCode方法可以获取哈希值，hashCode()方法源码：

`public native int hashCode();`

native:代表该方法调用的是本地操作系统的方法。

前面学过的toString()方法，就包括了hashCode方法的调用：

```java
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

String类重写了hashCode()方法，如果两个字符串相同时，他们返回的哈希值也相同。但并不是哈希值相同的两个字符串就相等，比方说："重地"和"通话"两个字符串的哈希值相同，但是两个字符串不想等。

```java
package space.buercheng.java.set.demo01;

public class Person extends Object{
}
```

```java
package space.buercheng.java.set.demo01;

public class TestHashCode {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.hashCode());//901506536
        System.out.println(p2.hashCode());//747464370

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode() == s2.hashCode());//true
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}

```

## 哈希表

无序，不允许重复，速度快![未命名绘图](Set%E6%8E%A5%E5%8F%A3.assets/%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.jpg)

## Set集合存储元素不重合的原理

![未命名绘图](Set%E6%8E%A5%E5%8F%A3.assets/%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE-1598045687454.jpg)

## HashSet存储自定义类型元素

给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法，建立自己的比较方式，才能保
证HashSet集合中的对象唯一。

未重写hashCode和equals方法时：

```java
package space.buercheng.java.set.demo02;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

```java
package space.buercheng.java.set.demo02;

import java.util.HashSet;

public class CustomizeSet {
    public static void main(String[] args) {
        Person p1 = new Person("冯裔婷",15);
        Person p2 = new Person("冯裔婷",15);
        Person p3 = new Person("冯裔婷",24);
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);//[Person{name='冯裔婷', age=15}, Person{name='冯裔婷', age=24}, Person{name='冯裔婷', age=15}]
    }
}

```

输出可以看到，可以存储重复元素：

![image-20200822060004790](Set%E6%8E%A5%E5%8F%A3.assets/image-20200822060004790.png)

重写hashCode和equals方法后：

```java
package space.buercheng.java.set.demo02;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

```

![image-20200822060342044](Set%E6%8E%A5%E5%8F%A3.assets/image-20200822060342044.png)

# LinkedHashSet

我们知道HashSet保证元素唯一，可是元素存放进去是没有顺序的，那么我们要保证有序，怎么办呢？

在HashSet下面有一个子类`java.util.LinkedHashSet`，它是链表（记录元素的存储顺序，保证元素有序）和哈希表（数组+链表/红黑树）组合的一个数据存储结构。

```java
package space.buercheng.java.set.demo03;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("ddf");
        set.add("abc");
        set.add("abc");
        System.out.println(set);//无序。不允许重复元素：[abc, ddf]

        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("dl;f");
        linked.add("dl;f");
        linked.add("dla;");
        System.out.println(linked);//有序，不允许重复元素：[dl;f, dla;]
    }
}

```

# 可变参数

在**JDK1.5**之后，如果我们定义一个方法需要接受多个参数，并且多个参数类型一致，我们可以对其简化成如下格式：

```
修饰符 返回值类型 方法名(参数类型... 形参名){  }
```

其实这个书写完全等价与

```
修饰符 返回值类型 方法名(参数类型[] 形参名){  }
```

只是后面这种定义，在调用时必须传递数组，而前者可以直接传递数据即可。

**JDK1.5**以后。出现了简化操作。**...** 用在参数上，称之为可变参数。

同样是代表数组，但是在调用这个带有可变参数的方法时，不用创建数组(这就是简单之处)，直接将数组中的元素作为实际参数进行传递，其实编译成的class文件，将这些元素先封装到一个数组中，在进行传递。这些动作都在编译.class文件时，自动完成了。

使用前提：当方法的参数类型已经确定，但是参数的个数不确定时使用。

原理：可变参数底层就是一个数组，根据传递参数的不同，会创建不同长度的数组，来存储这些参数，传递的参数个数，可以是0个或多个。

```java
package space.buercheng.java;

public class ChangeableVar {
    public static void main(String[] args) {
        //int sum = add();长度为0
        //int sum = add(1);长度为1
        System.out.println(add());
        System.out.println(add(1));
        System.out.println(add(1,2));
        System.out.println(add(1,2,3));
        System.out.println(add(1,2,3,4));

    }
    public static int add(int...var){
        //System.out.println(var);//底层是一个数组:[I@35bbe5e8
        //System.out.println(var.length);
        int sum = 0;
        //遍历数组
        for (int i : var) {
            sum += i;
        }
        return sum;
    }
}

```

注意事项：

1.一个方法的参数列表，只能有一个可变参数

2.如果方法的参数有多个，可变参数只能位于末尾

可变参数的终极写法：

public static void method(Object...obj){}