package com.damon.bgmt.utils;

import com.damon.bgmt.exception.ApiException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP请求工具类
 */
public class HttpRequestUtil {

    /**
     * get请求，参数拼接在地址上
     *
     * @param url 请求地址加参数
     * @return 响应
     */
    public String get(String url) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeHttpClient(httpClient, response);
        }
        return null;
    }

    /**
     * get请求，参数放在map里
     *
     * @param url 请求地址
     * @param map 参数map
     * @return 响应
     */
    public String getMap(String url, Map<String, String> map) throws ApiException {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            builder.setParameters(pairs);
            HttpGet get = new HttpGet(builder.build());
            response = httpClient.execute(get);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            } else {
                throw new ApiException("获取信息接口异常", HttpStatus.BAD_REQUEST);
            }
            return result;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new ApiException("获取信息接口异常", HttpStatus.BAD_REQUEST);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            throw new ApiException("获取信息接口异常", HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApiException("获取信息接口异常", HttpStatus.BAD_REQUEST);
        } finally {
            closeHttpClient(httpClient, response);
        }
    }


    /**
     * 发送post请求，参数用map接收
     *
     * @param url 地址
     * @param map 参数
     * @return 返回值
     */
    public String postMap(String url, Map<String, String> map) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
            response = httpClient.execute(post);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeHttpClient(httpClient, response);
        }
        return null;
    }

    /**
     * post请求，参数为json字符串
     *
     * @param url        请求地址
     * @param jsonString json字符串
     * @return 响应
     */
    public String postJson(String url, String jsonString) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new ByteArrayEntity(jsonString.getBytes("UTF-8")));
            response = httpClient.execute(post);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeHttpClient(httpClient, response);
        }
        return null;
    }

    private String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if (entity != null) {
            long lenth = entity.getContentLength();
            if (lenth != -1 && lenth < 2048) {
                result = EntityUtils.toString(entity, "UTF-8");
            } else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while ((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }

    private void closeHttpClient(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        try {
            httpClient.close();
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static InputStream httpFiles(MultiValueMap param, String filePath, String url, String downFilePath) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            FileSystemResource resource = new FileSystemResource(new File(filePath));
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("multipart/form-data;charset=UTF-8");
            if (!filePath.equals("")) {
                param.add("file", resource);
            }
            headers.setContentType(type);
            org.springframework.http.HttpEntity<MultiValueMap<String, Object>> requestEntity = new org.springframework.http.HttpEntity<MultiValueMap<String, Object>>(param, headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, byte[].class);
            byte[] result = response.getBody();
            inputStream = new ByteArrayInputStream(result);
            outputStream = new FileOutputStream(new File(downFilePath));
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            inputStream = new ByteArrayInputStream(result);
        } catch (RestClientException e) {
            e.printStackTrace();
        } finally {
//            if (null != inputStream)
//                inputStream.close();
            if (null != outputStream) {
                outputStream.flush();
                outputStream.close();
            }
        }
        return inputStream;
    }

    public static String httpLibFiles(MultiValueMap param, String faceLibPath, String url, String fileParamName) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            FileSystemResource resource = new FileSystemResource(faceLibPath);
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("multipart/form-data;charset=UTF-8");
            if (!faceLibPath.equals("")) {
                param.add(fileParamName, resource);
            }
            headers.setContentType(type);
            org.springframework.http.HttpEntity<MultiValueMap<String, Object>> requestEntity = new org.springframework.http.HttpEntity<MultiValueMap<String, Object>>(param, headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, byte[].class);
            if (response.getStatusCode().is2xxSuccessful()) {
                byte[] result = response.getBody();
                String s = new String(result);
                return s;
            }
        } catch (RestClientException e) {
            e.printStackTrace();
        } finally {
//            if (null != inputStream)
//                inputStream.close();
            if (null != outputStream) {
                outputStream.flush();
                outputStream.close();
            }
        }
        return null;


    }

    public static void main(String[] args) {
//        //定义两种不同格式的字符串
//        String objectStr="{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";
//        String arrayStr="[{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}]";
//
//        //1、使用JSONObject
//        JSONObject jsonObject= JSONObject.parseObject(objectStr);
//
//        System.out.println(jsonObject.get("name"));
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("type","0");
//        map.put("id","AAA21212121");
//
//        System.out.println(map.toString());
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("type","0");
//        jsonObj.put("id","0");
//        System.out.println(jsonObj.toString());
//        HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
///*        String aa = httpRequestUtil.postJson("http://142.0.2.161:5555/mixedquery/contract/sendMessageNote","{\n" +
//                "\"phone\":\"15668307338\",\n" +
//                "\"courtNo\":\"1850\",\n" +
//                "\"content\":\"测试\",\n" +
//                "\"receiveName\":\"测试\"\n" +
//                "}\n");*/
//        Map<String,String> map1 = new HashMap<String,String>();
//        map1.put("phone","15668307338");
//        map1.put("courtNo","1850");
//        map1.put("content","测试");
//        map1.put("receiveName","测试");
//        String aa = httpRequestUtil.postMap("http://142.0.2.161:5555/mixedquery/contract/sendMessageNote",map1);
//        System.out.println(aa);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("name", "公司测试人脸库");
        param.add("description", "公司测试人脸库");
        try {
            String result = HttpRequestUtil.httpLibFiles(param, "C:\\Users\\Administrator\\Desktop\\济宁市中级人民法院.zip", "http://192.168.3.32:6002/faceLib", "libZip");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

