

public class TestJVM {


    private int number = 1 ;



    static {
        num = 3;

    }
    private static int num = 2;



    private String name;


    public static void main(String[] args){
        test1();
        TestJVM testJVM = new TestJVM();
        testJVM.test2();

//        System.out.println("Test2 main begin number = " +testJVM.number);
//
//
//        System.out.println("Test2 main end number = " +testJVM.number);

    }


    public static void test1(){
        System.out.println("num test1 before ==" +num);
        num = 10;
        System.out.println("num test1 end ==" +num);
        TestJVM testJVM = new TestJVM();
        System.out.println("number test1 before ==" +testJVM.number);
        testJVM.number = 3;
        System.out.println("number test1 end ==" +testJVM.number);
//        String a = "abc";
//        testJVM.name = "123";
//        {
//            String b = "abc";
//            int n = 3;
//            System.out.println(a==b);
//            System.out.println(n);
//
//        }
//        int h =5;
//        int e = 7;

    }

    public void test2(){
        System.out.println("num test2 before ==" +num);
        num = 4;
        System.out.println("num test2 end ==" +num);

        TestJVM testJVM = new TestJVM();
        System.out.println("test2 begin number = " + testJVM.number);
        testJVM.number = 5;
        System.out.println("test2 end number = " + testJVM.number);
    }


    public void test3(){
        int i = 1;
        i=i++;
        ++i;
        int j =i + ++i * i++;
        int m = 0;
        m = i;
        System.out.println("i=" +i);
        System.out.println("j=" +j);
        System.out.println("m=" +m);

    }


}
