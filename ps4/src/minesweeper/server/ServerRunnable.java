package minesweeper.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import minesweeper.Board;

public class ServerRunnable implements Runnable {
	private Socket socket;
	private Board board;
	private boolean debug;
	public ServerRunnable(Socket socket,Board board,boolean debug) {
		this.socket=socket;
		this.board=board;
		this.debug=debug;
		
		System.out.println("runnableConstruction"+board.getBoardCopy()[2][2]);
	}
	public void run() {
        // handle the client
        try {
            handleConnection(socket);
        } catch (IOException ioe) {
            ioe.printStackTrace(); // but don't terminate serve()
        } finally {
        	try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
    private void handleConnection(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        try {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String output = handleRequest(line);
                if (output != "bye") {
                    // TODO: Consider improving spec of handleRequest to avoid use of null
                    out.println(output);
                    if(output =="BOOM") {
                    	if(!debug) {
                    		socket.close();
                    	}       	
                           	
                    }
                    
                }else {
                	out.close();
                	in.close();
                	socket.close();
                }
            }
        } finally {
            out.close();
            in.close();
        }
    }
    
    /**
     * Handler for client input, performing requested operations and returning an output message.
     * 
     * @param input message from client
     * @return message to client, or null if none
     */
    private String handleRequest(String input) {
        String regex = "(look)|(help)|(bye)|"
                     + "(dig -?\\d+ -?\\d+)|(flag -?\\d+ -?\\d+)|(deflag -?\\d+ -?\\d+)";
        
        String helpMsg="commands available: [help]    [look]    [bye]    [dig -i j]    [flag -i j]    [deflag -i j]";
        if ( ! input.matches(regex)) {
            // invalid input
            // TODO Problem 5
        	System.out.println("unmatch");
        	return helpMsg;
        	
        	
        }
        String[] tokens = input.split(" ");
        if (tokens[0].equals("look")) {
            // 'look' request
            // TODO Problem 5

        	String boardMsg_0=board.getoutMsg();
        	return boardMsg_0;
        	
        } else if (tokens[0].equals("help")) {
            // 'help' request
            // TODO Problem 5
        	return helpMsg;
        } else if (tokens[0].equals("bye")) {
            // 'bye' request
            // TODO Problem 5
        	
        	return "bye";
        	
        	
        } else {
            int x = Integer.parseInt(tokens[1]);
            int y = Integer.parseInt(tokens[2]);
            if (tokens[0].equals("dig")) {
                // 'dig x y' request
                // TODO Problem 5
            	System.out.println("dig"+board.getoutMsg());
            	String digMsg=board.dig(x, y);
            	
            	
            	if(digMsg=="invalidInput") {
            		return helpMsg;
            	}else if(digMsg=="Boom") {
            		return "BOOM";
            	}else if(digMsg=="Success") {
            		System.out.println("digsuccess");
            		System.out.println(board.getoutMsg());
            		return board.getoutMsg();
            	}
            	
            } else if (tokens[0].equals("flag")) {
                // 'flag x y' request
                // TODO Problem 5
            	
            	board.flag(x, y);
            	return board.getoutMsg();
            } else if (tokens[0].equals("deflag")) {
                // 'deflag x y' request
                // TODO Problem 5
            	board.deflag(x, y);
            	return board.getoutMsg();
            }
        }
        // TODO: Should never get here, make sure to return in each of the cases above
        throw new UnsupportedOperationException();
    }

}
