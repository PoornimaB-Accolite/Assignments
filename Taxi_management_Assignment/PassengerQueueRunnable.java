import java.util.LinkedList;
import java.util.Random;

public class PassengerQueueRunnable implements Runnable {
    TaxiStand lot;
    LinkedList<Passenger> passengerQueue;
    int queueNumber=0;
    public PassengerQueueRunnable(LinkedList<Passenger> queue, TaxiStand l) {
        passengerQueue = queue;
        lot = l;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ie) {

            }
            int pick = new Random().nextInt(Passenger.DESTINATION.values().length);
            Passenger p = new Passenger(Passenger.DESTINATION_VALUES[pick]);
            System.out.println("New passenger with destination " + p.getDestination() + " arrives.");

            if(!lot.allocatePassenger(p)) {
                System.out.println("No cab found for passenger. Adding to Queue..");
                passengerQueue.add(p);
                System.out.println("Passeneger added to queue. Queue Length " + passengerQueue.size());
            }
        }
    }
}
