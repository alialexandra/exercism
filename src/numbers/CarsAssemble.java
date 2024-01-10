package numbers;

public class CarsAssemble {

    private static final int CARS_PRODUCED_PER_HOUR = 221;
    private static final double FULL_SUCCESS_RATE = 1.0; // 100%
    private static final double REDUCED_SUCCESS_RATE_90 = 0.9; // 90%
    private static final double REDUCED_SUCCESS_RATE_80 = 0.8; // 80%
    private static final double REDUCED_SUCCESS_RATE_77 = 0.77; // 77%

    private double computeProductionRatioSuccess(int speed) {
        if (speed < 1 || speed > 10) {
            throw new IllegalArgumentException("Speed must be between 1 and 10");
        }
        if (speed <= 4) return FULL_SUCCESS_RATE;
        if (speed <= 8) return REDUCED_SUCCESS_RATE_90;
        return speed == 9 ? REDUCED_SUCCESS_RATE_80 : REDUCED_SUCCESS_RATE_77;
    }

    public double productionRatePerHour(int speed) {
        return speed * CARS_PRODUCED_PER_HOUR * computeProductionRatioSuccess(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}


class Test {
    public static void main(String[] args) {
        CarsAssemble carsAssemble = new CarsAssemble();

        System.out.println(carsAssemble.productionRatePerHour(6));
        System.out.println(carsAssemble.workingItemsPerMinute(6));
    }
}