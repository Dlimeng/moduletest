package com.lm.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Classname CompareAndSwapObjectTest
 * @Description TODO
 * @Date 2020/12/30 17:03
 * @Created by limeng
 */
public class CompareAndSwapObjectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("yinwenjie");
        userPojo.setSex(11);
        userPojo.setUserId("userid");


        Unsafe unsafe = UserPojo.unsafe;

        Field sexField = UserPojo.class.getDeclaredField("sex");
        //获得sex属性的内存地址偏移量
        long sexOffset = unsafe.objectFieldOffset(sexField);
        /**
         * 比较修改值
         * 1.需要修改的对象
         * 2.要更改的属性的内存偏移量
         * 3.预期的值
         * 4.设置的新值
         */
        if(unsafe.compareAndSwapObject(userPojo,sexOffset,11,13)){
            System.out.println("更改成功!");
            System.out.println(userPojo.sex);
        }else{
            System.out.println("更改失败!");
        }


    }

   static class UserPojo{
       private String name;
       private Integer sex;
       private String userId;

       static Unsafe unsafe;

       static {
           try {
               //使用反射获取Unsafe的成员变量userPojo
               Field userPojoField = Unsafe.class.getDeclaredField("theUnsafe");
               userPojoField.setAccessible(true);
               unsafe = (Unsafe)userPojoField.get(null);
           } catch (NoSuchFieldException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public Integer getSex() {
           return sex;
       }

       public void setSex(Integer sex) {
           this.sex = sex;
       }

       public String getUserId() {
           return userId;
       }

       public void setUserId(String userId) {
           this.userId = userId;
       }

   }
}
