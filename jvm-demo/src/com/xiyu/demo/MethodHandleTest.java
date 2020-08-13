package com.xiyu.demo;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    static class classA {
        public void println(String s){
            System.out.println("classA:"+s) ;
        }
    }

    public static void main(String [] args) throws Throwable{
        Object object = System.currentTimeMillis()%2==0? System.out : new classA() ;
        //无论 object是要那个实现类，下面的都能正确调用 到println方法
        getPrintlnMH(object).invokeExact("lisj") ;
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable{
        /**
         * MethodType表示“方法类型”，包含了方法的返回值(第一个参数）和具体的参数（第二个及其以后的参数）
         * 这里参考classA中的方法
         */
        MethodType mt = MethodType.methodType(void.class, String.class) ;
        /**
         *lookup:在指定的类中查找符合给定的方法名，有方法类型，并且符合调用权限的方法名柄。
         *这里调用的是一个虚方法，方法的第一个参数是隐式的，代表这个 方法的接收者，也就是this指向的对象，以前是放在参数列表中
         *传递的，现在提供了bindTo方法
         */
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver) ;
    }

}


