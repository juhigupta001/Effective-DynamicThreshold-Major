package env;

import java.util.ArrayList;
import java.util.List;

public class Datacenter {
	
	private int id;
	
	protected List<Host> hostList = new ArrayList<>();
	
	public Datacenter(
			int id) {
			setId(id);

	}
	
	
	public int getId() {
		return id;
	}

	
	protected void setId(int id) {
		this.id = id;
	}
	
	protected void allocateHost(Host h)
	{
		hostList.add(h);
		h.setDatacenter(this);
	}

}
