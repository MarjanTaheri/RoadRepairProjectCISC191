// By importing i.o, time,and util classes we are allowing our Repair class to use their methods
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

//Repair extends the Roads class which means now Roads is a super class and repair is a subclass 
//Repair implements zoneable interface which means it is declaring that repair class will implement the methods and instance fields listed in zoneable interface
//Road has a Repair
//Repair is Zoneable
public class Repair extends Road implements Zonable
{

//	Repair has a workDate 	
	LocalDate workDate;
//	Repair has a workType		
	String workType;
//	Repair has a zoneNumber		
	int zoneNumber;
//	Repair has an array of roadIDs for Storing the elements that are going to be read from InspectionReport.txt file  		
	int[] roadID = new int[10];
//	Repair has an array of names for Storing the elements that are going to be read from InspectionReport.txt file  		
	String[] name = new String[10];
//	Repair has an array of pcis for Storing the elements that are going to be read from InspectionReport.txt file  		
	int[] pci = new int[10];
//	Repair has an array of types for Storing the elements that are going to be read from InspectionReport.txt file  			
	String[] type = new String[10];
//	Repair has an array of listedRanks for Storing the elements that are going to be read from InspectionReport.txt file  			
	String[] listedRank = new String[10];
//	Repair has an array of roadID for Storing the values of the objects that are subject to repair
	int[] idHolder= new int[2];
//	Repair has an array of typeHolder for Storing the values of the objects that are subject to repair	
	String[] typeHolder = new String[2];



	

//	Overloaded constructor of the class
	public Repair(String name,int ID,int lanes, RoadType roadType,LocalDate date,String type) 
	{
		super(name,ID,lanes,roadType);
		workDate = date;
		workType = type;

	}
//	default constructor	
	public Repair()
	{

	}	
	public void setWorkDate(LocalDate date)
	{
		workDate = date;
	}
	
	public void setWorkType(String type)
	{
		workType = type;
	}
	
	public LocalDate getWorkDate()
	{
		return workDate;
	}
	
	public String getWorkType()
	{
		return workType;
	}
	public void setIDholder(int[] id)
	{
		idHolder = id;
	}
	public void setTypeHolder(String[] type)
	{
		typeHolder = type;
	}
	public int[] getIDholder()
	{
		return idHolder;
	}
	public String[] getTypeHolder()
	{
		return typeHolder;
	}
//	This method determines each street blongs to which zone
	public int zonable(int id)
	{

		if(id>=10 && id<=12)
		{
			zoneNumber = 1; 
		}
		else if(id>12 && id<=15)
		{
			zoneNumber = 2;
		}
		else
		{
			zoneNumber = 3;
		}	
		return zoneNumber;	
	}

//	this method reads the file InspectionReport.txt and splits each element by "," and stores it in appropriate array, then finds the roads that need to be repaired and repairs them  
	public void repairReport() throws FileNotFoundException
	{
		System.out.println("\n\n"+"Repair Report List"+"\n"+"--------------------------------------------------------");
		try 
		{
			File file = new File("C:\\Users\\18587\\Desktop\\InspectionReport.txt");
			Scanner sc = new Scanner(file,"UTF-8");
//			line is a variable that saves each line after reading from the file
			String line;	
//			temp is an array of Strings that saves each element of the line after splitting 			
			String[] temp;
			int i=0;
			int j=0;

//			while the file has a new line the codes in while loop will be executed
			while(sc.hasNextLine())
			{
//				reads a new line and stores it in line variable				
				line = sc.nextLine();
//				temp is an array of Strings that saves each element of the line after splitting 					
				temp= line.split(",");
//				saves the first element of the temp array with in roadID[i] after converting it from String type to integer type				
				roadID[i] = Integer.parseInt(temp[0]);  
//				saves the second element of the temp array with in name[i] 					
				name[i] = temp[1];
//				saves the third element of the temp array with in pci[i] after converting it from String type to integer type		
				pci[i] =  Integer.parseInt(temp[2]);
//				saves the forth element of the temp array with in type[i] 					
				type[i] = temp[3];
//				saves the fifth element of the temp array with in listedRank[i] 						
				listedRank[i] = temp[4];
//				if the value of listedRank[i] is equal to "Poor" then the set of the code in {} will be executed			
				if(listedRank[i].equals("Poor"))
				{			
//				    saves the value of roadID[i] to idHolder[j] since I used this value for calculating the cost 
					idHolder[j] = roadID[i];
//				    saves the value of roadID[i] to typeHolder[j] since I used this value for calculating the cost 					
					typeHolder[j] = type[i];
//					changes the value of listedRank[i] to "Excellent" as a part of the repair process 					
					listedRank[i] = "Excellent";
//		      		the next two lines set the workDate to the current date
					workDate = LocalDate.now();
					setWorkDate(workDate);
					
//					print the repair report					
					System.out.println("RoadID: "+roadID[i]+"   Road Name: "+name[i]+"   Pavement Index: 100"+"   Laste Repair Date: "+getWorkDate());
					j++;
				}
			}
			sc.close();
		}
//		if any I/O exception throws the message will be printed 		
		catch(Exception e)  
		{
			System.out.println(e.getMessage());
		}

	}
}
