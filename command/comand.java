
interface Command{
    public void execute();
}

class Light{
    String name;
    Light(String name){
        this.name = name;

    }
    public void on(){
        System.out.println(name + " is on");
    }
    public void off(){
        System.out.println(name + " is off");
    }
}
class LightOnCommand implements Command{
    Light light;
  
    public LightOnCommand(Light light){
       this.light = light;
    }
    public void execute(){
       light.on();
    }
}
class LightOffCommand implements Command{
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
         light.off();
    }
}
class Fan{
    String name;
    Fan(String name){
        this.name = name;

    }

    void start(){
        System.out.println(name + " has started");
    }

    void stop(){
        System.out.println(name + " has stopped");
    }
}
class FanStartCommand implements Command{
    Fan fan;
  
    public FanStartCommand(Fan fan){
       this.fan = fan;
    }
    public void execute(){
       fan.start();
    }
}
class FanStopCommand implements Command{
    Fan fan;
  
    public FanStopCommand(Fan fan){
       this.fan = fan;
    }
    public void execute(){
       fan.stop();
    }
}

class SimpleRemoteControl{
    Command slot;  
  
    public void setCommand(Command command){
        slot = command;
    }
  
    public void buttonWasPressed(){
        slot.execute();
    }
}
public class comand{
    public static void main(String args[]){
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("Light 1");
        Fan fan = new Fan("Fan 1");
  
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new FanStartCommand(fan));
        remote.buttonWasPressed();

        System.out.println("\n");

        remote.setCommand(new LightOffCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new FanStopCommand(fan));
        remote.buttonWasPressed();
        
    }
}
// © 2021 GitHub, Inc.
// Terms
// Privacy
// Security
// Status
// Docs
// Contact GitHub
// Pricing
// API
// Training
// Blog
// About
// Loading complete