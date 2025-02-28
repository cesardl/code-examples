package com.bbva;

import org.junit.Test;

/**
 * Created for examples on 10/07/2021.
 *
 * @author Cesardl
 */
public class SolutionTest {

    @Test
    public void sorterTest() {
        GenericClass<StringBuilder> gc = new GenericClass<>(new StringBuilder("hola Mundo..."));
        System.out.println(gc.getToString());;

//        String[] actuals = {
//                "-100",
//                "50",
//                "0",
//                "56.6",
//                "90",
//                "0.12",
//                ".12",
//                "02.34",
//                "000.000"
//        };
//
//        Solution.sorter(actuals);
//
//        String[] expected = {
//                "90",
//                "56.6",
//                "50",
//                "02.34",
//                "0.12",
//                ".12",
//                "0",
//                "000.000",
//                "-100"
//        };
//        assertArrayEquals(expected, actuals);
    }

    public static class GenericClass<T extends Object> {
        private T object;

        public GenericClass(T object) {
            this.object = object;
        }

        public String getToString() {
            return object.toString();
        }
    }
}
