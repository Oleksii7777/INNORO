package test.java.driver;

public class DriverFactory {
    public Driver getDriver(String driverType) {
        if (driverType == null) {
            return null;
        }
        if (driverType.equalsIgnoreCase("CHROME")) {
            return new DriverChrome();

        } else if (driverType.equalsIgnoreCase("FIREFOX")) {
            return new DriverFirefox();

        }

        return null;
    }
}
