import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class CommandExecutor {
	private String[] command;
	private String[] stackArray;
	private String[] queueArray;
	private String sfile= "stack.txt";
	private String qfile= "queue.txt";

	Stack<Integer> stack= new Stack<Integer>(100);
	Queue queue= new Queue(100);
	
	public CommandExecutor(String name) {
		this.command=readFile(name);   // reads command.txt
		this.queueArray=readFile(qfile); // reads queue.txt
		this.stackArray=readFile(sfile); // reads stack.txt
		commandExecutor();
		
	}
	
	// read files
	public static String[] readFile(String path){
		try {
			int i=0;
			int length= Files.readAllLines(Paths.get(path)).size();
			String[] results= new String[length];
				for (String line: Files.readAllLines(Paths.get(path))) {
					results[i++]=line;
				}
			return results;
			
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void commandExecutor() {
		try {
			
			// create out files and writes
			FileWriter outS = new FileWriter("stackOut.txt"); 
			FileWriter outQ = new FileWriter("queueOut.txt");
			stackCreator(); // push elements from file into stack
			queueCreator(); // push elements from file into queue
			
			for(String lines : command) {
				String[] line = lines.split(" ");
				String type= line[0];
				switch(type) {
					case "Q": 
						//queue operations
						
						if(line[1].equalsIgnoreCase("removeGreater")) {
							
							Queue newQueue= new Queue(100);
							int greatNum= Integer.parseInt(line[2]);
							int size= queue.size();
							for(int i=0; i<size; i++) {
								if(queue.top()> greatNum) {
									queue.dequeue();
								} 
								else {
									newQueue.enqueue(queue.top());
									queue.dequeue();
								}
							}
							String str="After removeGreater "+line[2]+":\n";
							outQ.write(str);
							while(!newQueue.isEmpty()) {
								outQ.write(newQueue.top()+" ");
								queue.enqueue(newQueue.top());
								newQueue.dequeue();
								
							}
							outQ.write("\n");				
							
							
							
						}
						if(line[1].equals("calculateDistance")) {
							ArrayList<Integer> elements= new ArrayList<Integer>();
							Queue temp1= new Queue(100);
							
							Queue temp3= new Queue(100);
							while(!queue.isEmpty()) {
								temp1.enqueue(queue.top());
								
								temp3.enqueue(queue.top());
								elements.add(queue.top());
								queue.dequeue();
							
							}
							int distance=0;
							int j=0;
							
							while(!temp1.isEmpty()) { // 1 2 3 4
								elements.remove(j);
							
								for(int i=0; i<elements.size(); i++) {
									distance += Math.abs(temp1.top()-elements.get(i));
									
								}
													
								
								temp1.dequeue();		
								
								
								
							}
							
							String str="After calculateDistance: \nTotal distance=";
							
							outQ.write(str+distance+"\n");
							while(!temp3.isEmpty()) {
								queue.enqueue(temp3.top());
								
								temp3.dequeue();
							
							}
							
							
						}
						if(line[1].equals("addOrRemove")) {
							Queue temp= new Queue(100);
							int a= Integer.parseInt(line[2]);
							if(a<0) {
								a*= -1;
								while(a>0) {
									queue.dequeue();								
									a--;
								}
								
								
							}
							else {							
								while(a>0) {
									int random = (int)(Math.random() * 50+1);
									temp.enqueue(random);
									
									a--;
								}
								
								
								
							}
							while(!queue.isEmpty()) {
								int num= queue.top();
								queue.dequeue();
								temp.enqueue(num);
							}
							String str="After addOrRemove "+line[2]+":\n";
							outQ.write(str);
							while(!temp.isEmpty()) {
								int num= temp.top();
								temp.dequeue();
								outQ.write(num+" ");
								queue.enqueue(num);
							}
							outQ.write("\n");
							
							
						}
						
						// command to reverse first few numbers of the queue
						if(line[1].equals("reverse")) {
							int a= Integer.parseInt(line[2]);
							Stack<Integer> tmp = new Stack<>(100); 
							Queue temp=new Queue(100);
							for(int i=0; i<a; i++) {
								tmp.push((queue.top())); 
								queue.dequeue(); 
								
								
							}
							String str="After reverse "+line[2]+":\n";
							outQ.write(str);
							while(!tmp.isEmpty()) {
								temp.enqueue(tmp.pop());
							}
							while(!queue.isEmpty()) {
								temp.enqueue(queue.top());
								queue.dequeue();
							}
							while(!temp.isEmpty()) {
								queue.enqueue(temp.top());
								outQ.write(temp.top()+" ");
								temp.dequeue();
								
							}
							outQ.write("\n");

							
							
							
							
						}
						// sort elements of the queue
						if(line[1].equals("sortElements")) {
							Queue temp= new Queue(100);
							sortQueue(queue);
							while(!queue.isEmpty()) {
								temp.enqueue(queue.top());
								queue.dequeue();
							}
							String str="After sortElements:\n";
							outQ.write(str);
							while(!temp.isEmpty()) {
								queue.enqueue(temp.top());
								outQ.write(temp.top()+" ");
								temp.dequeue();
								
							}
							outQ.write("\n");
						
							
							
						}
						
						if(line[1].equals("distinctElements")) {
							Queue temp1= new Queue(100);
							Queue temp2= new Queue(100);
							while(!queue.isEmpty()) {
								temp1.enqueue(queue.top());
								temp2.enqueue(queue.top());
								queue.dequeue();
							
							}
							sortQueue(temp2);
							
							ArrayList<Integer> repeated= new ArrayList<Integer>();
							int size=temp2.size(); 
							
							for(int i=1; i<size; i++ ) {
								int a=temp2.top();
								temp2.dequeue();
								int b=temp2.top();
													
								if(a==b) {
									repeated.add(a);
									System.out.println(repeated);
															
								}								
							
							}
							
							
							
							while(!temp1.isEmpty()) {
								queue.enqueue(temp1.top());
								temp1.dequeue();
							
							}
							int distinct= queue.size()-repeated.size();
							System.out.println(distinct+" d");
							String str="After distinctElements:\nTotal distinct element=";
							outQ.write(str+distinct+"\n");
							
						}
						
						break;
						
					case "S": //stack
						if(line[1].equals("removeGreater")) {
							Stack<Integer> temp= new Stack<Integer>(100);
							Stack<Integer> newStack= new Stack<Integer>(100);
							
							int greatNum= Integer.parseInt(line[2]);
							
							int size= stack.size();
							
							for(int i=0; i<size; i++) {
								if(stack.top()> greatNum) {
									stack.pop();
								} 
								else {
									int element= stack.top();
									newStack.push(element);
									stack.pop();
								}
							}
							String str="After removeGreater "+line[2]+":\n";
							outS.write(str);
							size= newStack.size();
							for(int i=0; i<size; i++) {
								int element= newStack.pop();
								stack.push(element);
								temp.push(element);
								
							}
							while(!temp.isEmpty()) {
								outS.write(temp.top()+" ");
								temp.pop();
							}
							outS.write("\n");
							
							
							
							
						}
						if(line[1].equals("calculateDistance")) { // 3 5 2 1

							Queue temp1 =new Queue(100);
							

							Stack<Integer> temp3= new Stack<Integer>(100);
							
							ArrayList<Integer> elements= new ArrayList<Integer>();
							
							while(!stack.isEmpty()) {
								temp1.enqueue(stack.top());
								
								temp3.push(stack.top());
								elements.add(stack.top());
								stack.pop();
							
							}
							int distance=0;
							int j=0;
							
							while(!temp1.isEmpty()) { // 1 2 3 4
								elements.remove(j);
							
								for(int i=0; i<elements.size(); i++) {
									distance += Math.abs(temp1.top()-elements.get(i));
									
								}
													
								
								temp1.dequeue();				
								
								
								
							}
							
							
							
							while(!temp3.isEmpty()) {
								stack.push(temp3.top());
								temp3.pop();
							
							}
							String str="After calculateDistance: \nTotal distance=";
							
							outS.write(str+distance+"\n");
							
							
												
						}
						
						if(line[1].equals("addOrRemove")) {
							Stack<Integer> temp= new Stack<Integer>(100);
							
							
							int a= Integer.parseInt(line[2]);
							if(a<0) {
								a*= -1;
								while(a>0) {
									stack.pop();
									
									a--;
								}						
								
							}else {
								
								while(a>0) {
									int random = (int)(Math.random() * 50+1);
									stack.push(random);
									a--;
								}
							}
							
							String str="After addOrRemove "+line[2]+":\n";
							outS.write(str);
							while(!stack.isEmpty()) {
								temp.push(stack.top());
								outS.write(stack.top()+" ");
								stack.pop();
								
								
							}
							outS.write("\n");
							while(!temp.isEmpty()) {
								stack.push(temp.pop());
							}
							
													
						}
						
						
						//method for reversing stacks first few elements
						
						if(line[1].equals("reverse")) {
							int a=Integer.parseInt(line[2]);
							Stack<Integer> newStack= new Stack<Integer>(100);
							Stack<Integer> temp= new Stack<Integer>(100);
							Stack<Integer> tmp= new Stack<Integer>(100);
							for(int i=0; i<a; i++) {
								int num= stack.pop();
								temp.push(num);
							}
							
							for(int i=0; i<a; i++) {
								int num= temp.pop();
								newStack.push(num);
							}
							for(int i=0; i<a; i++) {
								int num= newStack.pop();
								stack.push(num);
							}
							
							String str="After reverse "+line[2]+":\n";
							outS.write(str);
							while(!stack.isEmpty()) {
								tmp.push(stack.top());
								outS.write(stack.top()+" ");
								stack.pop();
								
								
							}
							outS.write("\n");
							while(!tmp.isEmpty()) {
								stack.push(tmp.pop());
							}
							
							
						}
						
						if(line[1].equals("sortElements")) {
							Stack<Integer> tmpStack = new Stack<Integer>(100); 
							Stack<Integer> tmp = new Stack<Integer>(100);
					        while(!stack.isEmpty()) 
					        { 
					            // pop out the first element 
					            int temp = stack.pop(); 
					          
					            // while temporary stack is not empty and 
					            // top of stack is greater than temp 
					            while(!tmpStack.isEmpty() && tmpStack.top()< temp) 
					            { 
					                // pop from temporary stack and  
					                // push it to the input stack 
					            stack.push(tmpStack.pop()); 
					            } 
					              
					            // push temp in tempory of stack 
					            tmpStack.push(temp); 
					        }
					        outS.write("After sortElements:\n");
					        while(!tmpStack.isEmpty()) {
					        	tmp.push(tmpStack.top());
					        	outS.write(tmpStack.top()+" ");
					        	tmpStack.pop();
					        }
					        outS.write("\n");
					    
					        while(!tmp.isEmpty()) {
					        	stack.push(tmp.pop());
					        	
					        }
							
					        
					        
						}
						if(line[1].equals("distinctElements")) {
							Stack<Integer> temp1 = new Stack<Integer>(100); //null
							Stack<Integer> temp2 = new Stack<Integer>(100); //4 3 2 1
							Stack<Integer> tmpStack = new Stack<Integer>(100); //sorted 1 2 3 4
							while(!stack.isEmpty()) { //1 2 3 4
								int num=stack.pop();
								temp1.push(num);
								temp2.push(num);							
							}
							while(!temp1.isEmpty()){ 
						        // pop out the first element 
						        int tmp = temp1.pop();
						            
						          
						            // while temporary stack is not empty and 
						            // top of stack is greater than temp 
						         while(!tmpStack.isEmpty() && tmpStack.top()< tmp){ 
						                // pop from temporary stack and  
						                // push it to the input stack 
						        	 temp1.push(tmpStack.pop()); 
						            
						          }   
						            // push temp in tempory of stack 
						           tmpStack.push(tmp);    
						             
						    }
							ArrayList<Integer> repeated= new ArrayList<Integer>();
							int size=tmpStack.size(); 
							
							for(int i=1; i<size; i++ ) {
								int a=tmpStack.pop();
								int b=tmpStack.top();
													
								if(a==b) {
									repeated.add(a);
									System.out.println(a);
															
								}								
							
							}
							
							
							while(!temp2.isEmpty()) { //1 2 3 4
								int num=temp2.pop();
								stack.push(num);							
							}
						int distinct= stack.size()-repeated.size();
						String str="After distinctElements:\nTotal distinct element=";
						outS.write(str+distinct+"\n");					
						}
						break;
					}
				
			}
			outQ.close();
			outS.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// Function to sort the given queue 
		static void sortQueue(Queue q) 
		{ 
		  
		    // Return if queue is empty 
		    if (q.isEmpty()) 
		        return; 
		  
		    int temp = q.top(); 
		  
		    // Remove the front element 
		    q.dequeue(); 
		  
		    sortQueue(q); 
		  
		    // Push the current element into the queue 
		    // according to the sorting order 
		    pushInQueue(q, temp, q.size()); 
		} 
	
	static void FrontToLast(Queue q, int qsize) 
	{ 
	    if (qsize <= 0) 
	        return; 
	  
	    
	    q.enqueue(q.top()); 
	    q.dequeue(); 
	  
	    // Recursive call for pushing element 
	    FrontToLast(q, qsize - 1); 
	} 
	  
	// Function to push an element in the queue 
	// while maintaining the sorted order 
	static void pushInQueue(Queue q,int temp, int qsize) 
	{ 
	  
	    // Base condition 
	    if (q.isEmpty() || qsize == 0)  
	    { 
	        q.enqueue(temp); 
	        return; 
	    } 
	  
	    // If current element is less than 
	    // the element at the front 
	    else if (temp <= q.top()) 
	    { 
	  
	        // Call stack with front of queue 
	        q.enqueue(temp); 
	  
	        // Recursive call for inserting a front 
	        // element of the queue to the last 
	        FrontToLast(q, qsize); 
	    } 
	    else 
	    { 
	  
	        // Push front element into 
	        // last in a queue 
	        q.enqueue(q.top()); 
	        q.dequeue(); 
	  
	        // Recursive call for pushing 
	        // element in a queue 
	        pushInQueue(q, temp, qsize - 1); 
	    } 
	} 
	  
		
	
	//read Stack file and put elements into a stack
	public void stackCreator(){
		Stack<Integer> temp= new Stack<Integer>(100);
		String[] numbers= stackArray[0].split(" ");
		for( String a : numbers) {
			int number = Integer.parseInt(a);
			temp.push(number);
		}
		int size=temp.size();
		for(int i=0; i<size; i++) {
			int num=temp.pop();
			stack.push(num);
		}
		
		
	}
	
	//read queue file and put elements into a queue 
	public void queueCreator() {
		String[] numbers= queueArray[0].split(" ");
		for( String a : numbers) {
			int i = Integer.parseInt(a);
			queue.enqueue(i);
		}
		
	
	}
	

}
