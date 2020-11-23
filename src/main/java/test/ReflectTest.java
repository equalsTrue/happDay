package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.*;

public class ReflectTest {

        public static  void test1(){
            try {
                Test tt = new Test();
                Class<? extends Test> tc = tt.getClass();
                Class<? extends Test> tv = Test.class;
                Class<?> test = Class.forName("test.Test");
                Field[] tf = test.getDeclaredFields();
                System.out.println(JSON.toJSONString(tf));
                Method testM = test.getDeclaredMethod("setDeclaredMethod",String.class);
                testM.setAccessible(true);
                Object testMethod = test.newInstance();
                testM.invoke(testMethod,"David");
                Method testP = test.getMethod("getPublicMethod",String.class);
                testP.invoke(testMethod,"Jack");
                Object objectTest =test.newInstance();
                Test t = (Test) objectTest;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws Exception {
//            test1();
//            File file = new File("");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            InputStreamReader inReader = new InputStreamReader(fileInputStream);
//            BufferedReader brReader = new BufferedReader(inReader);
//            brReader.readLine();
//            OutputStream outputStream = new FileOutputStream("");
//            outputStream = System.out;
//            OutputStreamWriter outwriter = new OutputStreamWriter(outputStream);
//            BufferedWriter bfwriter = new BufferedWriter(outwriter);
//            String test = "test";
//            bfwriter.write(test);
//            bfwriter.flush();
//            bfwriter.close();
//              Food food = new Apple("Apple","1");
//              food.printId("222");
//              food.test();
//              Class<?> fod= Class.forName("test.Food");
//              Method[] methods = fod.getDeclaredMethods();
//              Method method1 = fod.getDeclaredMethod("printId", String.class);
//              method1.setAccessible(true);
//              Object o = fod.newInstance();
//              method1.invoke(o,"1");
//            for(Method method:methods){
//                System.out.println("Food Method status: " + method.getModifiers() + ",Food Method name:" + method.getName() + ",param count: " + method.getParameterCount());
//                Class[] params = method.getParameterTypes();
//                for(Class param:params){
//                    System.out.println("Food Method name:" + method.getName() + ", param type:" + param );
//                }
//            }

                Class<?> child = Class.forName("test.Apple");
                Class<?> father = child.getSuperclass();
                Method fatherPrivateMethod = father.getDeclaredMethod("printName",String.class,int.class);
                fatherPrivateMethod.setAccessible(true);
                Object fatherObject = father.newInstance();
                fatherPrivateMethod.invoke(fatherObject,"child",777);
                List<String> list = new ArrayList<>();
                JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
                JSONArray array1 = new JSONArray();
                List<String> list1 = JSONObject.parseArray(array1.toJSONString(),String.class);
                Map<String,String> map = new HashMap<>(1);
                Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
                List<String> testList = new ArrayList<>();
                Iterator<String> iteratorList = testList.iterator();
                iteratorList.remove();
                list.retainAll(new ArrayList<>());
                list.addAll(new ArrayList<>());
                list.removeAll(new ArrayList<>());

        }

}
