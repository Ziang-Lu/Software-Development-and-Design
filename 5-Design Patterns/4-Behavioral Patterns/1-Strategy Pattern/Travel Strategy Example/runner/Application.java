package runner;

import strategy.AutoTravelStrategy;
import strategy.BusTravelStrategy;
import strategy.TaxiTravelStrategy;
import strategy.TrainTravelStrategy;

import java.util.Scanner;

/**
 * Application that actually uses Strategy Pattern to provide multiple
 * algorithms, a family of algorithms, to perform a specific task (solve a
 * specific problem), so that the client can select which actual implementation
 * to use at runtime.
 *
 * @author Ziang Lu
 */
public class Application {

    /**
     * Main driver.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        System.out.println("Please enter Travel Type: 'Auto' or 'Bus' or 'Taxi' or 'Train' ");
        Scanner scanner = new Scanner(System.in);
        String travelType = scanner.next();
        System.out.println("Travel Type is " + travelType);

        TravelContext travelContext = new TravelContext();
        if (travelType.equalsIgnoreCase("Auto")) {
            travelContext.setTravelStrategy(new AutoTravelStrategy());
        } else if (travelType.equalsIgnoreCase("Bus")) {
            travelContext.setTravelStrategy(new BusTravelStrategy());
        } else if (travelType.equalsIgnoreCase("Taxi")) {
            travelContext.setTravelStrategy(new TaxiTravelStrategy());
        } else if (travelType.equalsIgnoreCase("Train")) {
            travelContext.setTravelStrategy(new TrainTravelStrategy());
        }
        travelContext.useStrategyToGotoAirport();
    }

}
