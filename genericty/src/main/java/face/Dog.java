package face;

public class Dog extends Animal {

//    public void eat(){
//        System.out.println("Dog eat");
//
//    }
    public void sleep(){
        System.out.println("Dog sleep");
    }

    public void lookDoors(){
        System.out.println("Dog lookDoors");
    }

    public static void main(String[] args){
        Animal animal=new Animal();
        Animal dog=new Dog();
        animal.eat();
        dog.eat();



        Dog dogs=new Dog();
        dogs.lookDoors();



    }
}
