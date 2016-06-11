package homeintel;

import static jason.environment.Environment.logger;
import car.Javino;
import jason.asSyntax.*;
import jason.environment.*;

//adicionando comandos da biblioteca Pi4J
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class main extends Environment {
	
	
	private Javino jBridge = new Javino("/dev/com9", "c:\\cygwin64\\bin\\",200); //WINDOWS
	//private Javino jBridge = new Javino("/dev/ttyACM0", 200); //RASP	
	
		public static void main(String args[]) {
	
			Javino j = new Javino();
			String port = "COM3";
			String ask = "status";
			String comun;
			this.Refresh();
			
			//cria p cpmtrpçadpr de GPIO
			final GpioController gpio = GpioFactory.getInstance();
			//seta o pino #1 como pino de saida e o liga
			//liga o LED para avisar que o programa foi iniciado
			final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);			
			
			//para enviar com. p/ o Arduino o metodo mais facil é por sendmsg?
			this.jBridge.sendmsg("status");
			j.requestData(port, comun);
		
			/*
			 * transformando a variavel ask STRING em INTEGER msg.
			 */
				comun = int msg;	
				addPercept( ,("distance(" + msg + ")"));
				
								
				if (action.toString().equals("goAhead")) {
					this.jBridge.percept = "goAhead"; 
			        this.jBridge.sendmsg("goAhead");
				}
				
				if (action.toString().equals("goBack")) {
					this.jBridge.percept = "goBack";
					this.jBridge.sendmsg("goBack");
					}
				
				if (action.toString().equals("stop")) {
					this.jBridge.percept = "stop";
					this.stop;
					}
				if (action.toString().equals("refresh")) {
					this.jBridge.percept = "refresh";
					this.Refresh;
					}
		}
	public void Refresh {
		clearPercepts();
	}
	
	public void stop() {
		j.sendCommand(port, "Stop");
	}
}
