package view;

public class Header {

    public static String CUSTOMER = String.format("| %-14s |  %-34s |  %-15s |  %-16s |  %-18s |  %-32s  |  %-24s  |  %-17s | " +
                    "%-13s | %-10s | %-12s | %11s | %-15s |" , "customerNumber", "customerName", "contactLastName",
            "contactFirstName", "phone", "addressLine1", "addressLine2", "city", "state", "postalCode", "country", "creditLimit",
            "employeeNumber");
    public static String CUSTOMER_LINE = String.format("| %-270s|", "---------------------------------------------------------------------------------------------------------------" +
            "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    public static String EMPLOYEE = String.format("| %-14s |  %-13s |  %-13s |  %-13s |  %-35s |  %-20s  |  %-10s  |  %-10s |", "employeeNumber", "lastName", "firstName",
            "extension", "email", "jobTitle", "refersTo", "officeCode");
    public static String EMPLOYEE_LINE = String.format("| %-150s|", "---------------------------------------------------------------------------------------------------------------" +
            "------------------------------------------------");


    public static String PRODUCT = String.format("| %-14s |  %-45s |  %-18s |  %-13s |  %-30s |  %-20s  |  %-15s  |  %-10s |  %-10s |", "productCode", "productName", "productLine",
    "productScale", "productVendor", "productDescription", "quantityInStock", "buyPrice","msrp");
    public static String PRODUCT_LINE = String.format("| %-170s|", "---------------------------------------------------------------------------------------------------------------" +
            "---------------------------------------------------------------------------------------------------");

}
