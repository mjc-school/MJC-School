package com.shankhadeepghoshal.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;
import java.util.function.Function;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public class StringUtils {

		public static final String QUICK_BROWN_FOX_TEXT = """
				The quick \n brown fox \b\
				jumped over nothing \t""";
		private static final String MULT_LINE_STRING = """
					{
						"args": {},
						"data": {
							"x": 1,
							"y": 2
						},
						"files": {},
						"form": {},
						"headers": {
							"x-forwarded-proto": "https",
							"x-forwarded-port": "443",
							"host": "postman-echo.com",
							"x-amzn-trace-id": "Root=1-6408375e-3a617c264948c0187ffb21b3",
							"content-length": "13",
							"content-type": "application/json;charset=UTF-8",
							"user-agent": "Java-http-client/19.0.2"
						},
						"json": {
							"x": 1,
							"y": 2
						},
						"url": "https://postman-echo.com/post"
					}\t
				""";
		private static final String SQL_INNER_QUERY = """
				SELECT x.x1, SUM(x.n) AS xDesc \
				FROM x \
				WHERE <Condition> \
				GROUP BY x.x1 \
				HAVING xDesc > :param1""";
		private static final String SQL_OUTER_QUERY = """
				SELECT a.a1 AS aDesc \
				FROM(%s) AS kDesc, a \
				WHERE a.a1 = kDesc.x1""".formatted(SQL_INNER_QUERY);

		public static void newStringMethods() {
				System.out.println("Strip indents:");
				System.out.println(MULT_LINE_STRING.strip());

				System.out.println(SQL_OUTER_QUERY);
				escapeTranslate();
				compactNumberFormat();

				System.out.println("Transforming:");
				readFromConsoleAndTransform(Integer::valueOf);
		}

		private static void compactNumberFormat() {
				final var numberFormat = NumberFormat.getCompactNumberInstance(
						Locale.US, Style.LONG);
				System.out.println(numberFormat.format(1_200_000));
		}

		private static void escapeTranslate() {
				System.out.println("Translates Escapes");
				final var trEscStr = QUICK_BROWN_FOX_TEXT.translateEscapes();
				final var controlVar = QUICK_BROWN_FOX_TEXT;
				System.out.println(trEscStr == QUICK_BROWN_FOX_TEXT); // false
				System.out.println(controlVar == QUICK_BROWN_FOX_TEXT); // true
		}

		private static void readFromConsoleAndTransform(
				Function<String /* has to be java.lang.String */, Integer> func) {
				final var br = new BufferedReader(new InputStreamReader(System.in));
				try {
						final var integerParsed = br.readLine().transform(func);
						System.out.println(integerParsed - 1);
				} catch (IOException e) {
						throw new RuntimeException(e);
				} catch (NumberFormatException e) {
						System.err.println("Cannot parse stuff that isn't a number");
				}
		}
}
