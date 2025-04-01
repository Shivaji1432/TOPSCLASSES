package assignment1;

class Animal1{
	
	void makeSound() {
		System.out.println("sound....");
	}
	
}

class Dog extends Animal1{
	
	void makeSound() {
		System.out.println("Dog bark....");
	}
	
}

class Cat extends Animal1{
	
	void cry() {
		System.out.println("cat Cry....");
	}
	
}

public class Q22RuntimePoly {
public static void main(String[] args) {
	
	Animal1 dog=new Dog();
	Animal1 cat = new Cat();
	Dog d1=(Dog)cat;
	d1.makeSound();
	Cat c1=(Cat)dog;
	c1.cry();

}


}
