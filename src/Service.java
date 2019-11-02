public class Service {
    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public static boolean IPChecked (String IP){
        if(IP != null && !IP.trim().isEmpty()) {
            if (IP.matches(IPADDRESS_PATTERN)) {
                return true;
            }
        }
        return false;
    }

}
