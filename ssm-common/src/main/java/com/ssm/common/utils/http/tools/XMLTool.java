package com.ssm.common.utils.http.tools;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;

/**
 * @author: Lucifer
 * @date: 2018/10/29 13:52
 * @description:
 */
public class XMLTool {

    /**
     * 将对象转换成XML
     *
     * @param o
     * @return
     */
    public static String toXML(Object o) {
        XStream xstream = new XStream(new DomDriver("utf8"));
        // 识别obj类中的注解
        xstream.processAnnotations(o.getClass());
        return xstream.toXML(o);
    }

    /**
     * 从String直接转换成对象
     *
     * @param xml
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T toObject(String xml, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        @SuppressWarnings("unchecked")
        T t = (T) xstream.fromXML(xml);
        return t;
    }

    /**
     * 从inputstream直接读取对象
     *
     * @param in
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T toObject(InputStream in, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        @SuppressWarnings("unchecked")
        T t = (T) xstream.fromXML(in);
        return t;
    }
}
