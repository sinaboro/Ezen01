package com.tv;

public class VCR {
	protected int counter;
	
	public void play() {}
	public void stop() {}
	public void reset() {counter=0;}
	public int getCounter() {return counter;}
	public void setCounter(int counter){
		this.counter =  counter; }
	
}
