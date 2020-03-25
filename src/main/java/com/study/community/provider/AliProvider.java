package com.study.community.provider;
import org.springframework.stereotype.Service;

@Service
public class AliProvider {
//    @Value("ali.AccessKeyID")
//    private String accessKey;
//    @Value("ali.AccessKeySecret")
//    private String accessKeySecret;
//    @Value("ali.regionID")
//    private String regionid;
//    IClientProfile profile = DefaultProfile.getProfile(regionid, accessKey,  accessKeySecret);
//    IAcsClient client = new DefaultAcsClient(profile);
//    public String upload(){
//        DescribeInstancesRequest request = new DescribeInstancesRequest();
//        request.setPageSize(10);
//        // Initiate the request and handle the response or exceptions
//        DescribeInstancesResponse response;
//        try {
//            response = client.getAcsResponse(request);
//            for (DescribeInstancesResponse.Instance instance:response.getInstances()) {
//                System.out.println(instance.getPublicIpAddress());
//            }
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

}
