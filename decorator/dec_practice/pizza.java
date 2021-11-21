import javax.swing.plaf.synth.SynthSpinnerUI;

abstract class pizza_dec{
    String pizza_name = "unknown name for now";

    public String getname(){

        return this.pizza_name;
    }

    public void setname(String name)
    {
        this.pizza_name = name;
    }

    public abstract int getcost();
}

// this is the decorator interface which extends the main abstract class // which will be extended by other concrete class 0f pizza
abstract class ToppingsDecorator extends pizza_dec{
    public abstract String getname();

    @Override
    public void setname(String name) {
        super.setname(name);
    }

}

class mytype_pizza extends pizza_dec{
    public mytype_pizza()
    {
        pizza_name = "this is my type pizza";
    }
    @Override
    public int getcost() {
        
        return 100;
    }
}
class your_pizza extends pizza_dec{
    public your_pizza()
    {
        pizza_name = "this is your type of pizza";
    }
    
    @Override
    public int getcost() {
        
        return 101;
    }
}


// topping variations 

class Tomato extends ToppingsDecorator{

    String tomato = "topping done by fresh tomato";
    // we need a reference to obj we are decorating
    pizza_dec pizza;

    public Tomato(pizza_dec pizza) { this.pizza = pizza; }

    public String getname(){
        return pizza.getname() + tomato;
    }

    @Override
    public int getcost() {
        // TODO Auto-generated method stub
        return pizza.getcost() + 50;
    }



}

class cucmber extends ToppingsDecorator{
    String cucmber = "topping done by fresh cucmber";

    pizza_dec pizza;
    public void cucmber(pizza_dec pizza) { this.pizza = pizza; }
    public String getname(){
        return pizza.getname() + cucmber;
    }

    @Override
    public int getcost() {
        // TODO Auto-generated method stub
        return pizza.getcost()+ 50;
    }
}


class pizza {
    public static void main(String[] args) {
        pizza_dec mypizza = new mytype_pizza();
        pizza_dec urpizza_= new your_pizza();
        mypizza.setname("mahito");
        urpizza_.setname("kabito");

        System.out.println(mypizza.getname() + " " + urpizza_.getname());  
        mypizza = new Tomato(mypizza);
        System.out.println( mypizza.getcost());
   }
}
