package test;

import java.io.IOException;

import org.junit.Test;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.alibaba.fastjson.JSONObject;

public class messageTest {
	
	@Test
	public void testCtr(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAreaInfos");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum","0");
        jsonObject.put("pageSize","3");
        jsonObject.put("userid","b2c6a9c7-97e0-4262-836c-0866816f0011");
        jsonObject.put("flag","2");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCtr1(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAllRepairApp");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum","0");
        jsonObject.put("pageSize","3");
        jsonObject.put("repairDepartmentId","874ab533-ede4-4fdf-b54d-bc17a73b333e");
        jsonObject.put("step","2")	;
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCtr2(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAllRepairPlain");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appId","89b43c0d-f2e8-42ec-baf2-56a8d849445a");
        jsonObject.put("planType","故障类型");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println("返回的结果是："+resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	@Test
	public void testCtr3(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getRepairAppByStep");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum","0");
        jsonObject.put("pageSize","1");
        jsonObject.put("step","6");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Test
	public void testCtr4(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getRepairAppResult");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum","0");
        jsonObject.put("pageSize","3");
        jsonObject.put("areaId","ff2844a1-b198-471a-8627-c9c3b985e715");
        jsonObject.put("step","6");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println("结果是："+resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCtr5(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getRepairApp1");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum","0");
        jsonObject.put("pageSize","3");
        jsonObject.put("userid","b2c6a9c7-97e0-4262-836c-0866816f0011");
        jsonObject.put("step","6");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println("结果是："+resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCtr6(){
		ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getRepairApp3");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageNum","0");
        jsonObject.put("pageSize","3");
        jsonObject.put("step","6");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println("结果是："+resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
}
