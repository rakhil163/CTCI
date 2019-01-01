package com.company;
import java.util.LinkedList;
abstract class Animal
{
    private int order;
    private String name;
    public Animal(String n)
    {
        this.name =n;
    }
    public int getOrder() {
        return order;
    }
    public String getName()
    {
        return name;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public boolean isOlderThan(Animal a)
    {
        return this.order < a.getOrder();
    }
}
class Dog extends Animal{
    public Dog(String n)
    {
        super(n);
    }
}
class Cat extends Animal{
    public Cat(String n)
    {
        super(n);
    }
}
class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order=0;
    public void enqueue(Animal a)
    {
        a.setOrder(order);
        order++;

        if(a instanceof Dog) dogs.addLast((Dog)a);
        if(a instanceof Cat) cats.addLast((Cat)a);
    }
    public String dequeueDog()
    {
        //if(!dogs.isEmpty())
            return dogs.poll().getName();
    }
    public Cat dequeueCat()
    {
        //if(!cats.isEmpty())
            return cats.poll();
    }

   /* public Animal DequeueAny()
    {
        if(dogs.size()==0)
        {
            return dequeueCat();
        }
        else if(cats.size()==0)
        {
            return dequeueDog();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
       /* if(dog.isOlderThan(cat))
        {
            return dequeueDog();
        }
        else{
            return dequeueCat();
        }
    }*/
}
public class Animal_Shelter_CTCI {


    public static void main(String[] args) {
        Dog d1=  new Dog("AKhil");
        Dog d2 = new Dog("Bruno");
        Cat c1= new Cat("Vaish");
        Cat c2 = new Cat("Tom");
        AnimalQueue aq= new AnimalQueue();
        aq.enqueue(d1);
        aq.enqueue(c2);
        aq.enqueue(c1);
        aq.enqueue(d2);
        System.out.println(aq.dequeueDog());
       // System.out.println(aq.DequeueAny());

    }
}
