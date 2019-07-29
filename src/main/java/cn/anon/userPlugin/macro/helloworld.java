package cn.anon.userPlugin.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;

import java.util.Map;

/**
 * @author Anon
 * @since 2019-07-29 11:55
 **/
public class helloworld implements Macro {
    public String execute(Map map, String s, ConversionContext conversionContext) throws MacroExecutionException {
        return " Hello World ";
    }

    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }
}
