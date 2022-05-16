import java.time.LocalDate;

//InspectionReport class extends the Inspection class which means now Inspection is a super class and InspectionReport is a subclass 
//Inspection has an InspectionReport
public class InspectionReport extends Inspection 
{
	
//	Overloaded constructor of InspectionReport class
	public InspectionReport(String name,int ID,int lanes,RoadType type, LocalDate inspDate,int condition,String typee)
	{
		super(name,ID,lanes,type,inspDate,condition,typee);
	}

//	Overrided toString() method makes the process of passing the elements of the object to other classes easier	
	@Override
	public String toString()
	{
		return super.toString();
	}
//	this method is used to pass the elements to the method who is responsible to write into InspectionReport.txt	
	public String report()
	{
		
		return super.getRoadID()+","+super.getRoadName()+","+super.getPavementConditionIndex()+","+super.getRecommandedType()+","+super.getRank();
	}

}
