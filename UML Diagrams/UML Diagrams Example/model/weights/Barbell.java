package model.weights;

import java.util.ArrayList;
import java.util.List;

public class Barbell extends Weight {

    /**
     * Pounds of the bar.
     */
    private static final int BAR_POUNDS = 45;
    /**
     * Pounds of a 45-pound plate.
     */
    private static final int PLATE_POUNDS_45 = 45;
    /**
     * Pounds of a 25-pound plate.
     */
    private static final int PLATE_POUNDS_25 = 25;
    /**
     * Pounds of a 10-pound plate.
     */
    private static final int PLATE_POUNDS_10 = 10;
    /**
     * Pounds of a 5-pound plate.
     */
    private static final int PLATE_POUNDS_5 = 5;
    /**
     * Pounds of a 1-pound plate.
     */
    private static final int PLATE_POUNDS_1 = 1;

    /**
     * Constructor with parameter.
     * @param pounds weight of the barbell
     */
    public Barbell(int pounds) {
        // We assume that pounds is greater than or equal to 45.
        super(pounds);
    }

    @Override
    public int getWeight() {
        return pounds + BAR_POUNDS;
    }

    /**
     * Returns a list of plates of this barbell.
     * @return list of plates
     */
    public List<Plate> getPlate() {
        int remainingPounds = pounds;
        List<Plate> plates = new ArrayList<>();
        while (remainingPounds > 0) {
            if (remainingPounds >= (2 * PLATE_POUNDS_45)) {
                remainingPounds = addPlatePair(plates, PLATE_POUNDS_45, remainingPounds);
            } else if (remainingPounds >= (2 * PLATE_POUNDS_25)) {
                remainingPounds = addPlatePair(plates, PLATE_POUNDS_25, remainingPounds);
            } else if (remainingPounds >= (2 * PLATE_POUNDS_10)) {
                remainingPounds = addPlatePair(plates, PLATE_POUNDS_10, remainingPounds);
            } else if (remainingPounds >= (2 * PLATE_POUNDS_5)) {
                remainingPounds = addPlatePair(plates, PLATE_POUNDS_5, remainingPounds);
            } else {
                while (remainingPounds > 0) {
                    plates.add(new Plate(PLATE_POUNDS_1));
                    --remainingPounds;
                }
            }
        }
        return plates;
    }

    /**
     * 
     * @param plates
     * @param platePounds
     * @param remainingPounds
     * @return
     */
    private int addPlatePair(List<Plate> plates, int platePounds, int remainingPounds) {
        plates.add(new Plate(platePounds));
        plates.add(new Plate(platePounds));
        return remainingPounds - 2 * platePounds;
    }

}
