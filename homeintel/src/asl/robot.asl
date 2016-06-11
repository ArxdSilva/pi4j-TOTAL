!start.

+!start : true <-
	+running;
	!getPosition;
	!move.	

+getPosition : running <-
	goAhead;
	goLeft;
	goRight;
	goBack;
	!move.

	+!move : true & lon(x) & x>19 <-
		-running.
			