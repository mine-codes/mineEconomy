package pl.minecodes.mineeconomy.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundUtil {
    public static double round(double target, int places) {
        if(places < 0) throw new IllegalArgumentException();

        BigDecimal bigDecimal = BigDecimal.valueOf(target);

        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
