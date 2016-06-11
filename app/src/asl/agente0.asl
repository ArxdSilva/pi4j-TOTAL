// Agent sample_agent in project car

/* Initial beliefs and rules */

/* Initial goals */


!refresh.

+!start : distance(X) &  X >= 25 <- 
	.print("Moving ahead.");
	goAhead;
	.wait(100);
	!refresh.
	
+!start : distance(X) & X < 10 <-
	.print("Too close");
	goBack;
	.wait(100);
	!refresh.

+!start : distance(X) & X >= 100 <-
	.print("No communication! Stopped!");
	stop;
	.wait(100);
	!refresh.
-!start <-
	stop;
	!start.

+!refresh <-
	refresh;
	.wait(100);
	!start.
