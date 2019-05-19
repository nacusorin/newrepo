package Threads;

/**
 * @author Nacu Sorin-Constantin
 * @version 1.0 beta
 * @since 2019-04-09
 */

import java.util.HashMap;


public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;
    public FestivalStatisticsThread(FestivalGate gate){
        this.gate=gate;
    }

    @Override
    public void run() {
        while (!FestivalGate.finish || gate.queueSize()>0 ){
            try {
                if (gate.queueSize()>0) {
                    gate.clearGate();
                    HashMap<TicketType, Integer> statistics = gate.getStatistics();
                    System.out.println("FestivalStatistics:");
                    System.out.println(gate.getPeople() + " people entered");
                    for (HashMap.Entry<TicketType, Integer> entry : statistics.entrySet()) {
                        System.out.println(entry.getValue() + " people has " + entry.getKey());
                    }
                }
                sleep( 5000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}