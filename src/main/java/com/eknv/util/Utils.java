package com.eknv.util;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.MathContext;

public class Utils {

    private Utils() {
    }

    public static void swap(int[] arr, int index1, int index2) {
        int value1 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = value1;
    }

    public static Integer multiply(Integer number1, Integer number2) {

        Assert.notNull(number1, "number1");
        Assert.notNull(number2, "number2");

        return BigDecimal.valueOf(number1).multiply(BigDecimal.valueOf(number2), MathContext.DECIMAL128).intValue();
    }

    public static double divide(Integer number1, Integer number2) {

        validateDivisionInputs(number1, number2);

        return BigDecimal.valueOf(number1).divide(BigDecimal.valueOf(number2), MathContext.DECIMAL128).doubleValue();
    }

    public static double divide(Long number1, Long number2) {

        validateDivisionInputs(number1, number2);

        return BigDecimal.valueOf(number1).divide(BigDecimal.valueOf(number2), MathContext.DECIMAL128).doubleValue();
    }

    public static double divide(Double number1, Double number2) {

        validateDivisionInputs(number1, number2);

        return BigDecimal.valueOf(number1).divide(BigDecimal.valueOf(number2), MathContext.DECIMAL128).doubleValue();
    }

    private static void validateDivisionInputs(Number nominator, Number denominator) {
        Assert.notNull(nominator, "nominator");
        Assert.notNull(denominator, "denominator");
        Assert.isTrue(!denominator.equals(0), "!denominator.equals(0)");
    }

}
