import java.util.*;




class Start  extends Thread
 {
	public Start() 
	{
	
	}
	int L;
	public Start(int l)
	 { 
		  
		  this.L=l;
	 }
   static Object obj1=new Object();
   static Object obj2=new  Object();
   static Object obj3=new Object();

   public static void main(String arg[]) 
   {
	   
	String firstthread="";
		
		try {
			firstthread = arg[0];
	    } catch (ArrayIndexOutOfBoundsException e) {
	    	System.out.println("Nothing");
		}
	    int p1=0;
	
		try 
		{			
		    p1=Integer.parseInt(firstthread);
		    if (p1<=0) {
			    System.out.println("otr znach");
				System.exit(1);
				
		    }		
		} catch(Exception e) {
			System.out.println("Wrong format");
		} 
	   
   Thread1 t1 = new Thread1(Integer.parseInt(firstthread));
   Thread t2 = new Thread2(Integer.parseInt(firstthread));
   Thread t3 = new Thread3(Integer.parseInt(firstthread));
   t1.start();
   t2.start();
   t3.start();
} 
void  umber(Object s1,Object s2,Object s3){
	
	
	 
    synchronized(s2){
                
                synchronized(s1){ 
               
           
                
                   s1.notify();
                   ///////////////System.out.println(Thread.currentThread().getName());
                 //  System.out.println("s1="+s1+" "+ Thread.currentThread().getName());
                  
                 }
                 try{
                      s2.wait();
                     //System.out.println("s2="+s2+" "+ Thread.currentThread().getName());
                    //  s3.wait();
                     //System.out.println("s3="+s3+" "+ Thread.currentThread().getName());
                      
                 }catch(Exception e){}   
                 
    
                
        
    }
}
 }    
/* public void run(){    
	 int j=0;
	 long l=System.nanoTime();
     for (int i=0;i<this.L;i++)
     {
    	 	
         if  ( this.getName().equals("Thread-0"))
         {
        
       
         
        

         
         }
         if ( this.getName().equals("Thread-1"))
         {   
    
         	
             
         }
             
         if  ( this.getName().equals("Thread-2"))
         {
        	
         }
         
      
 	  
    }}}*/

 



class Thread1 extends Start
{
	int L;
	public Thread1 (int l)
	 { 
		  
		  this.L=l;
	 }
	
	public void run()
	{    
		for (int i=0;i<this.L;i++)
		{
		 long curTime = System.currentTimeMillis();
	     //System.out.print(curTime+" ");
	    umber(obj2,obj3,obj1);  
	     System.out.println("1");
		}
	}
	
}

class Thread2 extends Start
{
	
	int L;
	public Thread2 (int l)
	 { 
		  
		  this.L=l;
	 }
	
	int j=0;
	public void run()
	{
		for (int i=0;i<this.L;i++)
		{
		 j++;
    	 //System.out.print(j+ " ");
         umber(obj1,obj2,obj3); 
         System.out.println("2");
		}
         
	}
	
}

class Thread3 extends Start
{
	int L;
	public Thread3 (int l)
	 { 
		  
		  this.L=l;
	 }
	public void run()
	{
	for (int i=0;i<this.L;i++)
	{
	long k=System.nanoTime();
   //System.out.print(k+" ");
	umber(obj3,obj1,obj2); 
    System.out.println("3");
	}
	
	}

}