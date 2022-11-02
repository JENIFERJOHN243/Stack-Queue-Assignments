import java.util.LinkedList;
import java.util.Queue;

public class InterviewPanelUsingQueue {

	public static void main(String[] args) throws InterruptedException {
		setQueue();
	}

	private static void setQueue() throws InterruptedException {
		Queue<String> candidateQueue = new LinkedList<>();
		candidateQueue.add("Mahi");
		candidateQueue.add("Jeni");
		candidateQueue.add("Kaviya");
		candidateQueue.add("Yogi");
		candidateQueue.add("Surya");
		candidateQueue.add("Mani");
		candidateQueue.add("Subha");
		candidateQueue.add("Arun");
		System.out.println("Candidates In Queue");
		System.out.println(candidateQueue);
		System.out.println();
		waitingRoom(candidateQueue);
	}

	private static void waitingRoom(Queue<String> candidateQueue) throws InterruptedException {
		Queue<String> waitingRoomQueue = new LinkedList<>();
			for(int index=waitingRoomQueue.size();index<5;index++) {
				waitingRoomQueue.add(candidateQueue.poll());
				}
			Thread.sleep(2000);
		System.out.println("Candidates In Waiting Room");
		System.out.println(waitingRoomQueue);
		System.out.println();
		callingHrPanel(waitingRoomQueue,candidateQueue);	
		
	}

	private static void callingHrPanel(Queue<String> waitingRoomQueue,Queue<String> candidateQueue) throws InterruptedException {
		while(candidateQueue.size()!=0 || waitingRoomQueue.size()!=0) {
		System.out.println("Candidate In HR Panel :"+waitingRoomQueue.poll());
		System.out.println();
		Thread.sleep(2000);
		if(waitingRoomQueue.size()<5) {
			if(!candidateQueue.isEmpty()) {
			waitingRoomQueue.add(candidateQueue.poll());
			}
		}
		if(waitingRoomQueue.isEmpty()) {
			System.out.println("Interview Got Over");
			System.exit(0);
		}
		System.out.println("Candidates In Waiting Room");
	    System.out.println(waitingRoomQueue);
	    System.out.println();
	}
		}
}
