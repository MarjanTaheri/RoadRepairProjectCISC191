
//Rankeable is an interface that PCI and Inspection classes implemented its methods 
// Rankeable interface specifies the list of the methods that classes that implement this interface must provide code for. 
//PCI is Rankeable
//Repair is Rankeable
public interface Rankeable 
{
	int rank = 0;
	public String getRank();
}
