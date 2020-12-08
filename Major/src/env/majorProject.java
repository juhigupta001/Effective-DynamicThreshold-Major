package env;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class majorProject {
	static Datacenter dc;
	static Host h1, h2;
	static ArrayList<Vm> vmList;
	static ArrayList<Double> curr_util;
	static ArrayList<Double> pred_util = new ArrayList<>();
<<<<<<< HEAD
	static int noOfVM;
=======
	static ArrayList<Double> P_temp = new ArrayList<>();
	static ArrayList<Double> C_temp = new ArrayList<>();
>>>>>>> fa9bf8945db12ddca797cdf6889437213c179980

	public static void Datacentre() {
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
		noOfVM = 5;
		ArrayList<Vm> list = new ArrayList<>();
		Vm v1 = new Vm(1, 12.5, 200, 20, 200);

		System.out.println("VM 1 created successfully");
		Vm v2 = new Vm(1, 15.4, 200, 20, 100);

		System.out.println("VM 2 created successfully");
		Vm v3 = new Vm(1, 2, 100, 20, 120);

		System.out.println("VM 3 created successfully");
		Vm v4 = new Vm(1, 5, 100, 20, 150);

		System.out.println("VM 4 created successfully");
		Vm v5 = new Vm(1, 1, 50, 20, 136);

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

	public static void CreateHost() {
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

	public static void AllocateTask(Queue<Task> q) {
		vmList = CreateVm();
		System.out.println(q);
		for (Vm vm : vmList) {
			long size = vm.getSize();
			System.out.println(vm.getId());
			while (size > 0) {
				//System.out.println(size + "hi " + q.peek().getTaskLength());
				if (q.peek().getTaskLength() <= size) {
					Task t = q.poll();
					size = size - t.getTaskLength();
					t.vmId = vm.getId();
					vm.gettotalTasks().add(t);
				} else
					break;

			}
		}
		System.out.println("--------------------");
		System.out.println("   Tasks Allocated To VMs    ");
		for (Vm vm : vmList) {
			System.out.println(vm.getId() + " -> " + vm.gettotalTasks());
		}
	}

	// in MIPS
	public static long gettaskCompleted(int vm, int t) {

		int timeCompleted = vmList.get(vm).getTimeSinceVmRunning();
		// System.out.println(timeCompleted);
		long taskCompleted = (long) (vmList.get(vm).getTotalTaskLength() - (timeCompleted * vmList.get(vm).getMips()));
		// System.out.println(vmList.get(vm).getTotalTaskLength()+" "+taskCompleted);
		return taskCompleted;

	}

//time is in ms
	public static void CalculateCurrentUtilization() {
		Queue<Task> q = new LinkedList<>();
		q.add(new Task(1, 80, 1000));
		q.add(new Task(2, 65, 1000));
		q.add(new Task(3, 93, 1000));
		q.add(new Task(4, 80, 1000));
		q.add(new Task(6, 70, 1000));
		q.add(new Task(7, 73, 1000));
		q.add(new Task(8, 45, 1000));
		q.add(new Task(9, 60, 1000));
		q.add(new Task(10, 55, 1000));

		AllocateTask(q);
		double currentUtilization[][] = new double[noOfVM][noOfVM];
		for (int vm = 0; vm < noOfVM; vm++) {
			for (int t = 0; t < noOfVM; t++) {
				double taskCompleted = gettaskCompleted(vm, t);
				double totalTask = vmList.get(vm).getTotalTaskLength();
				//System.out.println(taskCompleted+" hh"+totalTask);
				currentUtilization[vm][t] = (taskCompleted / totalTask) * 100;

			}
		}
		System.out.println("----------Current Utilization Matrix------------");
		
		for (int vm = 0; vm < noOfVM; vm++) {
			for (int t = 0; t < noOfVM; t++) {
				System.out.print(currentUtilization[vm][t] + "	");
			}
			System.out.println();
		}

	}

	public void currUtilisationPm() {

		// calculate curr_util array

	}

	public static void predict_utilisation() {
		// ArrayList<Double> curr_util = new ArrayList<>();
		// curr_util.add((double) 200);
		// curr_util.add((double) 400);
		// curr_util.add((double) 100);

		// mean
		double Y_mean = 0;
		for (int j = 0; j < curr_util.size(); j++) {
			Y_mean = Y_mean + curr_util.get(j);
		}

		Y_mean = Y_mean / curr_util.size();

		// variance

		double cov = 0;
		for (int j = 0; j < curr_util.size(); j++) {
			cov = cov + (long) Math.pow((curr_util.get(j) - Y_mean), 2);
		}

		cov = cov / (curr_util.size() - 1);

		ArrayList<Double> acc_List = new ArrayList<>();

		for (int j = 0; j < curr_util.size(); j++) {

			double Y_h = 0;

			for (int i = j + 1; i < curr_util.size(); i++) {
				Y_h = Y_h + (curr_util.get(i) - Y_mean) * (curr_util.get(i - j) - Y_mean);
			}
			Y_h = Y_h / curr_util.size();

			double acc = Y_h / cov;

			acc_List.add(Math.abs(acc));
		}

		System.out.println(acc_List);

		// predict utilization

		pred_util.add(curr_util.get(0));

		for (int i = 1; i < curr_util.size(); i++) {
			double predictedVal = 0;

			for (int j = 0; j < i; j++) {

				predictedVal = predictedVal + curr_util.get(j) * acc_List.get(j);

			}
			pred_util.add(predictedVal);

		}

		System.out.println(pred_util);

	}
<<<<<<< HEAD

=======
	
		
	public static void calculateP_temp()
	{
				
		for(int i=0;i<curr_util.size();i++)
		{
			double ptemp = pred_util.get(i)-curr_util.get(i);
			P_temp.add(ptemp);
		}
	}
	
	public static void calculateC_temp()
	{
				
		//calculate C_temp
	}
	
	

	
	
	
	
	
	
>>>>>>> fa9bf8945db12ddca797cdf6889437213c179980
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Datacentre();
		CreateHost();
		CreateVm();
		CalculateCurrentUtilization();

	}
}
