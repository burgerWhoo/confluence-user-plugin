package cn.anon.userPlugin.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.webresource.api.assembler.PageBuilderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author Anon
 * @since 2019-07-29 11:55
 **/
@Scanned
public class helloworld implements Macro {

    private PageBuilderService pageBuilderService;

    @Autowired
    public helloworld(@ComponentImport PageBuilderService pageBuilderService) {
        this.pageBuilderService = pageBuilderService;
    }

    public String execute(Map<String, String> map, String s, ConversionContext conversionContext) throws MacroExecutionException {
        // 使用pageBuilderService来请求自动生成的Web资源键：填写对应的web-resource key
        pageBuilderService.assembler().resources().requireWebResource("cn.anon.userPlugin:userPlugin-resources");

        //创建一个< div ... / > 元素
        String output = "<div class =\"helloworld\">";
        output = output + "<div class = \"" + map.get("Color") + "\">";
        if (map.get("Name") != null) {
            output = output + ("<h1>Hello " + map.get("Name") + "!</h1>");
        } else {
            output = output + "<h1>Hello World!<h1>";
        }
        output = output + "</div>" + "</div>";
        return output;
    }

    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }
}
