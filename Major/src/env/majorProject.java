package env;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class majorProject {
	static Datacenter dc;
	static Host h1, h2;
	static ArrayList<Vm> vmList;

	public static void Createhost() {
		System.out.println(
				"----------------------------------------CREATE DATACENTER--------------------------------------------");

		dc = new Datacenter(1);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Datacenter 1 created successfully");
		System.out.println();
		System.out.println();

	}

	public static ArrayList<Vm> CreateVm() {
		System.out.println(
				"----------------------------------------CREATE VM--------------------------------------------");
		ArrayList<Vm> list = new ArrayList<>();
		Vm v1 = new Vm(1, 10000, 100, 20, 0);

		System.out.println("VM 1 created successfully");
		Vm v2 = new Vm(1, 10000, 100, 20, 0);

		System.out.println("VM 2 created successfully");
		Vm v3 = new Vm(1, 10000, 100, 20, 0);

		System.out.println("VM 3 created successfully");
		Vm v4 = new Vm(1, 10000, 100, 20, 0);

		System.out.println("VM 4 created successfully");
		Vm v5 = new Vm(1, 10000, 100, 20, 0);

		System.out.println("VM 5 created successfully");
		System.out.println();

		System.out.println("VM 1 allocated to Host 1 successfully");
		h1.allocateVm(v1);
		System.out.println("VM 2 allocated to Host 2 successfully");
		h2.allocateVm(v2);
		System.out.println("VM 3 allocated to Host 1 successfully");
		h1.allocateVm(v3);
		System.out.println("VM 4 allocated to Host 2 successfully");
		h2.allocateVm(v4);
		System.out.println("VM 5 allocated to Host 2 successfully");
		h2.allocateVm(v5);
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);

		return list;

	}

	public void CreateHost() {
		System.out.println(
				"----------------------------------------CREATE HOST--------------------------------------------");
		h1 = new Host(1);

		System.out.println("Host 1 created successfully");
		System.out.println();

		h2 = new Host(2);

		System.out.println("Host 2 created successfully");
		System.out.println();
		System.out.println("Host 1 allocated to DC 1 successfully");
		dc.allocateHost(h1);
		System.out.println("Host 2 allocated to DC 2 successfully");
		dc.allocateHost(h2);

	}

	public static void cr() {

		// 1 Allocate task to VMs
		// now we have tasks assigned to a Vm
		// Assign processor attribute to vm class
		// make a getcurrenttask function
//		{
//			//get time from the time vm is started 
//			//return (total task)-(time*processor speed)
//			
//		}
		// 2 make a function to sum of each colum
		// 3 predicted utlization
		// 4 COG

	}

	public void AllocateTask(Queue<Task> q) {
		vmList = CreateVm();
		for (Vm vm : vmList) {
			long size = vm.getSize();
			while (size > 0) {
				size = size - q.peek().getTaskLength();
				q.peek().vmId = vm.getId();
				vm.totalTasks.add(q.remove());
			}
		}
	}

	// in MIPS
	public long gettaskCompleted(int vm, int t) {

		double timeCompleted = vmList.get(vm).getTimeSinceVmRunning();
		long taskCompleted = (long) (vmList.get(vm).getTotalTaskLength()
				- (timeCompleted * vmList.get(vm).getMips()));
		return taskCompleted;

	}

	public void CalculateCurrentUtilization() {
		Queue<Task> q = new LinkedList<>();
		q.add(new Task(1, 100, 1000));
		q.add(new Task(2, 100, 1000));
		q.add(new Task(3, 100, 1000));
		q.add(new Task(4, 100, 1000));
		q.add(new Task(5, 100, 1000));

		AllocateTask(q);
		long currentUtilization[][] = new long[5][5];
		for (int vm = 0; vm < 5; vm++) {
			for (int t = 0; t < 5; t++) {
				long taskCompleted = gettaskCompleted(vm, t);
				long totalTask = vmList.get(vm).getTotalTaskLength();
				currentUtilization[vm][t] = (taskCompleted / totalTask) * 100;

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}