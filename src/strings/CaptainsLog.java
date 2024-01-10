package strings;

import java.util.Random;

public class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[random.nextInt(PLANET_CLASSES.length)];
    }

    String randomShipRegistryNumber() {
        return "NCC-" + random.nextInt(1000, 9999);
    }

    double randomStardate() {
        return random.nextDouble(41000.0, 42000.0);
    }



}

class Main {
    public static void main(String[] args) {
        CaptainsLog captainsLog = new CaptainsLog(new Random());

        System.out.println(captainsLog.randomPlanetClass());
    }
}