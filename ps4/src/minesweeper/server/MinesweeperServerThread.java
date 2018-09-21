package minesweeper.server;
import java.net.*;

import minesweeper.server.*;

public class MinesweeperServerThread extends Thread {
	private Socket socket=null;
	
	public MinesweeperServerThread(Socket socket) {
		super();//????????????
		this.socket=socket;
	}
	
	public void run() {
        try {
            handleConnection(socket);
        } catch (IOException ioe) {
            ioe.printStackTrace(); // but don't terminate serve()
        } finally {
            socket.close();
        }
		
		
		
	}
	

}
