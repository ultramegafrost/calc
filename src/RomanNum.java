import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNum {
    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4), V("V", 5),
    VI("VI", 6), VII("VII", 7), VIII("VIII", 8), IX("IX", 9), X("X", 10),
    XL("XL", 40), L("L",50), XC("XC", 90), C("C", 100);


    private int value;
    private String key;

    RomanNum(String key, int value) {
        this.key = key;
        this.value = value;
    }
    public String getKey(){
        return key;
    }
    public int getValue() {
        return value;
    }
    public static int toInt (String key) throws Exception{
        for (RomanNum i : RomanNum.values())
            if (i.getKey().equals(key))
                return i.getValue();

        throw new Exception();
    }
    public static List<RomanNum> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNum e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
    public static String intToRoman(int number) throws Exception{
        if ((number <= 0)) {
            throw new Exception();
        }

        List<RomanNum> romanNums = RomanNum.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNums.size())) {
            RomanNum currentSymbol = romanNums.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
