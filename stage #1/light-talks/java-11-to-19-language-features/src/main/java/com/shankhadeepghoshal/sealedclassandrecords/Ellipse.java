package com.shankhadeepghoshal.sealedclassandrecords;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public non-sealed class Ellipse implements Shape {

		double semiMajorAxisLength;
		double semiMinorAxisLength;

		@Override
		public double calculateArea() {
				return Math.PI * semiMajorAxisLength * semiMinorAxisLength;
		}
}
