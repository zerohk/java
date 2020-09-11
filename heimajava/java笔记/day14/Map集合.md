 

# Map集合的特点

1.Map集合是一个双列集合，一个元素包含两个值，一个key，一个value

2.Map集合中的元素，key和value的数据类型可以相同，也可以不同。

3.Map集合中的元素，key是不允许重复的，value是可以重复的

4，Map集合中，key和value是一一对应的关系。

# Map常用子类

## java.util.HashMap<k,v>  implements Map<k,v>

特点：1.HashMap集合底层是哈希表，查询的速度非常快

   							jdk1.8之前，数组+单向链表

​								jdk1.8之后：数组+单向链表/红黑树（链表长度超过8）

​            2.HashMap是一个无序的集合，存储元素和取出元素顺序可能不同

## java.util.LinkedHashMap<k,v> extends HashMap:

​					1.LinkedHashMap集合底层是哈希表+链表（保证迭代的顺序）

​					2.LinkedHashMap集合是一个有序集合，存储元素和取出元素顺序相同。					 

# Map集合常用的方法

 `public V put(K key,V value):`把指定的键和指定的值存入Map中。如果没有存在此key，则添加并返回null；如果存在此key，则用传入的value替换掉原来的value，并返回原来的value。

`public V get(Object key)`:获取指定key的value值，如果存在，则返回该value值，如果不存在，则返回null

`public V remove(Object key)`：移除指定key值的value，并返回，如果key不存在，则返回null

`boolean containsKey(Object key)  ` 判断集合中是否包含指定的键。

```java
package Space.buercheng.java.map.demo01;

import java.util.HashMap;
import java.util.Map;

public class Methods01 {
    public static void main(String[] args) {
        /** public V put(K key,V value):
         *         将键值对存入Map集合中；如果存入的键不存在于集合中，将键值存入，并返回null;如果Map中存在对应的键，则把新传入的value
         *         替换掉原来的value，并返回原来的value
         * */

        Map<String,Integer> map = new HashMap<>();
        Integer i = map.put("冯裔婷", 18);
        System.out.println(i);//null
        System.out.println(map);//{冯裔婷=18}
        map.put("沈智承",19);
        map.put("冯程程",100);
        map.put("我爱你",520);
        map.put("徐闻",111);
        System.out.println(map);//{冯裔婷=18, 徐闻=111, 沈智承=19, 我爱你=520}无序集合
        /**
         * public V remove(K key):
         *          移除指定键的value，并返回；
         *          如果该键不存在，则返回null
         * */
        Integer i1 = map.remove("许文强");
        System.out.println(i1);//null\
        Integer i2 = map.remove("冯程程");
        System.out.println(i2);//100
        System.out.println(map);

        /**
         * public V get(K key)
         *          获取指定key的value；如果不存在，返回null
         *
         * */
        Integer i3 = map.get("冯程程");
        System.out.println(i3);//null
        Integer i4 = map.get("冯裔婷");
        System.out.println(i4);//18\


        /**
         * boolean containsKey(Object key):
         *          是否包含指定key
         * */

        boolean b1 = map.containsKey("冯裔婷");
        System.out.println(b1);//true
        boolean b2 = map.containsKey("冯程程");
        System.out.println(b2);//false
    }
}

```

# Map集合遍历

1.通过键找值的方式：

​			使用Map集合中的方法：

​					Set<K> keySet() 返回此映射中包含的键的Set视图。

​					实现步骤：

​						1.使用Map集合中的方法keySet，把Map集合的所有key取出来，存到一个Set集合中；

​						2.遍历Set集合，获取Map集合中的每一个key

​						3.调用Map集合中的get(key)方法，通过key找到value

```java
package Space.buercheng.java.map.demo02;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Traverse {
    public static void main(String[] args) {
        /**
         * 遍历Map集合的第一种方式，通过键找值的方式：
         *      1.通过Map集合中提供的方法Set<K> keySet()，得到存储Map集合中所有key的一个Set集合；
         *      2.通过遍历Set集合，获取Map集合中所有的key
         *      3.通过Map集合的get(K key)方法，获取所有的value
         *
         * */

        Map<Integer,String> map = Map.of(1 ,"沈智承",
                                         2,"冯裔婷",
                                         3,"冯程程");
        System.out.println(map);//{3=冯程程, 2=冯裔婷, 1=沈智承}
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
            /**
             3=冯程程
             2=冯裔婷
             1=沈智承
             */
        }
    }
}

```

2.通过Entry接口获取

![未命名绘图](Map%E9%9B%86%E5%90%88.assets/%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE-1598094171685.jpg)

# HashMap存储自定义类型键值

Map集合必须保证key是唯一的：那么作为key的类型，必须重写hashCode方法和equals方法，保证key唯一。

### 以String作为key，自定义的Person作为value

```java
package Space.buercheng.java.map.demo03;

public class Person {
    private String name;
    private int age;

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

    public Person(String name, int age) {
        this.name = name;
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
package Space.buercheng.java.map.demo03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Customize {
    public static void main(String[] args) {
        /**
         * 用Map集合存储自定义数据累型，因为必须保证key唯一，所以作为key的类型必须重写hashCode方法和equals方法
         * */
        /**
         * 定义一个Person类（未重写hashCode方法和equals方法），然后创建一个HashMap，用String类型的元素作为key，Person类型的元素作为value
         * 因为String类已经重写了hashCode方法和equals方法，所以可以直接使用
         * */
        HashMap<String,Person> map = new HashMap<>();
        map.put("北京",new Person("小明",18));
        map.put("上海",new Person("小红",19));
        map.put("上海",new Person("小强",18));
        map.put("广州",new Person("小东",18));
        map.put("天津",new Person("小东",18));
        Set<Map.Entry<String, Person>> entries = map.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            String key = entry.getKey();
            Person value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        /**
         * 上海=Person{name='小强', age=18}
         * 广州=Person{name='小东', age=18}
         * 天津=Person{name='小东', age=18}
         * 北京=Person{name='小明', age=18}
         * 因为必须保证key唯一，所以后面的put语句会覆盖前面的put语句，因此只有一个上海的语句存在
         * value可以重复，因此可以发现出现了两个小东
         * */
    }
}

```

### 以自定义Person为key，String作为value

```java
package Space.buercheng.java.map.demo04;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

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

    public Person(String name, int age) {
        this.name = name;
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

```java
package Space.buercheng.java.map.demo04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Customize02 {
    /**
     * 以Person类作为key，String作为value，重写了Person的hashCode方法和equals方法
     *同名同年龄视为同一个人
     * */
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person("小明",19),"北京");
        map.put(new Person("小明",19),"上海");
        map.put(new Person("小明",18),"北京");
        map.put(new Person("小东",19),"北京");

        Set<Map.Entry<Person, String>> entries = map.entrySet();
        for (Map.Entry<Person, String> entry : entries) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        /**
         * Person{name='小明', age=19}=上海
         * Person{name='小明', age=18}=北京
         * Person{name='小东', age=19}=北京
         * */
    }
}

```

# LinkedHashMap

java.util.LinkedHashMap<K,V>extends HashMap<K,V>

Map接口的哈希表和链表实现，具有可预知的迭代顺序

底层原理：哈希表+链表

# Hashtable

java.util.Hashtable<K,V> implements Map<K,V>

HashMap底层是一个哈希表，是一个线程不安全的集合，是多线程的，速度快。可以存储null

Hashtable底层是一个哈希表，是一个线程安全的集合，是单线程的，速度慢。不能存储null

Hashtable和Vector集合一样，在jdk1.2版本之后被更先进的集合取代了（Ha

Hashtable的子类Properties依然活跃在历史舞台，

Properties集合是一个唯一和IO流结合的集合

```java
package Space.buercheng.java.map.demo05;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashtable {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("a",null);
        map.put(null,"b");
        map.put(null,null);
        System.out.println(map);//{null=null, a=null}

        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("a",null);
        hashtable.put(null,"b");
        hashtable.put(null,null);
        System.out.println(hashtable);//报NEP：NullPointerException
    }
}

```

# 计算一个字符串中每个字母出现的次数

分析：

1.利用Scanner获取用户输入的字符串

2.创建一个Map集合，key为字符Character类型 -----存储字母，value为Integer类型---统计字母出现的次数

3.遍历字符串，获取每一个字符

4.使用获取到的每一个字符，去Map集合中判断key是否存在

​					key存在，通过key获取value，value++，然后再put（key，value)

​					key不存在，put（key，1）)

5.遍历Map集合

```java
package Space.buercheng.java.map.demo06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountChar {
    public static void main(String[] args) {
        //获取用户输入
        System.out.println("请输入需要统计的字符串：");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //创建一个Map集合
        HashMap<Character, Integer> count = new HashMap<>();
        //获取字符串中每一个字符
        //1.利用toCharArray将字符串转为char数组，遍历数组
        //2.利用length()方法和charAt()方法获取每一个字符
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (count.containsKey(chars[i])) {
                Integer value = count.get(chars[i]);
                value++;
                count.put(chars[i], value);
            } else {
                count.put(chars[i], 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = count.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println("在字符串" + input + "中" + entry.getKey() + "出现的次数是：" + entry.getValue());
        }
    }
}

```

