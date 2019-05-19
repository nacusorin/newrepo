package Threads;
/**
 * @author Nacu Sorin-Constantin
 * @version 1.0 beta
 * @since 2019-04-09
 */

import static java.lang.Thread.sleep;
import java.util.Random;

public class Main {

    public static void main(String... args){

        try {

            FestivalGate gate = new FestivalGate();
            Random random = new Random();
            FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
            statsThread.start();

            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < 100 + random.nextInt(100); i++) {
                    FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(gate, TicketType.getRandomTicket());
                    festivalAttendee.start();
                }
                sleep(1000);
            }
            FestivalGate.finish = true;
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getStackTrace().toString());
            Thread.currentThread().interrupt();
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace().toString());
        }

    }
}
