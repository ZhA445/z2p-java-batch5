package Day10_pkg2;

import Day10_pkg1.A;

public class D {

		void test() {
			A obj = new A();
			//obj.a = 20; //error (private)
			//obj.b = 20;//error => default(different pkg)
			//obj.c = 20;//error => protected (different pkg && non-subclass)
			obj.d=30;//ok=> public
			
		}
}
