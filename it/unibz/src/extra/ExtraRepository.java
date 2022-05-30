package it.unibz.src.extra;

import java.util.List;

public class ExtraRepository {

    private static List<Extra> extras;
    public static void init(List<Extra> inputExtras) {
        extras = inputExtras;
    }

    public static Extra getExtraByID(int extraID) {
        isRepoInitialized();

        return extras.stream().filter(extra -> extra.getCode() == extraID).findAny()
                .orElseThrow(() -> new RuntimeException("Invalid ID for extra"));
    }

    public static Double getPriceFromExtraID(Integer extraID) {
        isRepoInitialized();
        return extras.stream().filter(extra -> extra.getCode() == extraID).map(Extra::getUnitaryPrice).findAny()
                .orElseThrow(() -> new RuntimeException("Invalid ID for extra"));
    }

    private static void isRepoInitialized() {
        if(extras == null || extras.isEmpty())
            throw new RuntimeException("Initialize the Repository first");
    }

    public static String getExtraDetails(Integer extraID) {
        Extra extra = ExtraRepository.getExtraByID(extraID);
        return extra.getExtraDetails();
    }
}
