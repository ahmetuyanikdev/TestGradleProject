package com.project.controller

import com.project.domain.Mem
import org.springframework.core.io.Resource
class Test {
    static void  main(String[] args){
    (1..< 3).each {
        println "Number ${it}"
    }
        int b=1
        int x
        int a = (b==2) ? 3 :b
        println('.... '+a)
        println('dsd' +x)

        List<Integer> stringList = new LinkedList<Integer>()
        stringList.add(2)
        stringList.add(4)
        stringList.add(1)
        println('size of string '+stringList.size())

        Integer min = stringList.findAll {
            it
        }.min()

        println('min list '+min)
        Test test=new Test()
        test.testAges()

        ClassLoader loader = Test.class.getClassLoader();
        System.out.println(Resource.getResource("Test.groovy"));

    }
    public void testAges(){
        Mem m1 = new Mem(age1: 1,age2: 2)
        Mem m2 = new Mem(age1: 1,age2: 2)
        Mem m3 = new Mem(age1: 0,age2: 0)
        Mem m4 = new Mem(age1: 4,age2: 0)
        List<Mem> memList = new LinkedList<Mem>()
        memList.add(m1)
        memList.add(m2)
        memList.add(m3)
        memList.add(m4)

        Mem minMem = memList.min {
            it.age1 + it.age2
        }

        println('min mem age2 ' +minMem.age2)

        def x =memList.findAll{
            it.age1 > 0
        }.age1.min()

        int temp
        if(!x){
            x=0
        }
        temp =x
        println("xx "+ x)
        println('temp '+temp)

        def z = memList.findAll{
            it.age1 > 10
        }.age1.min()

        if(!z){
            z = 0
        }

        println(z)

        //temp =x
        //println(temp)

        //println('min mem age1 diff 0 '+minAge1.age1)


    }

    class member{
        int age
        int age2
        String name
    }
}
