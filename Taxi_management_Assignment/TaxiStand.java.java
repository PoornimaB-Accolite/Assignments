import java.util.LinkedList;
import java.util.ListIterator;

public class TaxiStand {
    private int size = 5;
    private LinkedList<Taxi> taxiStand;
    private LinkedList<Taxi> taxiQueue;
    private LinkedList<Passenger> passengerQueue;

    public TaxiStand(int capacity, LinkedList<Taxi> q, LinkedList<Passenger> pq) {
        size = capacity;
        taxiQueue = q;
        passengerQueue = pq;
        taxiStand = new LinkedList<Taxi>();
        for(int i=0; i<size ; i++){
            taxiStand.add(new Taxi());
        }
        System.out.println("Creating a TaxiStand with capacity " + size);
    }

    public boolean addTaxi(Taxi c){
        if(!isFull() || isEmpty())
       {
    	   
    	   taxiStand.add(c);
    	   return true;
       }
       return false;
    }

    public boolean isFull(){
        return (taxiStand.size()<size) ? false : true;
    }
    
    public boolean isEmpty() {
        return (taxiStand.size()==0) ? true : false;
    }

    public boolean allocatePassenger(Passenger p) {
        boolean status=false ;
    	for(Taxi q:taxiStand)
    	{
    	if(q.getDestination()==null)
    		{
    			q.setDestination(p.getDestination());
    			 status=q.addPassenger();
    		}
    	
    	
    	else if(q.getDestination()==p.getDestination()){
    	               System.out.println("Found taxi to " + p.getDestination());
    	               status= q.addPassenger();
    	    			}
    	             
    	
    	}
    	return status;
    	}

    public synchronized void processPassengerQueue(){
        System.out.println("Starting to process passengerQueue with " + passengerQueue.size() + " passengers");
        for(Passenger i:passengerQueue)
        {
        	if(this.allocatePassenger(i));
        	{
        	passengerQueue.remove(i);
        	System.out.println("One of them in queue is procseesed");
        	}
        }
        System.out.println("After processing passengerQueue " + passengerQueue.size() + " passengers remain in queue");
    }

    public void printStatus() {
        ListIterator<Taxi> standIterator = taxiStand.listIterator();
        int position=0;
        while(standIterator.hasNext()) {
            Taxi taxi = standIterator.next();
            position++;
            System.out.println(position + ". Taxi to " + taxi.getDestination() + " passengers=" + taxi.getpassengerCount());
        }
    }
    public static void main(String[] args) {
        System.out.println("Starting simulaion...");
        LinkedList<Taxi> taxiQueue = new LinkedList<Taxi>();
        LinkedList<Passenger> passengerQueue = new LinkedList<Passenger>();
        TaxiStand lot = new TaxiStand(5, taxiQueue, passengerQueue);

        TaxiQueueRunnable taxicreator = new TaxiQueueRunnable(taxiQueue, lot);
        PassengerQueueRunnable passengerCreator = new PassengerQueueRunnable(passengerQueue, lot);
       
        Thread taxi_creater=new Thread(taxicreator);
        Thread passanger_creater=new Thread(passengerCreator);

        taxi_creater.start();
        passanger_creater.start();
        


        
    }
}
