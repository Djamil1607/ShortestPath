import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.math.*;
import java.lang.*;
public class ShortestPath {
	//declare a static array to store shortest path
	//legth is used to intialize the length of the shortest array
	static int[] shrt= new int [ShortestPath.length1];
	public static int length1;
	static double shortest= Double.MAX_VALUE;
	
	
	//static int[] shortestArray;
	//static int count=0;
	
	//print a array1 with id,distance etc....
	public static void printArray(Nodes [] Array1) {
		
		System.out.println("");
		System.out.println("\tx\ty");
		for (int i=0; i<Array1.length; i++) {
			Nodes c = Array1[i];
			System.out.print(Array1[i].getIndex() + " -");
			System.out.println("\t"+c.getX()+"\t" + c.getY());
		}
	}
	//display shortest distance and path
	public static void displayDis() {
		System.out.println("The shortest distance is "+shortest);
		 System.out.print("the shortest path is ");
		 for (int i=0; i<shrt.length; i++) {
			 System.out.print(shrt[i]+" ");
			
		 }
		 System.out.print("or its reverse ");
	}
	//swapping of the arrays
	public static void swap(Nodes [] Array1, int i, int j) {
		Nodes temp = Array1[i];
		Array1[i]=Array1[j];
		Array1[j]=temp;
	}
	//makes a factorial of the elements of the array
    public static void printPerm(Nodes [] Array1, int currentindex) {
    	
    	if (currentindex==Array1.length-1) {
    		printArray(Array1);
    		distanceCal(Array1);
    	}
		
		for (int i=currentindex; i<Array1.length; i++) {
			swap(Array1,i,currentindex);
			printPerm(Array1, currentindex+1);
			swap(Array1,i,currentindex);
			
		}
	}
    //calculate the distance
   public static double distanceCal(Nodes [] Array1) {
		int x1,x2,y1,y2,ides;
		int [] arr=new int [Array1.length];
		double totaldist =0.0;
		double dist=0.0;
		
			for (int i=0; i<Array1.length-1;i++) {
			    x1 = Array1[i].getX();
			    x2 = Array1[i+1].getX();
			    y1 = Array1[i].getY();
			    y2 = Array1[i+1].getY();
			    dist = Math.abs(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
			    totaldist = totaldist + dist;
			    ides = Array1[i].getIndex();
			    
			    arr[i]=ides;
			    
			    System.out.println("distance between " +x1+" "+y1+ " and " +x2+" "+y2+ " is " +dist);
				}
			//for loop is excuted only (Array1.length-1) times. Last element of array storing index will not be filled
			arr[Array1.length-1]=Array1[Array1.length-1].getIndex();
			System.out.println("total distance for the above nodes is "+totaldist);
			if (totaldist < shortest)
			{
				shortest =totaldist;
				shrt=arr;
				
			}
			return totaldist;
    }
    
	public static void main (String [] args) {
		ShortestPath obj = new ShortestPath();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes");
	 	int nodes = input.nextInt();
		Random rnd = new Random();
		ShortestPath.length1=nodes;
		Nodes Array1 [] = new Nodes [nodes];
		
		int [] shrt=new int [nodes];
		
		for (int i=0; i<Array1.length; i++) {
			int x = rnd.nextInt(100);
			int y = rnd.nextInt(100);
			int id=i;
			Nodes m = new Nodes(x,y,id);
			Array1[i]= m;
		}
		System.out.println("id\tx\ty");
		for (int i=0; i<Array1.length; i++) {
			Nodes c = Array1[i]; 
			System.out.println(i+ "\t" +c.getX() + "\t" + c.getY());
		}
		printPerm(Array1,0);
		displayDis();
		
	}	
}
