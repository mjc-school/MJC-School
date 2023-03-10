package com.shankhadeepghoshal.sealedclassandrecords;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public final class SemiCircle extends Circle {

		public SemiCircle(final double radius) {
				super(radius);
		}

		@Override
		public double calculateArea() {
				return super.calculateArea() * 0.5;
		}
}
