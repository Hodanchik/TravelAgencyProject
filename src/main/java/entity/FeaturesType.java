package entity;

import java.util.Random;

public enum FeaturesType {
    AIR_CONDIDTIONING, TV, BREAKFAST, DINNER, SAFE, KINGSIZE_BED, MINI_BAR, BALCONY, WI_FI, HAIR_DRYER;


    public static FeaturesType getRandomType() {
    Random random = new Random();
            return values()[random.nextInt(values().length)];
    }
}
