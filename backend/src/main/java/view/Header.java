package view;

public class Header {

    public static String CUSTOMER = String.format("| %-14s |  %-34s |  %-15s |  %-16s |  %-18s |  %-32s  |  %-24s  |  %-17s | " +
                    "%-13s | %-10s | %-12s | %11s | %-15s |" , "customerNumber", "customerName", "contactLastName",
            "contactFirstName", "phone", "addressLine1", "addressLine2", "city", "state", "postalCode", "country", "creditLimit",
            "employeeNumber");
    public static String CUSTOMER_LINE = String.format("| %-270s|", "---------------------------------------------------------------------------------------------------------------------------" +
            "----------------------------------------------------------------------------------------------------------------------------------------------------------");


}
