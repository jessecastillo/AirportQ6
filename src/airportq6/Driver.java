/**
   A driver for a simple airport as described in Chapter 10, Project 4.
   
   @author Joseph Erickson
   @version 5.0
 */
public class Driver
{
	public static void main(String[] args)
	{
		int flights = 10;
		
		System.out.println("T. F. Green Airport");
		System.out.println("===================");
		
		System.out.println();
		System.out.println("Adding " + flights + " flights to random queues:");
		SimpleAirport TFGreen = new SimpleAirport(flights);

		System.out.println();
		System.out.println("Initiating "+ (flights + 1) + " landings/takeoffs:");
		for (int i = 0; i < flights + 1; i++) // Testing removing from queues
			TFGreen.landingAndTakeoff();

		System.out.println();
		System.out.println("Adding 5 flights to the ground:");
		for (int i = 0; i < 5; i++) // Testing adding to ground queue
			TFGreen.addGround();

		System.out.println();
		System.out.println("Adding 3 flights to the air:");
		for (int i = 0; i < 3; i++) // Testing adding to air queue
			TFGreen.addAir();

		System.out.println();
		System.out.println("Clearing all flights:");
		TFGreen.clearAllFlights();  // Testing clearing all queues

		System.out.println();
		System.out.println("\nDone.");
	} // end main
} // end Driver

/*
 T. F. Green Airport
 ===================
 
 Adding 10 flights to random queues:
 Flight 422 has joined the queue on the ground.
 Flight 435 has joined the queue on the ground.
 Flight 383 has joined the queue in the air.
 Flight 84 has joined the queue in the air.
 Flight 525 has joined the queue on the ground.
 Flight 732 has joined the queue in the air.
 Flight 33 has joined the queue in the air.
 Flight 148 has joined the queue in the air.
 Flight 18 has joined the queue on the ground.
 Flight 491 has joined the queue in the air.
 
 Initiating 11 landings/takeoffs:
 Flight 383 has successfully landed!
 Flight 84 has successfully landed!
 Flight 732 has successfully landed!
 Flight 33 has successfully landed!
 Flight 148 has successfully landed!
 Flight 491 has successfully landed!
 Flight 422 has successfully taken off!
 Flight 435 has successfully taken off!
 Flight 525 has successfully taken off!
 Flight 18 has successfully taken off!
 No planes need to land or take off!
 
 Adding 5 flights to the ground:
 Flight 342 has joined the queue on the ground.
 Flight 694 has joined the queue on the ground.
 Flight 664 has joined the queue on the ground.
 Flight 845 has joined the queue on the ground.
 Flight 488 has joined the queue on the ground.
 
 Adding 3 flights to the air:
 Flight 273 has joined the queue in the air.
 Flight 139 has joined the queue in the air.
 Flight 937 has joined the queue in the air.
 
 Clearing all flights:
 Clearing all planes from the airport.
 Flight 273 has successfully landed!
 Flight 139 has successfully landed!
 Flight 937 has successfully landed!
 Flight 342 has successfully taken off!
 Flight 694 has successfully taken off!
 Flight 664 has successfully taken off!
 Flight 845 has successfully taken off!
 Flight 488 has successfully taken off!
 
 
 Done.

 */
