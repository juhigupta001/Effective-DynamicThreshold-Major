package env;

import java.util.ArrayList;
import java.util.List;




//import org.cloudbus.cloudsim.Vm;

public class Host {
	
	
	/** The vm list. */
	private final List<Vm> vmList = new ArrayList<Vm>();

	private Datacenter datacenter;
	
	private int id;
	
		
	 
		public Host(
				int id) {
			setId(id);
			
		}
		
		public int getId() {
			return id;
		}

		
		protected void setId(int id) {
			this.id = id;
		}
		
		protected void allocateVm(Vm v)
		{
			vmList.add(v);
			v.host = this;
		}
		
		public Datacenter getDatacenter() {
			return datacenter;
		}

		
		public void setDatacenter(Datacenter datacenter) {
			this.datacenter = datacenter;
		}
		
		

}
