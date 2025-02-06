
// behaviors
public interface quackBehavior {
    void quack();
}
public interface flyBehavior {
    void fly();
}

// concrete behaviors
public class Quack implements quackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
public class FlyWithWings implements flyBehavior {
    public void fly() {
        System.out.println("I'm flying");
    }
}

public class MuteQuack implements quackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

public class FlyNoWay implements flyBehavior {
    public void fly() {
        System.out.println("I can't fly");
    }
}

// #Template class for Duck
public abstract class DuckStrategy {
    public abstract void display();
    public quackBehavior quackBehavior;
    public flyBehavior flyBehavior;
}


public class BanglaDuck extends DuckStrategy {
    public BanglaDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display() {
        System.out.println("I'm a Mallard duck");
    }
}

public class ChittagonianDuck extends DuckStrategy {
    public ChittagonianDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display() {
        System.out.println("I'm a Chittagonian duck");
    }
}

public class DhakaiyaDuck extends DuckStrategy {
    public DhakaiyaDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }
    public void display() {
        System.out.println("I'm a real Dhakaiya duck");
    }
}

public class DuckFactory {
    public DuckStrategy getDuck(String type) {
        if (type.equals("BanglaDuck")) {
            return new BanglaDuck();
        } else if (type.equals("ChittagonianDuck")) {
            return new ChittagonianDuck();
        } else if (type.equals("DhakaiyaDuck")) {
            return new DhakaiyaDuck();
        }
        return null;
    }

    public static void main(String[] args) {
        DuckFactory duckFactory = new DuckFactory();
        DuckStrategy duck = duckFactory.getDuck("BanglaDuck");
        duck.display();
        duck.quackBehavior.quack();
        duck.flyBehavior.fly();
    }
}