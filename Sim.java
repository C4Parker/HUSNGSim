import java.util.Stack;

import java.util.Random;

public class Sim {
	
	static double probability = 0.53;
	static double rake = 0.00;
	static double amount = 10;
	
	public static void main(String args[]){
		
		Stack<Double> s = simulateSample(100, probability, amount, rake);
		for(double d : s){
			System.out.print(d + " :\t");
			printBar(d);
		}
	}
	
	static Stack<Double> simulateSample(int sampleSize, double probability, double amount, double rake){
		Stack<Double> sample = new Stack<Double>();
		sample.push((double) 0);
		for(int i = 0; i < sampleSize; i++)
			sample.push(sample.peek() + simulateFlip(probability, amount, rake));
		return sample;
	}
	
	static Double simulateFlip(double probability, double amount, double rake){
			if(Math.random() < probability)
				return amount * (1-rake*2);;
			return -amount;
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