package com.alibaba.fastjson.deserializer.issue3746;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.moneta.MonetaCodec;
import junit.framework.TestCase;
import org.junit.Test;


 /**
 * This is the test for the use case when the parsed object has the value of null.
 * The expected result is that JSON exception will be thrown when parsing the null object.
 **/
// CS 427 Issue link: https://github.com/alibaba/fastjson/issues/3746
public class NullDeserializerTest extends TestCase {
    @Test
    public void testNullInputToParse() {
        boolean thrown = false;
        DefaultJSONParser parser = new DefaultJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);

        try {
            MonetaCodec.instance.deserialze(parser, null, null);
        } catch (JSONException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

}
