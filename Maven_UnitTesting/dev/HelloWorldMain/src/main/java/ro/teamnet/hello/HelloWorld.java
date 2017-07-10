package ro.teamnet.hello;

import org.apache.log4j.Logger;

/**
 * Created by Petrus.Prangate on 7/4/2016.
 */
public class HelloWorld {
    static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

    /**
     * method for saying hello
     */
    public void sayHello(){
        System.out.println("Hello World!");
        logger.debug("DEBUG -> Enters in sayHello() method from HelloWorld");
        logger.info("INFO -> Enters in returnHelloKey from HelloWorld");
    }

    /**
     * method for returning a key
     * @return - The HelloWorld key
     */
    public String returnHelloKey(){
        return "HelloKey";
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

}
