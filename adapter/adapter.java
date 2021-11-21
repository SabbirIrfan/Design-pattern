import java.text.BreakIterator;

abstract class car{
    double weight_kg;
    double milage;
    car(double weight_kg, double milage)
    {
        this.milage = milage;
        this.weight_kg = weight_kg;
    }
    abstract void start();
    abstract void other_func();
}

class mclaren extends car{
    mclaren(){
        super(1000, 200.4);
    }
    @Override
    void start() {
        // TODO Auto-generated method stub
        System.out.println("macleren is just started");
    }

    @Override
    void other_func() {
        // TODO Auto-generated method stub
        System.out.println("macleren using other functions");
        
    }

}

abstract class bike{
    double weight_pound;
    double kilo_per_litre;
    bike(double weight_pound, double kilo_per_litre)
    {
        this.kilo_per_litre = kilo_per_litre;
        this.weight_pound = weight_pound;
    }
    abstract void begin();
    abstract void controller();
}

class rolee extends bike{
    rolee(){
        super(10000, 100.9);
    }

    @Override
    void begin() {
        // TODO Auto-generated method stub
        System.out.println("rolee has began its journy");
    }

    @Override
    void controller() {
        // TODO Auto-generated method stub
        System.out.println("rolee is being controlled");
        
    }

}

class bike2carAdapter extends car{

    bike bk;

    bike2carAdapter(bike bk){
        super(bk.weight_pound/2.2, bk.kilo_per_litre*0.622);

        this.bk = bk;
    }
    @Override
    void start() {
        bk.begin();
        
    }

    @Override
    void other_func() {
        bk.controller();

        
    }

}
class adapter{
    public static void main(String[] args) {
        car maclaren = new mclaren();
        car role = new bike2carAdapter(new rolee());
        
        maclaren.start();
        role.start();
    }
}