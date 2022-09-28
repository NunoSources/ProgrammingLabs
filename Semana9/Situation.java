


import java.util.HashMap;

public class Situation {

    private final HashMap<String, Float> map;

    public Situation(HashMap<String, Float> map) {
        this.map = map;
    }

    public boolean existsFeature(String feature) {
        return map.containsKey(feature);
    }

    public Float getFeature(String feature) {
        return map.get(feature);
    }
}
