import java.util.Random;
/**
   A class that simulates a simple one-runway airport.
   Planes awaiting takeoff queue on the ground;
   those waiting to land queue in the air.
   Planes in the air must land before those on the ground can take off.

   @author Jesse Grabowski
   @author Joseph Erickson
   @version 5.0
*/
public class SimpleAirport
{
	private Random r;
	private LinkedQueue<String> airQueue;
	private LinkedQueue<String> groundQueue;

	/** Creates an airport with no airplanes. */
	public SimpleAirport()
	{
		this(0);
	} // end default constructor
	
	/** Creates an airport with the specified number of flights
		 assigned randomly to be either in the air or on the ground.
		 @param flights  The number of flights in both air and ground combined. */
	public SimpleAirport(int flights)
	{
		r = new Random();
		airQueue = new LinkedQueue<>();
		groundQueue = new LinkedQueue<>();

		for (int x = 0; x < flights; x++)
			addRandom();
	} // end constructor

	/** Simulates a randomly queued flight. */
	public void addRandom()
	{
		if (r.nextInt(2) == 0) // 50% chance to add to ground
			addGround();
		else
			addAir();
	} // end addRandom
	
	/** Simulates a queuing on the ground. */
	public void addGround()
	{
			String planeName = "Flight " + Integer.toString(r.nextInt(999) + 1);
			System.out.println(planeName + " has joined the queue on the ground.");
			groundQueue.enqueue(planeName);
	} // end addGround

	/** Simulates a queuing in the air. */
	public void addAir()
	{
			String planeName = "Flight " + Integer.toString(r.nextInt(999) + 1);
			System.out.println(planeName + " has joined the queue in the air.");
			airQueue.enqueue(planeName);
	} // end addAir

	/** Simulates a landing/takeoff cycle. */
	public void landingAndTakeoff()
	{
		if (!airQueue.isEmpty())
		{
			String planeName = airQueue.dequeue();
			System.out.println(planeName + " has successfully landed!");
		} // end if
		else if (!groundQueue.isEmpty())
		{
			String planeName = groundQueue.dequeue();
			System.out.println(planeName + " has successfully taken off!");
		} // end else if
		else
			System.out.println("No planes need to land or take off!");
	} // end landingAndTakeoff
	
	/** Simulates all flights in the air landing on the runway and
	    all planes on the ground taking off, leaving both queues empty. */
	public void clearAllFlights()
	{
		System.out.println("Clearing all planes from the airport.");
		while(!airQueue.isEmpty() || !groundQueue.isEmpty())
			landingAndTakeoff();
	} // end clearAllFlights
} // end SimpleAirport
