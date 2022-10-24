
package airportq6;

/**
 *
 * @author Georgia Turner and Jesse Castillo
 * @param <E>
 */
import java.util.concurrent.LinkedBlockingQueue;

public class Runway<E> {
    
    private LinkedBlockingQueue<Plane> takeoff;
    private LinkedBlockingQueue<Plane> landing;
    private LinkedBlockingQueue<Plane> runway;
    private int planesLanded;
    private int planesTookoff;
    private double averageTakeOffWait;
    private double averageLandWait;
    private int totalTakeoffWait;
    private int totalLandingWait;
    private int planesWaitingToTakeOff;
    private int planesWaitingToLand;
    private int maxLandingQueueLength;
    private int maxTakeOffQueueLength;

    public int timeToLand = 5;
    public int timeToTakeoff = 4;
    public double landingProbability = .1;
    public double takeOffProbability = .1;
    public int simulationLength = 1440;
    
    

public Runway() {
    takeoff = new LinkedBlockingQueue<>();
    landing = new LinkedBlockingQueue<>();
    runway = new LinkedBlockingQueue<>();

    planesLanded = 0;
    planesTookoff = 0;
    averageTakeOffWait = 0;
    averageLandWait = 0;
    totalTakeoffWait = 0;
    totalLandingWait = 0;
    planesWaitingToTakeOff = 0;
    planesWaitingToLand = 0;
    maxLandingQueueLength = 0;
    maxTakeOffQueueLength = 0;
    //reset();
}

public void simulate(int duration, double takeoffRate, double landingRate, int landingTime, int takeoffTime) {
    for(int count = 0; count < duration; count++) {
        if(Math.random() < takeoffRate) {
            Plane p = new Plane(landingTime, takeoffTime, count);
            takeoff.offer(p);
        }
        if(Math.random() < landingRate) {
            Plane p = new Plane(landingTime, takeoffTime, count);
            landing.offer(p);
        }

        if(runway.size() == 0) {
                if(landing.peek() != null) {
                    Plane landingPlane = landing.poll();
                    runway.offer(landingPlane);
                    planesLanded++;
                    int landTimeWaited = count - landingPlane.getArrivalTime();
                    totalLandingWait += landTimeWaited; 
                    runway.poll();
                } else if(takeoff.peek() != null) {
                    Plane takeoffPlane = takeoff.poll();
                    runway.offer(takeoffPlane);
                    planesTookoff++;
                    int takeoffTimeWaited = count - takeoffPlane.getArrivalTime();
                    totalLandingWait += takeoffTimeWaited;
                    runway.poll();
                }
            }
    }
}

public void report() {
    System.out.println(planesLanded + " planes have landed.");
    System.out.println(planesTookoff + " planes have taken off.");
    System.out.println(landing.size() + " planes still waiting to land.");
    System.out.println(takeoff.size() + " planes still waiting to takeoff.");

    System.out.println(1.0*totalTakeoffWait/planesTookoff + " average take off wait time.");
    System.out.println(1.0*totalLandingWait/planesLanded + " average landing wait time."); 

  }

}