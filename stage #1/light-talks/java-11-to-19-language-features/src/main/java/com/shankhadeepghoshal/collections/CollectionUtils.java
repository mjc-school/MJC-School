package com.shankhadeepghoshal.collections;

import com.shankhadeepghoshal.sealedclassandrecords.Triangle;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public class CollectionUtils {

		public static void localRecordsAndNewToList() {
				record TriangleArea(Triangle triangle, double area) {

				}
				final Predicate<TriangleArea> isTriangleAreaGreaterThan10 =
						(var triangleArea) -> triangleArea.area() > 10;

				Stream.of(new Triangle(1.0, 5.0), new Triangle(5.0, 8.0))
						.map(triangle -> new Triangle(triangle.base() * 2, triangle.height() / 2))
						.map(triangle -> new TriangleArea(triangle, triangle.calculateArea()))
						.filter(isTriangleAreaGreaterThan10)
						.map(TriangleArea::triangle)
						.forEach(System.out::println);
		}

		public static void mapMultiDemo() {
				final var listListOfNums = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6),
						List.of(List.of(7, 8), 9));
				listListOfNums.stream().mapMulti(CollectionUtils::expandIterable).toList()
						.forEach(System.out::println);
		}

		private static void expandIterable(final Object e, final Consumer<Object> c) {
				if (e instanceof Iterable<?> elements) {
						for (Object ie : elements) {
								expandIterable(ie, c);
						}
				} else if (e != null) {
						c.accept(e);
				}
		}
}
