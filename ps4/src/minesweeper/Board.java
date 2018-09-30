/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package minesweeper;
import java.math.*;
import java.util.*;

/**
 * TODO: Specification
 */
public class Board {
    
    // TODO: Abstraction function, rep invariant, rep exposure, thread safety
    
    // TODO: Specify, test, and implement in problem 2
    private final int sizeX;
    private final int sizeY;
    private final int boomNumber;
    private  String[][] board;
    private  String[][] boardCopy;
    
    public Board(int x,int y,int n) {
    	this.sizeX=x;
    	this.sizeY=y;
    	this.boomNumber=n;
    	this.board=new String[sizeY][sizeX];
    	this.boardCopy=new String[sizeY][sizeX];
    	for(int i=0;i<y;i++) {
    		for(int j=0;j<x;j++) {
    			board[i][j]=" ";
    			boardCopy[i][j]="untouched";
    		}
    	}
    	//System.out.println("construction"+boardCopy[2][2]);
    	System.out.println("constructBoomNumber"+Integer.toString(boomNumber));
    	int gridNumber=sizeX*sizeY;
    	HashSet<Integer> randomNumbers=genRand(gridNumber,boomNumber);
    	for(int iter:randomNumbers) {
    		int i=(iter-1)/x;
    		int j=(iter-1)%x;
    		board[i][j]="B";
    		board[i][j]="B";
    	}
    	
    	for(int i=0;i<y;i++) {
    		for(int j=0;j<x;j++) {
    			if(board[i][j]!="B") {
    				int bna=getBoomNumberAround(i,j);
    				board[i][j]=Integer.toString(bna);
    			}
    		}
    	}
    }
    
    
    
    
    public Board(String s[][]) {
    	this.sizeX=s[0].length;
    	this.sizeY=s.length;
    	int count=0;
    	for(int i=0;i<sizeY;i++) {
    		for(int j=0;j<sizeX;j++) {
    			if(s[i][j]=="1") {
    				board[i][j]="B";
    				count++;
    			}
    		}
    	}
    	for(int i=0;i<sizeY;i++) {
    		for(int j=0;j<sizeX;j++) {
    			if(board[i][j]!="B") {
    				int bna=getBoomNumberAround(i,j);
    				board[i][j]=Integer.toString(bna);
    			}
    			boardCopy[i][j]="untouched";
    		}
    	}
    	this.boomNumber=count;
    	
    }
    private int getBoomNumberAround(int i,int j) {
    	int count=0;
    	for(int x=0;x<3;x++) {
    		for(int y=0;y<3;y++) {
    			int a=i-1+x;
    			int b=j-1+y;
    			if((a>0 || a==0)&&(b>0 || b==0) && (a<sizeY) && b<sizeX) {
    				if(board[a][b]=="B") {
    					count++;
    				}
    			}
    		}
    	}
    	return count;
    }
    
    //generate n different numbers from 1-max
    private HashSet<Integer> genRand(int max,int n) {
    	if(max<n) {
    		return null;
    	}
    	Random rd=new Random();
    	HashSet<Integer> randNumbers=new HashSet<>();
    	while(randNumbers.size()<n) {
    		int r=rd.nextInt(max)+1;
    		randNumbers.add(r);
    	}
    	return randNumbers;
    }
    
    private void checkRepo() {
    	
    }
    
    public int getHeight() {
    	return sizeY;
    }
    
    public int getWidth() {
    	return sizeX;
    }
    
    public int getboomNumber() {
    	return boomNumber;
    }
    
    public String[][] getBoardCopy(){
    	return boardCopy;
    }
    
    //i,j>=0,i,j<sizeX,sizeY
    public String dig(int i,int j) {
    	if(i<0 || i==sizeY || j<0 || j==sizeX || i>sizeX || j>sizeY || boardCopy[i][j]!="untouched") {
    		System.out.println("invalidinput");
    		System.out.print(i);
    		System.out.print(j);
    		System.out.println(boardCopy[i][j]);
    		return "invalidInput";
    	}else {
    		if(board[i][j]=="B") {
    			board[i][j]=Integer.toString(getBoomNumberAround(i, j));
    	    	for(int x=0;x<3;x++) {
    	    		for(int y=0;y<3;y++) {
    	    			int a=i-1+x;
    	    			int b=j-1+y;
    	    			if((a>0 || a==0)&&(b>0 || b==0) && (a<sizeY) && b<sizeX) {
    	    				if(board[i][j]!="B") {
    	    					
    	    					String tmp=Integer.toString(Integer.parseInt(board[i][j])-1);
    	    					if(boardCopy[i][j]==board[i][j]) {
    	    						boardCopy[i][j]=tmp;
    	    					}
    	    					board[i][j]=tmp;
    	    				}
    	    				
    	    			}
    	    		}
    	    	}
    			return "Boom";
    		}else {
    			boardCopy[i][j]=board[i][j];
    			digAround(i, j);
    			
    			return "Success";
    		}
    	}
    }
    
    private void digAround(int i,int j){
		if(getBoomNumberAround(i, j)==0) {
	    	for(int x=0;x<3;x++) {
	    		for(int y=0;y<3;y++) {
	    			int a=i-1+x;
	    			int b=j-1+y;
	    			if((a>0 || a==0)&&(b>0 || b==0) && (a<sizeY) && b<sizeX) {
	    				if(boardCopy[a][b]=="untouched") {
		    				boardCopy[a][b]=board[a][b];
		    				digAround(a,b);
	    				}
	    			}
	    		}
	    	}
		}
		
	}
    public String flag(int i,int j) {
    	if(i<0 || i==sizeY || j<0 || j==sizeX || i>sizeX || j>sizeY || boardCopy[i][j]!="untouched") {
    		return "invalidInput";
    	}else if(boardCopy[i][j]!="untouched") {
    		
    			return "doNothing";
    		}else {
    			boardCopy[i][j]="F";
    			return "success";
    		}
    	}
    
    
    public String deflag(int i,int j) {
    	if(i<0 || i==sizeY || j<0 || j==sizeX || i>sizeX || j>sizeY || boardCopy[i][j]!="untouched") {
    		return "invalidInput";
    	}else if(boardCopy[i][j]!="F") {
    		return "doNothing";
    	}else {
    		boardCopy[i][j]="untouched";
    		return "success";
    	}
    }
    
    public String getoutMsg() {
    	String[][] boardMsg=new String[sizeY][sizeX];
    	String boardMsg_0="";
    	for(int i=0;i<boardMsg.length;i++) {
    		for(int j=0;j<boardMsg[0].length;j++) {
    			if(boardCopy[i][j]=="untouched") {
    				boardMsg[i][j]="-";
    			}else if(boardCopy[i][j]=="0") {
    				boardMsg[i][j]=" ";
    			}else {
    				boardMsg[i][j]=boardCopy[i][j];
    			}
    			if(j<boardMsg[0].length-1) {
    				boardMsg_0=boardMsg_0+boardMsg[i][j]+" ";
    			}else if(j==boardMsg[0].length-1) {
    				boardMsg_0=boardMsg_0+boardMsg[i][j]+"\n";
    			}
    			
    		}
    	}
    	return boardMsg_0;
    }
}
