package ut.cn.anon.userPlugin;

import org.junit.Test;
import cn.anon.userPlugin.api.MyPluginComponent;
import cn.anon.userPlugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}