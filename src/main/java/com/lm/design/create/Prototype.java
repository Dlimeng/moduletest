package com.lm.design.create;

import java.io.*;

/**
 * 深浅复制
 * @Author: limeng
 * @Date: 2019/4/26 22:02
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 7168894975393478983L;

    private String id;

    private SerializableObject serializableObject;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype=(Prototype)super.clone();
        return prototype;
    }

   public Object deepClone() throws IOException,ClassNotFoundException  {
       /**
        * 写入当前对象的二进制流
        */
       ByteArrayOutputStream bos = new ByteArrayOutputStream();
       ObjectOutputStream oos = new ObjectOutputStream(bos);
       oos.writeObject(this);

       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
       ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
       return objectInputStream.readObject();
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SerializableObject getSerializableObject() {
        return serializableObject;
    }

    public void setSerializableObject(SerializableObject serializableObject) {
        this.serializableObject = serializableObject;
    }
}

class SerializableObject implements Serializable{

    private static final long serialVersionUID = 2578612181492967776L;


}