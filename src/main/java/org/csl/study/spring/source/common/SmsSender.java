package org.csl.study.spring.source.common;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import java.io.IOException;

public class SmsSender {

	
	public static void send(){
		
		// 短信应用 SDK AppID
		int appid = 1400241314; // SDK AppID 以1400开头
		// 短信应用 SDK AppKey
		String appkey = "062e76df58db957665ae56064c8d3475";
		// 需要发送短信的手机号码
		String[] phoneNumbers = {"13631360815"};
		// 短信模板 ID，需要在短信应用中申请
		int templateId = 7839; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
		// 签名
		String smsSign = "腾讯云"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
	
		try {
		  SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		  SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0],
		      "【腾讯云】您的验证码是: 5678", "", "");
		  System.out.println(result);
		  
		} catch (HTTPException e) {
		  // HTTP 响应码错误
		  e.printStackTrace();
		} catch (JSONException e) {
		  // JSON 解析错误
		  e.printStackTrace();
		} catch (IOException e) {
		  // 网络 IO 错误
		  e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		send();
	}
	
}
