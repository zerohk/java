# 常用方法

* java.utils.Collections`是集合工具类，用来对集合进行操作。部分方法如下：

- `public static <T> boolean addAll(Collection<T> c, T... elements)  `:往集合中添加一些元素。
- `public static void shuffle(List<?> list) 打乱顺序`:打乱集合顺序。
- `public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序。
- `public static <T> void sort(List<T> list，Comparator<? super T> )`:将集合中元素按照指定规则排序。

```java
package space.buercheng.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Methods {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //public static <T> boolean addAll(Collection<T> c, T... elements):往集合中添加多个元素
        Collections.addAll(list,"a","b","c","d");
        System.out.println(list);//[a, b, c, d]
        //public static void shuffle(List<?> list):打乱集合中元素顺序
        Collections.shuffle(list);
        System.out.println(list);//[c, d, b, a]
    }
}

```

```java
package space.buercheng.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Methods2 {
    public static void main(String[] args) {
        //将集合a按默认顺序排序
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1,7,1,5,2,4);
        System.out.println(list1);//[7, 1, 5, 2, 4]
        Collections.sort(list1);
        System.out.println(list1);//[1, 2, 4, 5, 7]

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"D","A","a","w","c","d");
        System.out.println(list2);//[D, A, a, w, c, d]
        Collections.sort(list2);
        System.out.println(list2);//[A, D, a, c, d, w]
    }
}

```

sort(List<T> list)使用前提：

被排序的集合里边存储的元素，必须实现Comparable接口，并重写接口中的compareTo方法定义排序的规则，调用方法的对象-传入的参数对象，则规则为升序排序，反之为降序排序。

```java
package space.buercheng.java.collections.custom;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
package space.buercheng.java.collections.custom;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("冯裔婷",24);
        Person p2 = new Person("沈智承",23);
        Person p3 = new Person("冯程程",100);
        ArrayList<Person> list = new ArrayList<>();
        Collections.addAll(list,p1,p2,p3);
        System.out.println(list);//[Person{name='冯裔婷', age=24}, Person{name='沈智承', age=23}, Person{name='冯程程', age=100}]

        //!  Collections.sort(list);未重写compareTo方法时会报错
    }
}

```

实现Comparable接口并重写compareTo方法后：

```java
package space.buercheng.java.collections.custom;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        //return 0;默认返回0，表示两个对象相等
        //以年龄升序排序
        return this.age - o.age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
package space.buercheng.java.collections.custom;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("冯裔婷",24);
        Person p2 = new Person("沈智承",23);
        Person p3 = new Person("冯程程",100);
        ArrayList<Person> list = new ArrayList<>();
        Collections.addAll(list,p1,p2,p3);
        System.out.println(list);//[Person{name='冯裔婷', age=24}, Person{name='沈智承', age=23}, Person{name='冯程程', age=100}]

        Collections.sort(list);//
        System.out.println(list);//[Person{name='沈智承', age=23}, Person{name='冯裔婷', age=24}, Person{name='冯程程', age=100}]
    }
}

```

`public static <T> void sort(List<T> list，Comparator<? super T> )`

Comparable和Comparator的区别：

Comparable：自己（this）和别人（参数）比较，自己需要实现Comparable接口，重写比较的规则compareTo方法；

Comparator：相当于找一个第三方，比较两个

```java
package space.buercheng.java.collections;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}

```

```java
package space.buercheng.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Compara {
    public static void main(String[] args) {
        Student s1 = new Student("s1",11);
        Student s2 = new Student("b1",13);
        Student s3 = new Student("m1",12);
        Student s4 = new Student("m2",16);
        Student s5 = new Student("v1",11);
        ArrayList<Student> list = new ArrayList<>();
        Collections.addAll(list,s1,s2,s3,s4,s5);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //以年龄升序排序
                int result = o1.getAge() - o2.getAge();
                if(result == 0){//如果年龄相同则以名字首字母排序
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list);
    }
}
```

