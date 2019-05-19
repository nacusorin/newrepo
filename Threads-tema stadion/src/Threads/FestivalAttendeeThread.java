package Threads;
/**
 * @author Nacu Sorin-Constantin
 * @version 1.0 beta
 * @since 2019-04-09
 */



public class FestivalAttendeeThread extends Thread{
    private FestivalGate gate;
    private TicketType ticket;

    public FestivalAttendeeThread(FestivalGate gate, TicketType ticket){
        this.gate=gate;
        this.ticket=ticket;
    }

    @Override
    public void run() {
        if (ticket!=null) gate.add(ticket);
        try {
            sleep(1000);
        }
        catch (InterruptedException ex){
            System.out.println(ex.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
