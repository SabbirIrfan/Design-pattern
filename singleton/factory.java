import java.util.Random;


class simplethread implements Runnable{
    String name;

    simplethread(String name){
        this.name = name;

    }
    @Override
    public void run() {
        chocolateboiler boiler = chocolateboiler.getuniqueboiler("using thread");

        boiler.fill();
        boiler.boil();;
        boiler.fill();
        boiler.boil();
        // boiler.drain();
        
    }
}

class chocolateboiler{
    private boolean empty = true, boiled= false;
    public boolean isempty(){
        return empty;
    }

    public boolean isboiled(){
        return boiled;
    }

    int signature;
    
    private static chocolateboiler uniquChocolateboiler = null;
    private chocolateboiler(){
        empty = true;
        boiled = false;
        signature = new Random().nextInt(1000000);

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("created boiler at>>" + this +"\n");
        }
    }
    public String getStatus(String msg){
        return msg+ " <> " + this + " < empty: " + this.empty + " boiled: " + this.boiled + ">";
    }

        /*
        public synchronized static chocolateboiler getuniqueboiler(String msg){
            if(uniquChocolateboiler == null){
                System.out.println(msg + " Sync method : Creating chocolateboiler for the first and last time");
                uniquChocolateboiler = new chocolateboiler();
            }
            else{
                System.out.println(msg + " Unique instance exists!!!");
            }
            return uniquChocolateboiler;
        }

        syncronised mathod is not optimised for class as it engages the full class 
        */

        public  static chocolateboiler getuniqueboiler(String msg){
          
                synchronized(chocolateboiler.class){
                    if(uniquChocolateboiler == null){
                        System.out.println(msg + " Sync method : Creating chocolateboiler for the first and last time");
                        uniquChocolateboiler = new chocolateboiler();
                    }
                    else{
                        System.out.println(msg + " Unique instance exists!!!");
                    }
                }
            
           
            return uniquChocolateboiler;
        }


    
    public synchronized void fill(){
        if(isempty()){
            System.out.println(this + " >> filling chocolate and milk");
            empty = false;
        }
        else{
            System.out.println(this + " >> can't fill because boiler is not empty");
        }
    }

    public synchronized void boil(){
        if(!isempty() && !isboiled()){
            System.out.println(this + " >> boiling chocolate and milk");
            boiled = true;
        }
        else{
            if(isempty()) System.out.println("Can't boil beacuse boiler is empty");
            else System.out.println(this + " >> can't boil because already boiled");
        }
    }
    public synchronized void drain(){
        if(!isempty() && isboiled()){
            System.out.println(this + " >> Draining chocolate bars");
            empty = true;
            boiled = false;
        }
        else{
            if(isempty()) System.out.println("Can't drain beacuse boiler is empty");
            else System.out.println(this + " >> can't drain because not boiled yet");
        }
    }

    
}


public class factory{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new simplethread("thread1"));
        Thread thread2 = new Thread(new simplethread("thread2"));

        thread1.start();
        thread2.start();
        // chocolateboiler uniChocolateboiler = chocolateboiler.getuniqueboiler("this is a msg");
        // chocolateboiler uniChocolateboiler2 = chocolateboiler.getuniqueboiler("this is a msg");
        // uniChocolateboiler.fill();
        // uniChocolateboiler.fill();
        // uniChocolateboiler.boil();
        // uniChocolateboiler.fill();
        // uniChocolateboiler.boil();
        // uniChocolateboiler2.drain();
        // uniChocolateboiler.fill();
        // uniChocolateboiler2.boil();
    }
}