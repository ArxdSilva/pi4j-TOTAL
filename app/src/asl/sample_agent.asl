// Agent sample_agent in project app

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */
+!start : true <- .print("goAhead");

 goAhead;
 .wait(2000);
 stop;
 .wait(2000);
 goBack;
 .wait(2000);
 stop;
 !start.
  