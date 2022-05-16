
// By importing i.o and time class we are allowing our Roads class to use their methods
import java.io.*;
import java.time.LocalDate;
public class Road     //declaring Roads class 
{
//	Roads has a roadName 
	private String roadName;
//	Roads has a roadID	
	private int roadID;
//	Roads has a numberOfLanes	
	private int numberOfLanes;
//	vehicle has an option(just a reference variable at this point) , RoadType and Roads classes have aggregation relationship         	
	private RoadType type; 
//  main constructor
	public Road() 
	{
	}
//  overloaded constructor
	public Road(String name,int ID,int lanes,RoadType roadType)
	{
		roadName = name;
		roadID = ID;
		numberOfLanes = lanes;
		this.type = roadType; 
	}
	public void setRoadType(RoadType roadType)
	{
		type = roadType;
	}
	public RoadType getRoadType()
	{
		return type;
	}
	public String getRoadName()
	{
		return roadName;
	}
	public int getRoadID()
	{
		return roadID;
	}
	public int getNumberOfLanes()
	{
		return numberOfLanes;
	}
//  Overriding String method here helped me pass the instance values of the class easier to other methods 	
	@Override
	public String toString()
	{
		return Integer.toString(roadID)+"\t"+roadName+"\t"+Integer.toString(numberOfLanes);
	}

	

	
	
	public static void main(String[] args) 
	{
// try keywords represents the handling of exceptions due to data or coding errors during program execution. 		
		try
		{
			
// 	     	BufferedWriter makes the process of writing on a file faster and File Writer from FileWriter class helps writing character-oriented data on a file
//			here I am creating two separate files, the first one holds a complete record of each road and the second one has just a few elements that get read by Repair class   		
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\18587\\Desktop\\List.txt"));
			BufferedWriter bwi = new BufferedWriter(new FileWriter("C:\\Users\\18587\\Desktop\\InspectionReport.txt"));
		



		
// 			insp is an array of reference variables to the InspectionReport class  
			InspectionReport[] insp= new InspectionReport[10];
// 			rep is a reference variable to the Repair class  	
			Repair rep=new Repair(); 
// 			cost is a reference variable to the CostReport class 		
			CostReport cost=new CostReport();
// 			pci is a reference variable to the PCI class 		
			PCI pci= new PCI();
//			menu is a reference variable to MainMenu class which it also runs the MainMenu method 
			MainMenu menu = new MainMenu();

// 			passing parameters to the overloaded constructor of InspectionReport class	
			insp[0]= new InspectionReport("canyon grove tr",0,1,new RoadType("local   "),LocalDate.of(2021,04,05),23,"AC ");
			insp[1]= new InspectionReport("carmel count rd",1,4,new RoadType("Art-Coll"),LocalDate.of(2021,04,05),56,"AC ");
			insp[2]= new InspectionReport("sage canyon    ",2,1,new RoadType("Park    "),LocalDate.of(2021,04,05),95,"PCC");
			insp[3]= new InspectionReport("Pilon PT       ",3,1,new RoadType("local   "),LocalDate.of(2021,04,05),80,"PCC");
			insp[4]= new InspectionReport("Kerwood CT     ",4,1,new RoadType("ally    "),LocalDate.of(2021,04,05),40,"PCC");
			insp[5]= new InspectionReport("Camarena Rd    ",5,2,new RoadType("local   "),LocalDate.of(2021,04,05),32,"ACO");
			insp[6]= new InspectionReport("Futura St      ",6,2,new RoadType("local   "),LocalDate.of(2021,04,05),45,"ACO");
			insp[7]= new InspectionReport("Via Candidz    ",7,2,new RoadType("local   "),LocalDate.of(2021,04,05),70,"AC ");
			insp[8]= new InspectionReport("Ocean Air Park ",8,1,new RoadType("Park    "),LocalDate.of(2021,04,05),45,"ACO");
			insp[9]= new InspectionReport("Cherry Hill Dr ",9,1,new RoadType("ally    "),LocalDate.of(2021,04,05),52,"ACO");

//			I used a for loop in order to write each of 9 objects of the array of objects of InspectionReport class into List.txt by toString() method and InspectionReport.txt by report() method
			for(int i = 0;i<10;i++)
			{
//			
				bw.write(insp[i].toString());
				bw.write("\n");
				bwi.write(insp[i].report());
				bwi.write("\n");
			}
			System.out.println("\n\n"+"List Of Roads"+"\n"+"--------------------------------------------------------");

//			this loop will print the return values of the most getter methods from the InspectionReport class and also zonable(int i) method from PCI class   			
			for(int j= 0;j<10;j++)
			{
				System.out.println("Road Id: "+insp[j].getRoadID()+"   Zone: "+pci.zonable(insp[j].getRoadID())+"   Road Name: "+insp[j].getRoadName()+"   Number of Lanes: "+insp[j].getNumberOfLanes()+"   Last Inspection Date: "+ insp[j].getInspectionDate()+"   Recommanded Type: "+ insp[j].getRecommandedType()+ "   Rank: "+insp[j].getRank());
			}


// 			after finishing the writing process in files we have to close them in order to prevent I/O errors 		
//			It is important to close the files after writing on them and before reading the same file to prevent I/O errors 
			bw.close();
			bwi.close();

//			This code runs the repairReport() method from Repair class 					
			rep.repairReport();
			
//			This method runs the cost method() from CostReport class			
			cost.cost(rep.getIDholder(),rep.getTypeHolder());
		}
//		in case an error throws during program execution the catch block will be executed instead of terminating the execution of the code and getting compile error. 	
		catch(Exception e)	
		{
			System.out.println(e+e.getMessage());
		}		

	}

}

