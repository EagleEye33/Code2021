import java.text.DecimalFormat;
public class Model {

	private String modelName;
	private double cpuSpeed;
	private int ramSize;

	//Default Constructor
		public Model()
		{
			this.modelName = "?";
			this.cpuSpeed = 0.0;
			this.ramSize = 0;
		}
		//access and mutator methods
		public String getModel()
		{
			return modelName;
		}
		
		public double getCPU()
		{
			return cpuSpeed;
		}
		
		public int getRAM()
		{
			return ramSize;
		}
		
		public void setModel(String newModel)
		{
			modelName = newModel;
		}
		
		public void setCPU(double newCPU)
		{
			cpuSpeed = newCPU;
		}
		
		public void setRAM(int newRam)
		{
			ramSize = newRam;
		}
		
		public String toString()
		{
			DecimalFormat df = new DecimalFormat("0.00");
			 return ("Model:\t" + modelName + "\nCPU:\t" + df.format(cpuSpeed)+"GHz" + "\nRAM:\t" + ramSize+"GB");
		}
}
