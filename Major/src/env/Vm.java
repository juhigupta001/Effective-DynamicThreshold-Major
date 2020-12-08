package env;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vm {

	private int id;

	private long size;

	private double mips;

	private double execStartTime;
	private int ram;

	protected Host host;

	private List<Task> totalTasks;

	public Vm(int id, double mips, int ram, long bw, long size) {
		setId(id);
		setMips(mips);
		setRam(ram);
		setSize(size);
		setExectutionTime();
		settotalTasks();

	}

	private void settotalTasks() {
		// TODO Auto-generated method stub
		totalTasks = new ArrayList<>();

	}

	private void setExectutionTime() {
		execStartTime = System.currentTimeMillis();

	}

	protected List<Task> gettotalTasks() {

		return totalTasks;

	}

	protected int getTimeSinceVmRunning() {
		int val=(int)(System.currentTimeMillis() - execStartTime);
		return 2;
	}

	protected long getTotalTaskLength() {
		// in MIPS
		long task = 0;
		for (Task t : this.gettotalTasks())
			task += t.getTaskLength();
		return task;
	}

	protected void addTask() {

	}

	protected void setId(int id) {
		this.id = id;
	}

	protected int getId() {
		return this.id;
	}

	public double getMips() {
		return mips;
	}

	protected void setMips(double mips) {
		this.mips = mips;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Host getHost() {
		return host;
	}

}
