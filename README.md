# 一、JVM规范
[官方文档](https://docs.oracle.com/javase/specs/index.html)  
概述：虚拟机规范内容
* 虚拟机结构
* Java语言的编译
* class文件结构
* 类加载
* 指令集
### 1-1 虚拟机结构
（1）数据类型的规范：比如取值范围，浮点数参考的标准；  
（2）运行时数据区：pc寄存器、虚拟机栈、堆、方法区、本地方法栈、运行时常量池；  
（3）栈帧：包含局部变量表，操作数栈，指向运行时常量池的引用；  
&emsp;&emsp;  调用实例方法时，第0个局部变量存储的时实例方法所在对象的引用，所以我们在实例方法中可以使用this。  
&emsp;&emsp;  后进先出的栈，通过指令压入、弹出数据完成执行工作，时虚拟机的工作区。  
（4）虚拟机规范不强制规定对象的内部结构。  
（5）特殊方法：<init>, <clinit>,具有签名多态性的方法。  
&emsp;&emsp; 签名多态性：例如jdk1.7添加的方法句柄，MethodHandle的invoke、invokeExact方法，使Java具有了动态类型语言的特性  
&emsp;&emsp; 因为方法指令的参数时符号引用，JVM中的符号引用能够直接转换成直接引用；在编译时就确定了类型。  
（6）异常：定义触发异常的条件，抛出异常的动作，异常处理器。  
（7）指令集简介：由操作码和操作数构成，操作数栈就是去读指令执行操作。  
&emsp;&emsp;  指令分类；加载存储、算术、类型转换、对象创建与操作、操作数栈管理、控制转移、方法调用返回、抛出异常、同步。


局部变量表的存储单位是变量槽（Slot）,一个Slot占4字节；除double和long外都占1个Slot。
操作码的长度是一个字节，导致了操作码的上限是256个。
short、char、byte、boolean都是用int类型表示的。

### 1-2 Java语言编译（）
（1）抛出异常的处理
（2）finally
（3）同步

### 1-3 class文件格式
（1）ClassFile结构如下：
```
ClassFile {
 u4 magic;
 u2 minor_version;
 u2 major_version;
 u2 constant_pool_count;
 cp_info constant_pool[constant_pool_count-1];
 u2 access_flags;
 u2 this_class;
 u2 super_class;
 u2 interfaces_count;
 u2 interfaces[interfaces_count];
 u2 fields_count;
 field_info fields[fields_count];
 u2 methods_count;
 method_info methods[methods_count];
 u2 attributes_count;
 attribute_info attributes[attributes_count];
}
```
（2）描述符：描述字段或方法的类型的字符串  
（3）常量池：常量分类，截止1.8有14类，常量池最基础的是CONSTANT_Utf8，除了基本类型其他常量最终可能都是指向CONSTANT_Utf8。

```
CONSTANT_Class 7
CONSTANT_Fieldref 9
CONSTANT_Methodref 10
CONSTANT_InterfaceMethodref 11
CONSTANT_String 8
CONSTANT_Integer 3
CONSTANT_Float 4
CONSTANT_Long 5
CONSTANT_Double 6
CONSTANT_NameAndType 12
CONSTANT_Utf8 1
CONSTANT_MethodHandle 15
CONSTANT_MethodType 16
CONSTANT_InvokeDynamic 18
```
（4）字段：
（5）方法：
（6）属性：

### 1-4、类加载

# 二、JVM
[参考](https://weread.qq.com/web/reader/cf1320d071a1a78ecf19254)  
概述：
* 分区实现
* 垃圾回收（无关规范）
* 工具
* 优化（规范并未规定）
* Java内存模型（规范未限制，由JSR"Java规范提案"维护）
* 锁


方法句柄 MethodHandle，1.7提供

# 三、调优