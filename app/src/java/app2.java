// Environment code for project app

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import turing.Javino;

public class app2 extends Environment {

	private Logger logger = Logger.getLogger("app." + app2.class.getName());
	private Javino jBridge = new Javino();

	/** Called before the MAS execution with the args informed in .mas2j */
	@Override
	public void init(String[] args) {
		super.init(args);
		addPercept(Literal.parseLiteral("percept(demo)"));
	}

	@Override
	public boolean executeAction(String agName, Structure action) {

		if (action.toString().equals("goAhead")) {
			this.jBridge.sendCommand("COM3", "goAhead");
		}
		if (action.toString().equals("stop")) {
			this.jBridge.sendCommand("COM3", "Stop");
		}
		if (action.toString().equals("goBack")) {
			this.jBridge.sendCommand("COM3", "goBack");
		}
		if (action.toString().equals("refresh")) {
			this.jBridge.sendCommand("COM3", "status");
		}
		
		return true;
	}

	/** Called before the end of MAS execution */
	@Override
	public void stop() {
		super.stop();
	}
}
