import bsh.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;


public class Secord implements JavaSamplerClient {
    public static final String URLNAME="URL";
    public static final String DEFAULTURL="http://www.baidu.com";
    private String url;

    /**
     *初始化方法
     * @param javaSamplerContext
     */
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        url=javaSamplerContext.getParameter(URLNAME,DEFAULTURL);
        System.out.println("用户输入的地址是:"+url);
        System.out.println("start");

    }

    /**
     * 实现你功能具体的逻辑
     * @param javaSamplerContext
     * @return
     */
    //放在查看结果树当中
    String resultDate;
    public SampleResult runTest  (JavaSamplerContext javaSamplerContext) {
        SampleResult result =new SampleResult();
        HttpGet httpGet=new HttpGet("https://www.baidu.com");
        DefaultHttpClient defaultHttpClient=new DefaultHttpClient();

            HttpResponse response;
        try {
            response = defaultHttpClient.execute(httpGet);
            String data= EntityUtils.toString(response.getEntity(),"UTF-8");
            System.out.println("test");
            resultDate="响应结果";
            result.setSuccessful(true);
            result.setResponseData(data, "utf-8");
            result.setDataType(SampleResult.TEXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 收尾工作
     * @param javaSamplerContext
     */
    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("end");

    }

    /**
     * 决定显示在jmeter上的属性
     * 一选择属性就会显示
     * @return
     */
    public Arguments getDefaultParameters() {
        System.out.println("getDefaultParameters");
        Arguments arguments=new Arguments();
        arguments.addArgument(URLNAME,DEFAULTURL);
        return arguments;
    }
}
