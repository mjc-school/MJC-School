package com.shankhadeepghoshal.sealedclassandrecords;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public sealed class Circle extends Ellipse permits SemiCircle {

		public Circle(final double radius) {
				super(radius, radius);
		}
}
