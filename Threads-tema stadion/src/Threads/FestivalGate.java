package Threads;

/**
 * @author Nacu Sorin-Constantin
 * @version 1.0 beta
 * @since 2019-04-09
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    public static boolean finish=false;
    private HashMap<TicketType,Integer> statistics;
    private long people;
    private Queue<TicketType> queue;

    public FestivalGate(){
        queue =new LinkedList<>();
        statistics=new HashMap<>();


        TicketType[] ticketTypes =TicketType.values();
        for(int i=0;i<ticketTypes.length;i++){
            statistics.put(ticketTypes[i],0);
        }
        people =0;
    }

    public synchronized void add(TicketType ticket){
        queue.add(ticket);
        if (statistics.get(ticket)==null)
            statistics.put(ticket,1);
        else
            statistics.put(ticket,statistics.get(ticket).intValue()+1);
    }


    public synchronized long queueSize(){
        return queue.size();
    }

    public long getPeople(){
        return people;
    }

    public synchronized void clearGate(){
        people += queue.size();
        queue.clear();
    }

    public HashMap<TicketType,Integer> getStatistics(){
        return statistics;
    }
}