package com.lti;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Piston
{
	String type;
	Piston(String type)
	{
		
		this.type=type;
		System.out.println("Piston created1..");
	}
	void firing()
	{
		System.out.println("Firing "+type+" piston...");
	}

}
	
	class Engine
	{
		Piston p;
		Engine(Piston x)
		{
			p=x;
			System.out.println("Engine created1...");
		}
		void ignite()
		{
			p.firing();
			System.out.println("Igniting engine1...");
		}
	}
	
	
	class Car
	{

		Engine e;
		/*Car(Engine x)
		{
			e=x;
			System.out.println("Car created...");
		}*/
		public void setWheel(Wheel w)
		{
			System.out.println("got my Wheel inside car");
		}
		void startCar()
		{
			e.ignite();
			System.out.println("Car started");
		}
		
	}
	
class Wheel
{
         float radius;

		public float getRadius() {
			return radius;
		}

		public void setRadius(float radius) {
			System.out.println("set  method called...."+radius);
			this.radius = radius;
		}
		public void init()
		{
			System.out.println("init method called");
		}
		public void destroy()
		{
			System.out.println("destroy method called");
		}
         
}
public class SpringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Piston p=new Piston("Twin spark");
		//Engine e=new Engine(p);  // dependency here
		//Car car=new Car(e);		// dependency here 
		//car.startCar();
		System.out.println("loading the container...");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring1.xml");
		System.out.println("loaded the container..."+ctx);
		/*Car myCar1=(Car)ctx.getBean("c");
		Car myCar2=(Car)ctx.getBean("c");
		Car myCar3=(Car)ctx.getBean("c");//here c is the id of the bean
		System.out.println(myCar1.hashCode());
		System.out.println(myCar2.hashCode());
		System.out.println(myCar3.hashCode());
		//myCar.startCar();
		System.out.println("Setter injection..............");
		  Wheel w1=(Wheel) ctx.getBean("w");
		  Wheel w2=(Wheel) ctx.getBean("w");*/
		System.out.println("loading spring container...");
        AbstractApplicationContext ctx1 = new
                ClassPathXmlApplicationContext("spring2.xml");
       
		  System.out.println("End of main.....");
		  ((AbstractApplicationContext) ctx1).registerShutdownHook();
	}

}