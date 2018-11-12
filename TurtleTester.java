package lab_8;
import java.util.*;

public class TurtleTester {
	
	public static void main(String[] args)
	{
		Turtle t1=new Turtle();
		System.out.println("Your Turtle is Generated.");
		System.out.println();
		System.out.println("X: "+t1.getX()+" Y: "+t1.getY()+" Direction: "+t1.getDirection());
		System.out.println();
		System.out.println();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.printf("\t\t\tMenu\n\n1).Advance\n2).Turn Left\n3).Turn Right\n4).Jam Clean(if jammed)\n5).Exit\n\n\tEnter your choice here: ");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter an Integer you want to advance turtle by: ");
				int adv=sc.nextInt();
				t1.advance(adv);
				System.out.println("After Advancing Turtle");
				System.out.println("X: "+t1.getX()+" Y: "+t1.getY()+" Direction: "+t1.getDirection());
				System.out.println();
				break;
			case 2:
				t1.turnLeft();
				System.out.println("X: "+t1.getX()+" Y: "+t1.getY()+" Direction after turning Left: "+t1.getDirection());
				System.out.println();
				System.out.println();
				break;
			case 3:
				t1.turnRight();
				System.out.println("X: "+t1.getX()+" Y: "+t1.getY()+" Direction after turning Right: "+t1.getDirection());
				System.out.println();
				System.out.println();
				break;
			case 4:
				t1.jamClear();
				System.out.println("If it was jammed the the new place and direction for turtle: "+t1.getX()+" "+t1.getY()+" "+t1.getDirection());
				System.out.println();
				System.out.println();
			case 5:
				break;
			}
			if(choice==5)
				break;
		}
	}

}
