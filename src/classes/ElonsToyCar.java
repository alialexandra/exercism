package classes;



class Car {

}



public class ElonsToyCar {

    private int distance;
    private int battery;

    public ElonsToyCar() {
        this.distance = 0;
        this.battery = 100;
    }

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", distance);
    }

    public String batteryDisplay() {
        if (battery == 0) return "Battery empty";
        return String.format("Battery at %d%%", battery);
    }

    public void drive() {
        if (battery != 0 ) {
            this.battery--;
            this.distance += 20;
        }

    }
}
