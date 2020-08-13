package com.xiyu.demo;

public class Memory {


    // 局部变量表，变量槽复用
    public void testMemory(){
        // 方法结束以前，e1,e2都会被局部变量表引用，无法回收
        Employee e1 = new Employee();
        Employee e2 = new Employee();


        // 循环体里面的变量e,只会占一个变量槽，所以可以回收
        for(int i=0; i < 2; i++){
            Employee e = new Employee();
        }
    }
}

class Employee{

}
