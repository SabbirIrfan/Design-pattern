// Behaviors - Separating interfaces and implementations
package behaviors;

// Kick behavior interface
interface KickBehavior {
    void kick();
}

// Jump behavior interface
interface JumpBehavior {
    void jump();
}

// Kick behavior implementations
class LightningKick implements KickBehavior {
    @Override
    public void kick() {
        System.out.println("Lightning Kick!");
    }
}

class TornadoKick implements KickBehavior {
    @Override
    public void kick() {
        System.out.println("Tornado Kick!");
    }
}

// Jump behavior implementations
class ShortJump implements JumpBehavior {
    @Override
    public void jump() {
        System.out.println("Short Jump!");
    }
}

class LongJump implements JumpBehavior {
    @Override
    public void jump() {
        System.out.println("Long Jump!");
    }
}

// Base fighter class
abstract class Fighter {
    private KickBehavior kickBehavior;
    private JumpBehavior jumpBehavior;
    private final String name;

    protected Fighter(String name, KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        this.name = name;
        this.kickBehavior = kickBehavior;
        this.jumpBehavior = jumpBehavior;
    }

    // Core actions
    public void punch() {
        System.out.println(name + " performs a Default Punch!");
    }

    public void kick() {
        System.out.print(name + " ");
        kickBehavior.kick();
    }

    public void jump() {
        System.out.print(name + " ");
        jumpBehavior.jump();
    }

    public void roll() {
        System.out.println(name + " performs a Default Roll!");
    }

    // Behavior setters for dynamic behavior changes
    public void setKickBehavior(KickBehavior kickBehavior) {
        this.kickBehavior = kickBehavior;
    }

    public void setJumpBehavior(JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
    }

    public void display() {
        System.out.println("\nFighter: " + name);
    }

    // Getter for name
    public String getName() {
        return name;
    }
}

// Concrete fighter classes
class Ryu extends Fighter {
    public Ryu(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super("Ryu", kickBehavior, jumpBehavior);
    }
}

class Ken extends Fighter {
    public Ken(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super("Ken", kickBehavior, jumpBehavior);
    }
}

class ChunLi extends Fighter {
    public ChunLi(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super("Chun-Li", kickBehavior, jumpBehavior);
    }
}

// Main game class
public class StreetFighter {
    public static void main(String[] args) {
        // Create behaviors
        KickBehavior tornadoKick = new TornadoKick();
        KickBehavior lightningKick = new LightningKick();
        JumpBehavior shortJump = new ShortJump();
        JumpBehavior longJump = new LongJump();

        // Create fighters with initial behaviors
        Fighter ken = new Ken(tornadoKick, shortJump);
        Fighter ryu = new Ryu(lightningKick, longJump);
        Fighter chunLi = new ChunLi(lightningKick, shortJump);

        // Demonstrate fighter abilities
        demonstrateFighterAbilities(ken);
        
        // Demonstrate dynamic behavior change
        System.out.println("\nChanging Ken's jump behavior...");
        ken.setJumpBehavior(longJump);
        ken.jump();
    }

    private static void demonstrateFighterAbilities(Fighter fighter) {
        fighter.display();
        fighter.punch();
        fighter.kick();
        fighter.jump();
        fighter.roll();
    }
}