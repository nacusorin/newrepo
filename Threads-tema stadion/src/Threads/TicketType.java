package Threads;
/**
 * @author Nacu Sorin-Constantin
 * @version 1.0 beta
 * @since 2019-04-09
 */
import java.util.Random;



public enum TicketType {


    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;


    private static final Random RANDOM = new Random();
    private static final TicketType[] VALUES = values();
    private static final int SIZE = VALUES.length;


    public static TicketType getRandomTicket()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}