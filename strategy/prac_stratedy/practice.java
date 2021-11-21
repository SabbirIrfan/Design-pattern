
class Fighter{
    Jumpb jump;
    Kickb kick;
    Punchb punch;

    public Fighter (Jumpb jump, Kickb kick, Punchb punch){
        this.jump = jump;
        this.kick = kick;
        this.punch = punch;
    }

    public void punch (){
        punch.punch();
    }
    public void kick(){
        kick.kick();

    }
    public void jump(){
        jump.jump();
        System.out.println("deff jump");
    }

    public void setJump(Jumpb jump) {
        this.jump = jump;
        System.out.println("set jump ");
    }
    public void setKickb(Kickb kickb) {
        this.kick = kickb;
    }
    public void setPunch(Punchb punch) {
        this.punch = punch;
    }
    public  void display(){
        
    };
}

// encapsulate kickb

interface Kickb {
    public void kick();
}

class Lightkick implements Kickb{
    public void kick(){
        System.out.println("its the implementation of kick interface with stratedy pattern which will kick slowly");
    }
}

class Tornadokick implements Kickb{
    public void kick(){
        System.out.println("its the implementation of kick interface with stratedy pattern which will kick faster");
    }
}

interface Punchb{
    public void punch();

}
class Lightpunch implements Punchb{
    @Override
    public void punch() {
        // TODO Auto-generated method stub
        
    }
}

interface Jumpb{
    public void jump();
}
class Lightjump implements Jumpb{
    @Override
    public void jump() {
        System.out.println("its a light jump");
        
    }
}
class Fulljump implements Jumpb{
    @Override
    public void jump() {
        System.out.println("its a high jump");

    }
}


class sabbir extends Fighter{
    public sabbir( Jumpb jump,Kickb kick, Punchb punch)
    {
        super(jump, kick, punch);
    }
    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("sabbir");
    }
}

class practice {
    public static void main(String[] args) {
        
        Kickb lightkick = new Lightkick();
        Kickb tornadokick = new Tornadokick();
        Punchb lightpunch = new Lightpunch();
        Jumpb  lightjump = new Lightjump();
        Jumpb fulljump= new Fulljump();
        Fighter sabbir = new sabbir(lightjump,lightkick,lightpunch);
        // sabbir.display();
        // sabbir.setJump(lightjump);    
        // sabbir.jump();
        // sabbir.setJump(fulljump);
        // sabbir.jump();

        // sabbir.setKickb(tornadokick);
        // sabbir.kick();

        Fighter f = new Fighter(new Lightjump(),new Lightkick(), new Lightpunch());
        f.jump();
        f.kick();
    }
    
}
