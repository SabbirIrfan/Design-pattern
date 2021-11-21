
interface ftballer{
    
        public void kick();

        public void run();
        
        public void dribble();
}
class Amature implements ftballer{
    @Override
    public void kick() {
        // TODO Auto-generated method stub
        System.out.println("Amature kick");   
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Amature run");   
        
    }
    @Override
    public void dribble() {
        // TODO Auto-generated method stub
        System.out.println("Amature dribble");   
    }
}
class Pro implements ftballer{
    @Override
    public void kick() {
        // TODO Auto-generated method stub
        System.out.println("Pro kick");   
        
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Pro run");   
    }
    @Override
    public void dribble() {
        // TODO Auto-generated method stub
        System.out.println("Pro dribble");   
    }

}

class footballr{
    ftballer kick;
    ftballer run;
    ftballer dribble;

    void kick(){
        kick.kick();
    }
    void run(){
        run.run();
    }
    void dribble(){
        dribble.dribble();
    }
    public void setkick(ftballer kick_status){
        this.kick = kick_status;

    }
    public void setrun(ftballer run_status)
    {
        this.run = run_status;
    }
    public void setdribble(ftballer dribble_status){
        this.dribble = dribble_status;
    }
}

class a {

}
class b extends a{

}
public class football {
    public static void main(String[] args) {

        a jabb = new b();

        footballr sabbir = new footballr();

        
        sabbir.setkick(new Amature());
        sabbir.setdribble(new Amature());
        sabbir.setrun(new Amature());

        for (int i=0; i<100; i++)
        {
            sabbir.run();
            sabbir.dribble();
            sabbir.kick();

            if(i>10){
                sabbir.setrun(new Pro());
            }
            if(i>50){
                sabbir.setdribble(new Pro());
            }
            if(i >65){
                sabbir.setkick(new Pro());
            }
        }

    }
}
