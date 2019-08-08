package reactivejava;

import io.reactivex.Observable;
import io.reactivex.Single;
import reactivejava.Order;

public class SingleExample {
	
	public void emit() {
//		1. ���� Observable���� Single ��ü�� ��ȯ�ϱ�.
		Observable<String> source = Observable.just("Hello Single");
		Single.fromObservable(source)
		.subscribe(System.out::println);
		
//		2. single() �Լ��� ȣ���� Single ��ü �����ϱ�.
		Observable.just("Hello Single")
		.single("defalut item")
		.subscribe(System.out::println);
		
//		3. first() �Լ��� ȣ���� Single ��ü �����ϱ�.
		String[] colors = {"Red", "Blue", "Gold"};
		Observable.fromArray(colors)
		.first("default value")
		.subscribe(System.out::println);
		
//		4. empty Observable���� Single ��ü �����ϱ�
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
//		5. take() �Լ����� Single ��ü �����ϱ�.
		Observable.just(new Order("ORD-1"), new Order("ORD-2"))
		.take(1)
		.single(new Order("default order"))
		.subscribe(System.out::println);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleExample demo = new SingleExample();
		demo.emit();
	}

}
