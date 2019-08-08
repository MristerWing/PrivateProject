package reactivejava;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.math3.genetics.OrderedCrossover;

import java.util.ArrayList;
import java.util.HashSet;

import io.reactivex.Observable;

public class ObservableFromIterable {
	
	public class Order {
		private String mId;
		
		public Order(String id) {
			mId = id;
		}
		
		public String getId() {
			return mId;
		}
		
		@Override
		public String toString() {
			return "Order Id: " + mId;
		}
	}

	public void emit() {
		
//		List
		/*
		 * List<String> names = new ArrayList<>(); names.add("Jerry");
		 * names.add("Willam"); names.add("Bob");
		 */
		
//		Set
		/*
		 * Set<String> cities = new HashSet<>(); cities.add("Seoul");
		 * cities.add("London"); cities.add("Paris");
		 */
		
//		BlockingQueue
		BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
		orderQueue.add(new Order("ORD-1"));
		orderQueue.add(new Order("ORD-2"));
		orderQueue.add(new Order("ORD-3"));
		
//		Observable<String> source = Observable.fromIterable(names);
//		Observable<String> source = Observable.fromIterable(cities);
		Observable<Order> source = Observable.fromIterable(orderQueue);
		
//		source.subscribe(System.out::println);
		source.subscribe(order -> System.out.println(order.getId()));
		
	}
	
	public static void main(String[] args) {
		ObservableFromIterable demo = new ObservableFromIterable();
		demo.emit();

	}

}
