package elevator;

import java.util.LinkedList;
import java.util.Random;

public class ElevatorExperement
{
	static int currentLevel = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> levelList = new LinkedList<Integer>();
		final int AmountOfRequests=50;
		final int AmountOfFloors=50;
		Random rand = new Random();
		for(int i=0;i!=AmountOfRequests;i++)
		{
			levelList.add(rand.nextInt(AmountOfFloors));
		}
		LinkedList<Integer> tempLevelList = new LinkedList<Integer>(levelList);
		System.out.println("The elevator will go to these floors : "+levelList);
		try {
			FIFO(tempLevelList);
			Algorithm(levelList);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void FIFO (LinkedList<Integer> floors) throws InterruptedException {
		int steps = 0;
		System.out.println("The current floor is : "+currentLevel);
		long timeStart = System.currentTimeMillis();
		while(!floors.isEmpty()) {
			
			int l = floors.getFirst();
			
			while(l>currentLevel) {
				String string = String.format("%s", currentLevel);
				System.out.print(string);
				steps++;
				currentLevel++;
			}
			
			while(l<currentLevel) {
				String string = String.format("%s", currentLevel);
				System.out.print(string);
				steps++;
				currentLevel--;
			}
			System.out.println("\nYou have arrived level "+currentLevel);
			floors.removeFirst();
		}
		System.out.println("Amount of Steps : "+steps+ " steps");
	}
	public static void Algorithm(LinkedList<Integer>floors) throws InterruptedException
	{
		LinkedList<Integer>tempFloors = new LinkedList<Integer>();
		while(!floors.isEmpty())
		{
			int steps=100000;
			int tempCurrentLevel = currentLevel;
			for(int i=0;i!=floors.size();i++)
			{
				int tempSteps = 0;
				if((currentLevel - floors.get(i))>0)
				{
					tempSteps=currentLevel - floors.get(i);
				}
				else
				{
					tempSteps=currentLevel - floors.get(i)*-1;
				}
				if(tempSteps<steps)
				{
					steps=tempSteps;
					tempCurrentLevel=floors.get(i);
				}
			}
			tempFloors.addLast(tempCurrentLevel);
			floors.remove(floors.indexOf(tempCurrentLevel));
		}
		floors=tempFloors;
		int stups = 0;
		while(!floors.isEmpty()) {
			
			int l = floors.getFirst();
			
			while(l>currentLevel) {
				String string = String.format("%s", currentLevel);
				//System.out.print(string);
				stups++;
				currentLevel++;
			}
			
			while(l<currentLevel) {
				String string = String.format("%s", currentLevel);
				//System.out.print(string);
				stups++;
				currentLevel--;
			}
			System.out.println("\nYou have arrived level "+currentLevel);
			floors.removeFirst();
		}
		
		long endtime = System.currentTimeMillis();
		System.out.println("steps : "+stups+ " steps");
	}
}
