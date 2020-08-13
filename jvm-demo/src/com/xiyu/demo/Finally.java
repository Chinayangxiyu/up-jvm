package com.xiyu.demo;

// finally返回
public class Finally {


    // 遇到ireturn指令，弹出栈顶元素
    public static void main(String[] args){
        Finally f = new Finally();
        System.out.println(f.m1());
        System.out.println(f.m2());
        System.out.println(f.m3());

        System.out.println(2.0d/0);
    }


    // 返回 1；
    public int m1(){
        int i;
        try {
            i = 1;
            return i;
        }finally {
            i = 3;
        }
    }

    // 返回3
    public int m2(){
        int i;
        try {
            i = 1;
        }finally {
            i = 3;
        }

        return i;
    }

    // 返回4
    public int m3(){
        int i;
        try {
            i = 1;
            return i;
        }finally {
            return 4;
        }
    }
}
