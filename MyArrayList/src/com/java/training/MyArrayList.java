package com.java.training;

public class MyArrayList {

	private Object[] objectArray;
	private Integer size;
	private int capacity = 5;

	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		
		//MyArraylist Operations with Person Object
		
		//Capacity
		System.out.println("myList Initial Capacity -"+ myList.getCapacity());
		
		//Size		
		System.out.println("myList Initial Size -"+ myList.size() );

		//Add
		Person person1 = new Person("Tom","Sawyer","Male");
		myList.add(person1);
		System.out.println("\nmyList - Add Object");
		System.out.println("*********************");

		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}

		//Add at index			
		Person person2 = new Person("Huckleberry","Finn","Male");
		myList.add(person2,0);
		System.out.println("\nmyList - Add at index 0");
		System.out.println("*************************");
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}


		//Get
		System.out.println("\nElement at Index 0-"+ myList.get(0));
		System.out.println("Element at Index 1-"+ myList.get(1));

		
		//Set		
		Person person3  = new Person("Nancy","Drew","Female");
		myList.set(person3, 1);
		System.out.println("\nmyList - Set at index 1");
		System.out.println("*************************");
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}
		//Index Of
		
		
		//Contains
		System.out.println("\ncontains() method");
		System.out.println("********************");
		System.out.println("Does "+ person1.toString()+" exist? "+ myList.contains(person1));
		System.out.println("Does " +person2.toString()+ " exist? "+ myList.contains(person2));
		System.out.println("Does " + person3.toString()+" exist? "+ myList.contains(person3));


		//Remove at index
		myList.remove(1);
		System.out.println("\nmyList - Remove at index 1");
		System.out.println("****************************");
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}

		
		//Remove object
		myList.remove(person2);
		System.out.println("\nmyList - Remove " + person2.toString());
		System.out.println("*****************************************");
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}

				
		//clear
		myList.add(person1);
		myList.add(person2);
		myList.add(person3);
		System.out.println("\nmyList - Before Clear");
		System.out.println("**************************");
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}
		myList.clear();
		System.out.println("\nmyList - After Clear");
		System.out.println("**************************");
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}
		//Dyamnic Size change
		myList.add(person1);
		myList.add(person2);
		myList.add(person3);
		myList.add(person1);
		myList.add(person2);
		myList.add(person3);
		System.out.println("\nCapacity get doubled if no. of elements more than 5 -initial capacity");
		System.out.println("********************************************************************");
		//Capacity
		System.out.println("myList Final Capacity -"+ myList.getCapacity());
				
		//Size		
		System.out.println("myList Final Size -"+ myList.size() );
		
	}

	public MyArrayList() {
		this.objectArray = new Object[this.capacity];
		this.size = 0;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public Boolean add(Object o) {

		if (this.size >= this.capacity) {

			this.objectArray = doubleArray();
		}
		this.objectArray[size] = o;
		size++;
		return true;

	}

	public Boolean add(Object o, int index) {
		if (index >= size)
			return false;

		else {
			if (size == capacity) {
				this.objectArray = doubleArray();
			}
			for (int i = size; i > index; i--) {
				this.objectArray[i] = this.objectArray[i - 1];
			}
			this.objectArray[index] = o;
			this.size++;
			return true;
		}
	}

	public Integer size() {
		return this.size;
	}

	public Boolean clear() {
		this.objectArray = new Object[this.capacity];
		this.size = 0;
		return true;
	}

	public Boolean contains(Object o) {

		for (int i = 0; i < size; i++) {
			if (this.objectArray[i]==o)
				return true;

		}
		return false;
	}

	public int[] findAllIndexes(Object o) {
		int[] indexes = null;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (this.objectArray[i].equals(o)) {
				indexes[count] = i;
				count++;
			}
		}
		return indexes;
	}

	public int findFirstIndex(Object o) {
		for (int i = 0; i < size; i++) {
			if (this.objectArray[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	public Object get(int index) {
		return this.objectArray[index];
	}

	public Boolean isEmpty() {
		if (this.size == 0)
			return true;
		else
			return false;
	}

	public Boolean replaceAll(Object o1, Object o2) {
		for (int i = 0; i < size; i++) {
			if (this.objectArray[i].equals(o1)) {
				this.objectArray[i] = o2;
			}
		}
		return true;

	}

	public Boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (this.objectArray[i].equals(o)) {
				for (int j = i; j < size; j++) {
					this.objectArray[j] = this.objectArray[j + 1];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	public Boolean remove(int index) {
		for (int j = index; j < size; j++) {
			this.objectArray[j] = this.objectArray[j + 1];
		}
		this.size--;
		return true;
	}

	public Boolean set(Object o, int index) {
		this.objectArray[index] = o;
		return true;
	}

	public Object[] toArray() {
		return this.objectArray;

	}

	private Object[] doubleArray() {
		this.capacity = 2 * this.capacity;
		Object[] newObjectArray = new Object[this.capacity];
		for (int i = 0; i < size; i++)
			newObjectArray[i] = this.objectArray[i];

		return newObjectArray;
	}
}
