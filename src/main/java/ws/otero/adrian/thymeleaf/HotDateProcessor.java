package ws.otero.adrian.thymeleaf;

import java.util.Calendar;
import java.util.Date;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.StandardExpressionProcessor;

import ws.otero.adrian.thymeleaf.HotDateUtils.HotDateResult;

/**
 * 
 * @author adrian otero (http://adrian.otero.ws)
 *
 */
public class HotDateProcessor extends AbstractTextChildModifierAttrProcessor {

	private static String messagesPrefix = "hotdate";

	public HotDateProcessor() {
		super("hotdate");
	}

	@Override
	public int getPrecedence() {
		return 10000;
	}

	@Override
	protected String getText(final Arguments arguments, final Element element,
			final String attributeName) {

		Object date = StandardExpressionProcessor.processExpression(arguments,
				element.getAttributeValue(attributeName));

		HotDateResult result;
		if (date instanceof Calendar) {
			result = new HotDateUtils().formatCalendar((Calendar) date);

		} else if (date instanceof Date) {
			result = new HotDateUtils().formatDate((Date) date);

		} else {
			throw new IllegalArgumentException("Input type not valid: "
					+ date.getClass().getCanonicalName());
		}

		return getMessage(arguments, messagesPrefix + "." + result.getKey(),
				result.getValues());
	}

}
