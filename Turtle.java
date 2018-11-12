package lab_8;

public class Turtle {
	private int x,y;
	String dir;
	boolean jam=false;
	final int boundry1=-1000;
	final int boundry2=1000;
	final String[] di=new String[]{"East","West","North","South"};
	public Turtle()
	{
		x=((int)(Math.random()*2000)-1000);
		y=((int)(Math.random()*2000)-1000);
		dir=di[(int)(Math.random()*3)];
	}
	
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String getDirection()
	{
		return dir;
	}

	public void advance(int adv)
	{
		if(getDirection().compareToIgnoreCase("East")==0)
		{
			int temp=getX()+adv;
			if(temp<=1000)
			{
				x=temp;
			}
			else 
			{
				if(temp<-1000)
					x=boundry1;
				else
					x=boundry2;
				jam=true;
				System.out.println("You have reached to boundries.");
			}
		}
		else if(getDirection().compareToIgnoreCase("West")==0)
		{
			int temp=getX()-adv;
			if(temp>=-1000)
			{
				x=temp;
			}
			else
			{
				if(temp<-1000)
					x=boundry1;
				else
					x=boundry2;
				jam=true;
				System.out.println("You have reached to boundries.");
			}
		}	
		else if(getDirection().compareToIgnoreCase("North")==0)
		{
			int temp=getY()+adv;
			if(temp<=1000)
			{
				y=temp;
			}
			else
			{
				if(temp<-1000)
					x=boundry1;
				else
					x=boundry2;
				jam=true;
				System.out.println("You have reached to boundries.");
			}
		}		
		else if(getDirection().compareToIgnoreCase("South")==0)
		{
			int temp=getY()-adv;
			if(temp>=-1000)
			{
				y=temp;
			}
			else
			{
				if(temp<-1000)
					x=boundry1;
				else
					x=boundry2;
				jam=true;
				System.out.println("You have reached to boundries.");
			}
		}	
	}

	public void turnLeft()
	{
		if(jam==false)
		{
			if(getDirection().compareToIgnoreCase("East")==0)
				dir=di[2];
			else if(getDirection().compareToIgnoreCase("West")==0)
				dir=di[3];
			else if(getDirection().compareToIgnoreCase("North")==0)
				dir=di[1];
			else
				dir=di[0];
		}
		else
		{
			System.out.printf("\n\n\t\t\tYour Turtle is Jammed at Boundries. It cannot turn left/right.\n\n\t\t\t\n\n\nUse Jam Cleaner to go further.");
		}
	}


	public void turnRight()
	{
		if(jam==false)
		{
			if(getDirection().compareToIgnoreCase("East")==0)
				dir=di[3];
			else if(getDirection().compareToIgnoreCase("West")==0)
				dir=di[2];
			else if(getDirection().compareToIgnoreCase("North")==0)
				dir=di[0];
			else
				dir=di[1];
		}
		else
		{
			System.out.printf("\n\n\t\t\tYour Turtle is Jammed at Boundries. It cannot turn left/right.\n\n\t\t\t\n\n\nUse Jam Cleaner to go further.");
		}
	}
	
	public void jamClear()
	{
		if(jam == true)
		{
			x=((int)(Math.random()*2000)-1000);
			y=((int)(Math.random()*2000)-1000);
			dir=di[(int)(Math.random()*3)];
		}
	}

}
