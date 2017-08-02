package game.bases;

/**
 * Created by SNOW on 8/1/2017.
 */
public class Mathx {

    public static double clamp(float value, float min, float max){
        if (value < min) return min;
        if (value > max) return max;

        return value;
    }

    public static boolean inRange(float value, float min, float max){
        return value >= min && value <= max;
    }
}
