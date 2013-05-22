package ws.otero.adrian.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

/**
 * 
 * @author adrian otero (http://adrian.otero.ws)
 *
 */
public class AowsDialect extends AbstractDialect {

	@Override
	public String getPrefix() {
		return "aows";
	}
	
	@Override
	public Set<IProcessor> getProcessors() {
		final Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new HotDateProcessor());		
		return processors;
	}
	
	@Override
	public boolean isLenient() {
		return false;
	}
	
}
