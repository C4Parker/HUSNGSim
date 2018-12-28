import java.util.Stack;
import java.util.ArrayList;

import java.util.Random;

public class Sim {
	
	static double winrate = 0.53;
	static double rake = 0.00;
	static double buyIn = 10;
	
	public static void main(String args[]){
		
		Stack<Double> s = simulateSample(100, winrate, buyIn, rake);
		
		ArrayList<Stack<Double>> t = simulateSamples(20, 100, winrate, buyIn, rake);
		
		for(Stack<Double> x : t){
			System.out.println(x.peek());
		}
	}
	
	static ArrayList<Stack<Double>> simulateSamples(int numSamples, int sampleSize, double winrate, double buyIn, double rake){
		ArrayList<Stack<Double>> s = new ArrayList<Stack<Double>>(numSamples);
		for(int i = 0; i < numSamples; i++)
			s.add(simulateSample(sampleSize, winrate, buyIn, rake));
		return s;
	}
	
	static Stack<Double> simulateSample(int sampleSize, double winrate, double buyIn, double rake){
		Stack<Double> sample = new Stack<Double>();
		sample.push((double) 0);
		for(int i = 0; i < sampleSize; i++)
			sample.push(sample.peek() + simulateFlip(winrate, buyIn, rake));
		return sample;
	}
	
	static Double simulateFlip(double winrate, double buyIn, double rake){
			if(Math.random() < winrate)
				return buyIn * (1-rake*2);;
			return -buyIn;
	}
	
	static void printBar(double size){
		char c;
		if(size < 0)
			c = '-';
		else
			c = '*';
		
		String s = "";
		for(int i = 0; i < Math.abs(size); i = i + 10)
			s = s + c;
		System.out.println(s);
	}
}