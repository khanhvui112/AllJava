package fa.training.utils;

/**
 * @author san vui
 * @create 16/10/2021 - 8:33 PM
 * @sanvankhanh@gmail.com
 */
public class ValidateSeat {

    //    check isStatus return true or false, parameter seatStatus
    public static boolean isSeatStatus(String seatStatus) {
        return "Available".equalsIgnoreCase(seatStatus) ||
                "Not Available".equalsIgnoreCase(seatStatus) ||
                "Booked".equalsIgnoreCase(seatStatus);
    }

    //    check isStatus return true or false, parameter seatType
    public static boolean isSeatType(String seatType) {
        return "VIP".equalsIgnoreCase(seatType) ||
                "Normal".equalsIgnoreCase(seatType);
    }
}
