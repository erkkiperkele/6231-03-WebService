package Data;

import java.util.stream.Collectors;

/**
 * Created by Aymeric on 2015-11-22.
 */
public class DataHelper {

    public static String toString(CustomerInfo info) {

        String newLine = "\n";
        String tab = "\t";

        String loansInfo = info.getLoans()
                .stream()
                .map(l -> l.toString())
                .collect(Collectors.joining(newLine + tab + " "));

        loansInfo = loansInfo.isEmpty() ? "No Loan" : loansInfo;

        loansInfo += newLine;

        String formattedString = String.format(
                "User: %1$s %2$s %3$s" +
                        "%4$s Account info: %5$s %3$s" +
                        "%4$s Loans info: %3$s %4$s %6$s",
                info.getFirstName(),
                info.getLastName(),
                newLine,
                tab,
                info.getAccount().getOwner().toString(),
                loansInfo
        );
        return formattedString;
    }
}
