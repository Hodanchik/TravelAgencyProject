package entity;

import java.util.Random;

public enum TourType {
    RELAX, TRAINING, TRAVEL, HONEYMOON, WITH_CHILD, MEDICAL, RELIGIOUS, ADVENTURE, NATURE, CULTURAL;

    public static TourType getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
