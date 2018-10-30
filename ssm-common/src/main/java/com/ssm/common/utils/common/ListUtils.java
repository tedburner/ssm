package com.ssm.common.utils.common;

import java.util.List;

/**
 * @author: Lucifer
 * @date: 2018/10/27 18:44
 * @description:
 */
public class ListUtils {

    /**
     * 判断List是否为空
     *
     * @param list
     */
    public static boolean isEmpty(List list) {

        return list == null || list.isEmpty();
    }

    /**
     * 判断List不为空
     *
     * @param list
     */
    public static boolean isNotEmpty(List list) {

        return !isEmpty(list);
    }
}
