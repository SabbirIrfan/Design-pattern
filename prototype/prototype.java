interface villainproto{
    villain villain_clone();
}

abstract class villain implements Cloneable,villainproto{
    abstract void attachprotagonist();
}

class villain1 extends villain{
    private int hp,mp;

    villain1(int hp, int mp){
        this.hp = hp;
         this.mp = mp;
    }
    @Override
    void attachprotagonist() {
        System.out.println("attacking protagonist");
    }

   @Override
   protected Object clone() throws CloneNotSupportedException {
       return new villain1(this.hp, this.mp);
   }
    public String toString(){
        String st = " ";
        st+= "{ hp::" +this.hp +" }";
        st+= "{ mp::"+ this.mp +" }";

        return st;
    }
    @Override
    public villain villain_clone() {
        return new villain1(this.hp, this.mp);
    }
}

class prototype{
    public static void main(String[] args) {
        villain villains = new villain1(100, 100);
        System.out.println(villains);
        villain villain1_clone = villains.villain_clone();
        System.out.println(villain1_clone);

    }
}