// By importing time class we are allowing our Inspection class to use its methods
import java.time.LocalDate;

public class CostReport extends Repair
{

//  CostReport has an array of	costs
	private double[] cost =new double[2];
//  CostReport has an array of	workTs	
	private String[] workT=new String[2];
//  CostReport has a costofAC	
	private final double costofAC = 2.4;
//  CostReport has a costofACO		
	private final double costofACO = 1.6;
//  CostReport has a costofPCC		
	private final double costofPCC=10.0;
//  CostReport has an array of	area saving the values of width and lengths of streets
	private int[][] area = {{240,251},{54,545},{548,84},{8484,51},{5465,6548},{54,64},{14,65},{448,516},{1516,89},{564,651}};	
//  CostReport has an array of ids	
	private int[] id =new int[2];
	
	public CostReport(String name,int ID,int lanes, RoadType roadType,LocalDate date,String workType)
	{
		super(name,ID,lanes,roadType,date,workType);
	}
	public CostReport()
	{
		
	}

//	this method calculates the repair cost by determining the type of the material used and the area of the repaired street in Sq^2  	
	public void cost(int[] passedID,String[] pasedType)
	{
		
		System.out.println("\n\n"+"Repair Cost per Street"+"\n"+"---------------------------------------------------");
		for(int j=0;j<2;j++)
		{
		
		if(pasedType[j].equals("AC "))
		{
				cost[j] =area[passedID[j]][0]*area[passedID[j]][1] *costofAC;
		}	
		else if(pasedType[j].equals("ACO"))
				{
			cost[j] = area[passedID[j]][0]*area[passedID[j]][1] *costofACO;
				}
		else if(pasedType[j].equals("PCC"))
		{
			cost[j] = area[passedID[j]][0]*area[passedID[j]][1] *costofPCC;
		}
		else
		{
		System.out.println("wrong type of work!");	
		}

		System.out.println("Road ID:"+passedID[j]+"   Repaired Type: "+pasedType[j]+"   Width of the area(ft^2): "+area[passedID[j]][0]+"   lenght of the area(ft^2): "+area[passedID[j]][1]+"   Final Cost  "+cost[j]+" $");
		
		}

		
	}
	
	

}
