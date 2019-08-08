package reactivejava;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import io.reactivex.Observable;

public class ObservalbeFormPulisher {

	public void emit() {
		Publisher<String> publisher = (Subscriber<? super String> s) -> {
			s.onNext("Hello Observable.fromPublisher()");
			s.onComplete();
		};
		
//		nolambda
		/*
		 * Publisher<String> publisher = new Publisher<String>() {
		 * 
		 * @Override public void subscribe(Subscriber<? super String>) {
		 * s.onNext("Hello Observable.fromPublisher()"); s.onComplete(); } };
		 */
		
		Observable<String> source = Observable.fromPublisher(publisher);
		source.subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		ObservalbeFormPulisher demo = new ObservalbeFormPulisher();
		demo.emit();
	}

}
