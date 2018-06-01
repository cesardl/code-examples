package com.bbva.mergearray;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created on 17/06/2017.
 *
 * @author Entelgy
 */
public class Solution {

    static int[] merge(int a[], int b[]) {
        int firstIterator = 0;
        int secondIterator = 0;

        int[] result = new int[a.length + b.length];
        int index = 0;
        while (firstIterator < a.length && secondIterator < b.length) {
            if (a[index] < b[index]) {
                result[index] = a[index];

                firstIterator++;
            } else {
                result[index] = b[index];

                secondIterator++;
            }
            index++;
        }
        System.out.println(ToStringBuilder.reflectionToString(result, ToStringStyle.DEFAULT_STYLE));
        return result;
    }
}
