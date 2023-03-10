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
public sealed abstract class Parallelogram
		implements Shape
		permits Rectangle {

		double length;
		double height;

		@Override
		public double calculateArea() {
				return length * height;
		}
}
