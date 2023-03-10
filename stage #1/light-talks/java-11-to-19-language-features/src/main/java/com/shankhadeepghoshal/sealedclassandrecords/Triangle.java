package com.shankhadeepghoshal.sealedclassandrecords;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public record Triangle(double base, double height) implements Shape {

		@Override
		public double calculateArea() {
				return 0.5 * base * height;
		}
}
