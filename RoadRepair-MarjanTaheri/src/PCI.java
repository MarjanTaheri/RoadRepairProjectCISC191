
// PCI class extends the Roads class which means now Roads is a super class and PCI is a subclass 
// PCI class implements Rankeable and zoneable interface which means it is declaring that PCI class will implement the methods and instance fields listed in Rankeable and zoneable interfaces 
// PCI Road has a PCI
// PCI is Rankeable and is Zoneable
public class PCI extends Road implements Rankeable,Zonable
{

//	PCI has a pavementConditionIndex
	int pavementConditionIndex;
//	PCI has a zoneNumber	
	int zoneNumber;
//	PCI has a rank	
	String rank;

//	Overloaded constructor of PCI class
	public PCI(String name,int ID,int lanes,RoadType roadType, int condition) 
	{
		super(name,ID,lanes,roadType);

		pavementConditionIndex = condition;
		
	}
//	default constructor	
	public PCI()
	{
		
	}
//	By evaluating the PCI index this method will rank the condition of each road 		
	public String getRank() 
	{
		if(pavementConditionIndex>=86 && pavementConditionIndex<=100)
		{
			rank = "Excellent";
		}
		else if(pavementConditionIndex>=56 && pavementConditionIndex<=85)
		{
			rank = "Good";
		}
		else if(pavementConditionIndex>=35 && pavementConditionIndex<=55)
		{
			rank = "Fair";
		}
		else if(pavementConditionIndex>=0 && pavementConditionIndex<=35)
		{
			rank = "Poor";
		}
		return rank;
	}	
//	This method determines each street blongs to which zone	
	public int zonable(int id)
	{
		if(id<=3)
		{
			zoneNumber = 1; 
		}
		else if(id>3 && id<=6)
		{
			zoneNumber = 2;
		}
		else
		{
			zoneNumber = 3;
		}	
		return zoneNumber;
			
	}



}
