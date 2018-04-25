package com.zeal.shiyulin.utils;

import com.aliyun.oss.OSSClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 阿里云对象云存储工具类
 * Created by Zeal on 2017/7/10.
 */
public class AliyunOSSUtils {

    // endpoint以杭州为例，其它region请按实际情况填写
    //private static final String  endpoint="oss-cn-beijing-internal.aliyuncs.com";        //内网
    //private static final String  endpoint="oss-cn-beijing.aliyuncs.com";          //外网
    private static final String  endpoint="pic.kownyou.com";          //外网
    // accessKey请登录https://ak-console.aliyun.com/#/查看
    private static final String  accessKeyId = "LTAIyT6XujK32CiQ";
    private static final String accessKeySecret = "uindjQdw4Xstj90300g39qin5DwBKm";
    private static final String bucketName = "shiyulin";


    Log log = LogFactory.getLog(AliyunOSSUtils.class);


    //文件存储目录
    private String filedir = "file/";


    private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, AliyunOSSClientConfiguration.getAliyunOSSClientConfiguration());

    private AliyunOSSUtils() {
    }

//    public AliyunOSSUtils() {
//        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//    }

    /**
     * 初始化
     */
    public static OSSClient getOssClient() {
        if(ossClient == null){
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, AliyunOSSClientConfiguration.getAliyunOSSClientConfiguration());
        }
        return ossClient;
    }

    /**
     * 销毁
     */
    public static void destory() {
        ossClient.shutdown();
        ossClient=null;
    }

//    /**
//     * 上传图片
//     *
//     * @param url
//     */
//    public void uploadImg2Oss(String url) {
//        File fileOnServer = new File(url);
//        FileInputStream fin;
//        try {
//            fin = new FileInputStream(fileOnServer);
//            String[] split = url.split("/");
//            this.uploadFile2OSS(fin, split[split.length - 1]);
//        } catch (FileNotFoundException e) {
//            throw new ZealException("图片上传失败");
//        }
//    }
//
//
//    public String uploadImg2Oss(MultipartFile file) {
//        if (file.getSize() > 1024 * 1024) {
//            throw new ZealException("上传图片大小不能超过1M！");
//        }
//        String originalFilename = file.getOriginalFilename();
//        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
//        Random random = new Random();
//        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
//        try {
//            InputStream inputStream = file.getInputStream();
//            this.uploadFile2OSS(inputStream, name);
//            return name;
//        } catch (Exception e) {
//            throw new ZealException("图片上传失败");
//        }
//    }
//
//    /**
//     * 获得图片路径
//     *
//     * @param fileUrl
//     * @return
//     */
//    public String getImgUrl(String fileUrl) {
//        if (!StringUtils.isEmpty(fileUrl)) {
//            String[] split = fileUrl.split("/");
//            return this.getUrl(this.filedir + split[split.length - 1]);
//        }
//        return null;
//    }
//
//    /**
//     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
//     *
//     * @param instream 文件流
//     * @param fileName 文件名称 包括后缀名
//     * @return 出错返回"" ,唯一MD5数字签名
//     */
//    public String uploadFile2OSS(InputStream instream, String fileName) {
//        String ret = "";
//        try {
//            //创建上传Object的Metadata
//            ObjectMetadata objectMetadata = new ObjectMetadata();
//            objectMetadata.setContentLength(instream.available());
//            objectMetadata.setCacheControl("no-cache");
//            objectMetadata.setHeader("Pragma", "no-cache");
//            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
//            objectMetadata.setContentDisposition("inline;filename=" + fileName);
//            //上传文件
//            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
//            ret = putResult.getETag();
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            try {
//                if (instream != null) {
//                    instream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return ret;
//    }
//
//    /**
//     * Description: 判断OSS服务文件上传时文件的contentType
//     *
//     * @param FilenameExtension 文件后缀
//     * @return String
//     */
//    public static String getcontentType(String FilenameExtension) {
//        if (FilenameExtension.equalsIgnoreCase("bmp")) {
//            return "image/bmp";
//        }
//        if (FilenameExtension.equalsIgnoreCase("gif")) {
//            return "image/gif";
//        }
//        if (FilenameExtension.equalsIgnoreCase("jpeg") ||
//                FilenameExtension.equalsIgnoreCase("jpg") ||
//                FilenameExtension.equalsIgnoreCase("png")) {
//            return "image/jpeg";
//        }
//        if (FilenameExtension.equalsIgnoreCase("html")) {
//            return "text/html";
//        }
//        if (FilenameExtension.equalsIgnoreCase("txt")) {
//            return "text/plain";
//        }
//        if (FilenameExtension.equalsIgnoreCase("vsd")) {
//            return "application/vnd.visio";
//        }
//        if (FilenameExtension.equalsIgnoreCase("pptx") ||
//                FilenameExtension.equalsIgnoreCase("ppt")) {
//            return "application/vnd.ms-powerpoint";
//        }
//        if (FilenameExtension.equalsIgnoreCase("docx") ||
//                FilenameExtension.equalsIgnoreCase("doc")) {
//            return "application/msword";
//        }
//        if (FilenameExtension.equalsIgnoreCase("xml")) {
//            return "text/xml";
//        }
//        return "image/jpeg";
//    }
//
//    /**
//     * 获得url链接
//     *
//     * @param key
//     * @return
//     */
//    public  String getUrl(String key) {
//        // 设置URL过期时间为10年  3600l* 1000*24*365*10
//        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//        // 生成URL
//        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
//        if (url != null) {
//            return url.toString();
//        }
//        return null;
//    }
//
//
//    /**
//     * 带进度条上传文件
//     */
//     public  class PutObjectProgressListener implements ProgressListener {
//        private long bytesWritten = 0;
//        private long totalBytes = -1;
//        private boolean succeed = false;
//
//        @Override
//        public void progressChanged(ProgressEvent progressEvent) {
//            long bytes = progressEvent.getBytes();
//            ProgressEventType eventType = progressEvent.getEventType();
//            switch (eventType) {
//                case TRANSFER_STARTED_EVENT:
//                    System.out.println("Start to upload......");
//                    break;
//                case REQUEST_CONTENT_LENGTH_EVENT:
//                    this.totalBytes = bytes;
//                    System.out.println(this.totalBytes + " bytes in total will be uploaded to OSS");
//                    break;
//                case REQUEST_BYTE_TRANSFER_EVENT:
//                    this.bytesWritten += bytes;
//                    if (this.totalBytes != -1) {
//                        int percent = (int) (this.bytesWritten * 100.0 / this.totalBytes);
//                        System.out.println(bytes + " bytes have been written at this time, upload progress: " + percent + "%(" + this.bytesWritten + "/" + this.totalBytes + ")");
//                    } else {
//                        System.out.println(bytes + " bytes have been written at this time, upload ratio: unknown" + "(" + this.bytesWritten + "/...)");
//                    }
//                    break;
//                case TRANSFER_COMPLETED_EVENT:
//                    this.succeed = true;
//                    System.out.println("Succeed to upload, " + this.bytesWritten + " bytes have been transferred in total");
//                    break;
//                case TRANSFER_FAILED_EVENT:
//                    System.out.println("Failed to upload, " + this.bytesWritten + " bytes have been transferred");
//                    break;
//                default:
//                    break;
//            }
//        }
//
//
//        public boolean isSucceed() {
//            return succeed;
//        }
//
//    }
//
//
//    /**
//     * 带进度条上传图片
//     * @param file
//     * @return
//     */
//    public  String uploadFile(File file) throws IOException {
//        String key="";
//        if (file.getName().equals("blob")){
//            key=System.currentTimeMillis()+".jpg";
//        }else {
//            key=System.currentTimeMillis()+file.getName();
//        }
//        String resultUrl="";
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        // byte[] bytes=file.getBytes();
//        try {
//            // 带进度条的上传
//            ossClient.putObject(new PutObjectRequest(bucketName, key,file).
//                    <PutObjectRequest>withProgressListener(new PutObjectProgressListener()));
//            resultUrl=getUrl(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ossClient.shutdown();
//        return resultUrl;
//    }
//
//    /**
//     * 带进度条上传图片
//     * @param bytes
//     * @return
//     */
//    public  String uploadFile(byte [] bytes) throws IOException {
//        String key=System.currentTimeMillis()+".jpg";;
//        String resultUrl="";
//        OSSClient ossClient = getOssClient();
//        // byte[] bytes=file.getBytes();
//        try {
//            // 带进度条的上传
//            ossClient.putObject(new PutObjectRequest(bucketName, key,new ByteArrayInputStream(bytes)).
//                    <PutObjectRequest>withProgressListener(new PutObjectProgressListener()));
//            resultUrl=getUrl(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            ossClient.shutdown();
//        }
//        return resultUrl;
//    }
//
//    /**
//     * 带进度条上传图片
//     * @param file
//     * @return
//     */
//    public  String uploadFile(MultipartFile file) throws IOException {
//        String key="";
//        if (file.getOriginalFilename().equals("blob")&&file.getContentType().equals("image/png")){
//            key=System.currentTimeMillis()+".jpg";
//        }else {
//            key=System.currentTimeMillis()+file.getOriginalFilename();
//        }
//        String resultUrl="";
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        // byte[] bytes=file.getBytes();
//        try {
//            // 带进度条的上传
//            ossClient.putObject(new PutObjectRequest(bucketName, key,file.getInputStream()).
//                    <PutObjectRequest>withProgressListener(new PutObjectProgressListener()));
//            resultUrl=getUrl(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ossClient.shutdown();
//        return resultUrl;
//    }
//
//    /**
//     * MultipartFile 转换成File
//     *
//     * @param multfile 原文件类型
//     * @return File
//     * @throws IOException
//     */
//    public  File multipartToFile(MultipartFile multfile) throws IOException {
//        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
//        //这个myfile是MultipartFile的
//        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
//        File file = fi.getStoreLocation();
//        //手动创建临时文件
//        if(file.length() < 104857600){
//            File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
//                    file.getName());
//            multfile.transferTo(tmpFile);
//            return tmpFile;
//        }
//        return file;
//    }
}
