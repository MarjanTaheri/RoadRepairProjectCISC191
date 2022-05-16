// By importing time class we are allowing our Inspection class to use its methods
import java.time.LocalDate;

// Inspection class extends the Roads class which means now Roads is a super class and Inspection is a subclass 
// Inspection class implements Rankeable interface which means it is declaring that Inspection class will implement the methods and instance fields listed in Raneable interface 
// Inspection is Rankeable
public class Inspection extends Road implements Rankeable
{

// 	Inspection has a inspectionDate	
	private LocalDate inspectionDate;
//	Inspection has a recommandedType
	private String recommandedType;
//	Inspection has a rank
	private String rank;
//	Inspection has a pavementConditionIndex
	private int pavementConditionIndex;
	
	public Inspection()
	{
		
	}
	
//  Overloaded constructor of the Inspection class 	
	public Inspection(String name,int ID,int lanes,RoadType RoadType,LocalDate inspDate,int condition,String type) 
	{
		super(name,ID,lanes,RoadType);
		inspectionDate = inspDate;
		recommandedType = type;
		pavementConditionIndex = condition;
	}
	
	public LocalDate getInspectionDate()
	{
		return inspectionDate;
	}
	
	public String getRecommandedType()
	{
		return recommandedType;
	}
	public int getPavementConditionIndex()
	{
		return pavementConditionIndex;
	}
	
//  Overriding String method here helped me pass the instance values of the class easier to other methods 	
	@Override
	public String toString()
	{
		return super.toString()+"\t"+getInspectionDate().toString()+"\t"+getRecommandedType()+"\t"+getPavementConditionIndex()+"\t"+getRank();
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
}
