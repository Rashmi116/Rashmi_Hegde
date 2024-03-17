package com.wiley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

enum Status {
	OPEN, CLOSED
}

class Person{
	private String name;
	private String geneder;
	private int age;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", geneder=" + geneder + ", age=" + age + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeneder() {
		return geneder;
	}
	public void setGeneder(String geneder) {
		this.geneder = geneder;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, String geneder, int age) {
		super();
		this.name = name;
		this.geneder = geneder;
		this.age = age;
	}
}

class Student1{
	private String name;
	private Set<String> certifications;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getCertifications() {
		return certifications;
	}
	public void setCertifications(Set<String> certifications) {
		this.certifications = certifications;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", certifications=" + certifications + "]";
	}
	public void addCertification(String certi) {
        if (this.certifications == null) {
          this.certifications = new HashSet<>();
        }
        this.certifications.add(certi);
}
	
	
}

class Employee1{
	private String name;
	private int age;
	private double salary;
	public double getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee1(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}

class Task {
	private int points;
	private Status status;

	public Task(int points, Status status) {
		this.points = points;
		this.status = status;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

public class StreamDemo {

	public static void main(String[] args) {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(8, Status.OPEN));
		tasks.add(new Task(9, Status.OPEN));
		tasks.add(new Task(10, Status.CLOSED));

		// calculate the sum of open tasks
		// Firstly, the tasks collection is converted to its stream representation.
		// Then, the filter operation on stream filters out all CLOSED tasks.
		// On next step, the mapToInt operation converts the stream of Tasks to the
		// stream of Integers using Task::getPoints method of the each task instance.
		// And lastly, all points are summed up using sum method, producing the final
		// result.
		// Stream operations are divided into intermediate and terminal operations.
		// Intermediate operations return a new stream. e.g. Filter
		// * filter does not actually perform any filtering, but instead creates a new
		// stream that, when traversed,
		// * contains the elements of the initial stream that match the given predicate.
		// * Intermediate operations are always Lazy.
		/*
		 * Terminal operations may traverse the stream to produce a result or a
		 * side-effect. e.g. forEach or sum After the terminal operation is performed,
		 * the stream pipeline is considered consumed, and can no longer be used.
		 * Terminal operations are eager.
		 */

		int a = tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt((t) -> t.getPoints()).sum();
		System.out.println(a);
		System.out.println("==================");

		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(9);
		list.add(7);

		// forEach with Lambda
		System.out.println("=======forEachwithLambda===========");
		list.forEach((l) -> System.out.println(l));
		
		list.forEach((l) -> System.out.println(l));

		System.out.println("========methodinference==========");
		// forEach with Method Inference
		list.forEach(System.out::print);

		System.out.println("=========stream=========");

		// forEach on stream
		list.stream().forEach(System.out::println);
		
		System.out.println("=========doubling the no=========");
		
		list.stream().mapToInt((l)->l*l).forEach(System.out::println);;

		System.out.println("========stream and parallel==========");
		// forEach on Stream.parallel()
		list.stream().parallel().forEach(System.out::println);

		// parallel() : the stream is split into multiple chunks, with each chunk
		// processed independently
		// and with the result summarized at the end.
		System.out.println("========stream and parallel with order==========");
		list.stream().parallel().forEachOrdered(System.out::println);

		Set<Object> set1 = new HashSet<>();
		set1.add(5);
		set1.add("amit");
		set1.add("3");

		set1.stream().mapToInt(new ToIntFunction<Object>() {

			@Override
			public int applyAsInt(Object value) {
				if (value instanceof String) {
					try {
						return Integer.parseInt(value.toString());
					} catch (NumberFormatException e) {

					}
				} else if (value instanceof Integer) {
					return ((Integer) value).intValue();
				} else {
					return 0;
				}

				return 0;

			}
			// lambda
		}).forEach(System.out::println);;
		set1.stream().mapToInt((value) -> {
			if (value instanceof String) {
				try {
					return Integer.parseInt(value.toString());
				} catch (NumberFormatException e) {

				}
			} else if (value instanceof Integer) {
				return ((Integer) value).intValue();
			} else {
				return 0;
			}

			return 0;
		}).forEach(System.out::println);;
        System.out.println("=========doubling the no=========");
		
		list.stream().mapToInt((l)->l*l).forEach(System.out::println);;

		OptionalDouble d=list.stream().mapToInt((l)->l*2).average();
		if(d.isPresent()) {
			System.out.println("average of doubles is"+d.getAsDouble());
		}
		//Returns an OptionalInt describing some element of the stream, or an empty OptionalInt if the stream is empty.
		OptionalInt i=list.stream().mapToInt((l)->l*2).findAny();
		if(i.isPresent()) {
			System.out.println("any no is"+i.getAsInt());
		}
		
		//findFirst(); //Returns an OptionalInt describing the first element of this stream, or an empty OptionalInt if the stream is empty.
		OptionalInt j=list.stream().mapToInt((l)->l*2).findFirst();
		if(j.isPresent()) {
			System.out.println("any no is"+j.getAsInt());
		}
		System.out.println("The max number =" +list.stream().mapToInt((l)->l*2).max());
		System.out.println("The max number =" +list.stream().mapToInt((l)->l*2).sum());
		
		boolean isAnyMatch=list.stream().mapToInt((l)->l*2).anyMatch(new IntPredicate() {

			@Override
			public boolean test(int value) {
				if(value==10) {
					return true;
				}
				else {
				return false;
				}
			}
			
		});
		System.out.println(isAnyMatch);
		boolean isAllMatch=list.stream().mapToInt((l)->l*2).allMatch((n)->n>5);
		System.out.println(isAllMatch);
		
		//The Collectors class has a few imp methods like averagingInt and groupingBy
		List<Integer> intlist = Arrays.asList(5,9,7,2);
		Double db=intlist.stream().map( new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}

			
			
		}).collect(Collectors.averagingInt((x)->x*2));	
		Double db1 = intlist.stream().map((x)->x*2).collect(Collectors.averagingInt((x)->x*2));
		System.out.println("Double Value: "  + db1.doubleValue());
		
		
		List<Person> persons = Arrays.asList(new Person("Amit","Male",38), new Person("Prachi","Female",34),new Person("Banesh","Male",22));
		System.out.println(persons.stream().filter((p)->p.getGeneder().equals("Male")).mapToInt((p)->p.getAge()).average());
		Map<String,List<Person>> namesPerGender =persons.stream().collect(Collectors.groupingBy(new Function<Person,String>(){

			@Override
			public String apply(Person t) {
				
				return t.getGeneder();
			}
			
		}));
		System.out.println(namesPerGender);
		
		Map<Object, List<Person>> namespergender=persons.stream().collect(Collectors.groupingBy((p)->p.getGeneder()));
		System.out.println(namespergender);

		//persons.removeIf((Person p)-> p.getName().equalsIgnoreCase("Amit") );
		namesPerGender.computeIfPresent("Male", (gender, personlist) -> {
			personlist.removeIf((Person p) -> {
				return (p.getName().equalsIgnoreCase("Banesh"));
			});
			return personlist;
		});
		namesPerGender.forEach((gender, personList)-> System.out.println(gender+"-->"+personList));
		
		//flatmap works in case of nested fors - { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
		Student1 s1 = new Student1();
		Student1 s2 = new Student1();
        s1.setName("Amit"); 
        s1.addCertification("SCJP");
        s1.addCertification("SCWCD");
        s1.addCertification("OCJP");
        
        s2.setName("Sujay"); 
        s2.addCertification("BCD");
        s2.addCertification("Oracle");
        
        List<Student1> studlist = new ArrayList<>();
        studlist.add(s1);
        studlist.add(s2);
        //using flatmap
        studlist.stream().map((x)->x.getCertifications()).flatMap((x)->x.stream()).distinct().collect(Collectors.toList()).forEach(System.out::println);;
        
        List<Employee1> employees = Arrays.asList(
        	    new Employee1("John", 35, 60000.0),
        	    new Employee1("Mary", 39, 70000.0),
        	    new Employee1("Jane", 42, 45000.0),
        	    new Employee1("Bill", 28, 55000.0),
        	    new Employee1("Tom", 31, 52000.0)
        	);
        
        //employees.stream().filter((e)->e.getSalary()>50).map((e)->e.getAge()<40).sorted();
        
        employees.stream().filter((e)->(e.getSalary()>50000.0 && e.getAge()<40)).sorted((e,f)->e.getName().compareTo(f.getName())).forEach(System.out::println);;
		
		}

}

