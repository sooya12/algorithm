import java.time.*;
import java.time.format.*;
import java.util.*;

class Solution {
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }
}
