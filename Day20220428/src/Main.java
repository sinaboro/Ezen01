class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();   //O
    Animal myPig = new Pig();    // O
    Animal myDog = new Dog();  //O

    myAnimal.animalSound();  // >> The animal makes a sound
    myPig.animalSound();     //  >> The pig says: wee wee
    myDog.animalSound();  // >> The dog says: bow wow
  }
}