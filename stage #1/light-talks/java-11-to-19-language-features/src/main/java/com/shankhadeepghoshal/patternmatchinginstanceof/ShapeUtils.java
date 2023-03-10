package com.shankhadeepghoshal.patternmatchinginstanceof;

import com.shankhadeepghoshal.sealedclassandrecords.Circle;
import com.shankhadeepghoshal.sealedclassandrecords.Parallelogram;
import com.shankhadeepghoshal.sealedclassandrecords.Rectangle;
import com.shankhadeepghoshal.sealedclassandrecords.SemiCircle;
import com.shankhadeepghoshal.sealedclassandrecords.Shape;
import com.shankhadeepghoshal.sealedclassandrecords.ShapeEnum;
import com.shankhadeepghoshal.sealedclassandrecords.Triangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.css.Rect;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public class ShapeUtils {
		public static Shape getShape(final ShapeEnum shapeEnum,
				final double firstParam,
				final double secondParam) {
				return switch (shapeEnum) {
						case CIRCLE -> new Circle(firstParam);
						case PARALLELOGRAM, RECTANGLE -> {
								System.out.printf("It's a %s \n", shapeEnum);
								yield new Rectangle(firstParam, secondParam);
						}
						case SEMI_CIRCLE -> new SemiCircle(firstParam);
						case TRIANGLE -> new Triangle(firstParam, secondParam);
				};
		}

		public static void checkShapeInstance(final Shape shape) {
				if (shape instanceof Rectangle r) {
						System.out.printf("It is a rectangle of length %s \n", r.getLength());
				} else if (shape instanceof Circle c) {
						System.out.printf("It is a circle of radius %s \n", c.getSemiMajorAxisLength());
				} else {
						System.out.println("Something else");
				}
		}
}
