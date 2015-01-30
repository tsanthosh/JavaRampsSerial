package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 

import java.util.Enumeration;

import views.UserDetails;

public class SerialPortController implements SerialPortEventListener{
    
    SerialPort serialPort;
	private static final String PORT_NAMES[] = { 
			"/dev/tty.usbmodem1421", // Mac OS X
                        "/dev/ttyACM0", // Raspberry Pi
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;
	private UserDetails userDetails;
        
    public SerialPortController(UserDetails userDetails) {

        this.userDetails = userDetails;
    	CommPortIdentifier portId = null;
		Enumeration<?> portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM port.");
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
            
            //add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
			
		} catch (Exception e) {System.err.println(e.toString());}
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
         * @param oEvent
	 */
        @Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		
        	//if (objSerialPortView.isActive()){
	      if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine=input.readLine();
	            userDetails.settxtReceive(inputLine);
				} catch (Exception e) {
				System.err.println(e.toString());
				}
	      }
	}
        
    public synchronized void send (String string) {
        try {
            output.write(string.getBytes());
        } catch (Exception e) {
            System.out.println("could not write to port");
        }
    }
}
