package com.shankhadeepghoshal.sealedclassandrecords;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public sealed interface Shape permits Ellipse, Parallelogram, Triangle {

		double calculateArea();
}
