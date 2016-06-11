package home;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * This code demonstrates how to control a few DC motors
 * using GPIO pins on the Raspberry Pi.  
 * 
 * @author Arthur Silva @arthurgamer1
 */

public class ControlGpio{
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("<--Pi4J--> GPIO Control ... started.");
        
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();
        
        // provision gpio pins from #01-4 as an output pin and turn on
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02,PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03,PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,PinState.HIGH);
        
        // set shutdown state for this pin
        pin1.setShutdownOptions(true, PinState.LOW);
        pin2.setShutdownOptions(true, PinState.LOW);
        pin3.setShutdownOptions(true, PinState.LOW);
        pin4.setShutdownOptions(true, PinState.LOW);
        
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);
        
        // turn off gpio pin #01
        pin1.low();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01 (should turn on)
        pin1.toggle();
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01  (should turn off)
        pin1.toggle();
        System.out.println("--> GPIO state should be: OFF");
        
        Thread.sleep(5000);

        // turn on gpio pin #01 for 1 second and then off
        System.out.println("--> GPIO state should be: ON for only 1 second");
        pin1.pulse(1000, true); // set second argument to 'true' use a blocking call
        
        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();
    }
}