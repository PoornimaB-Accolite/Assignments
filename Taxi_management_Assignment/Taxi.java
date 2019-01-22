public class Taxi {
    private Passenger.DESTINATION destination;
    private int passenger_count;
    public Taxi() {
        System.out.println("New Taxi arrives");
        passenger_count = 0;
    }

    public Passenger.DESTINATION getDestination() {
        return destination;
    }

    public int getpassengerCount() {
        return passenger_count;
    }

    public boolean isFull() {
        if(passenger_count<4)
            return false;
        else
            return true;
    }

    public boolean addPassenger() {
        if(isFull()){
            System.out.println("Taxi is full");
            return false;
        } else {
            passenger_count++;
            System.out.println("Passenger boards taxi to " + destination + "- passenger count " + passenger_count);
            return true;
        }
    }

    public boolean allocatePassenger(Passenger p) {
        if(destination==null) {
            System.out.println("Empty Taxi - set Destination " + p.getDestination());
            destination = p.getDestination();
            return addPassenger();
        } else {
            if(destination==p.getDestination()){
                System.out.println("Found taxi to " + destination);
                return addPassenger();
            } else {
                System.out.println("Unable to allocate passenger to this taxi");
                return false;
            }
        }
    }
}
