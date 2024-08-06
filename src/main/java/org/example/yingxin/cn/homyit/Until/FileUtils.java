package org.example.yingxin.cn.homyit.Until;


import java.io.*;
import java.util.UUID;

    public class FileUtils {

        /**
         * 写入文件 未分块上传
         * 采用MultipartFile接收上传文件并使用FileOutputStream写入文件
         *
         * @param target
         * @param src
         * @throws IOException
         */
        public static void write(String target, InputStream src) throws IOException {
            OutputStream os = new FileOutputStream(target);
            byte[] buf = new byte[1024];
            int len;
            while (-1 != (len = src.read(buf))) {
                os.write(buf, 0, len);
            }
            os.flush();
            os.close();
        }

        /**
         * 分块写入文件
         * 采用MultipartFile接收上传文件的分块文件，上传参数包括：size：文件大小，chunk:分块号，chunks:总分块数
         *
         * @param target
         * @param targetSize
         * @param src
         * @param srcSize
         * @param chunks
         * @param chunk
         * @throws IOException
         */
        public static void writeWithBlcok(String target, Long targetSize, InputStream src, Long srcSize, Integer chunks, Integer chunk) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(target, "rw");
            randomAccessFile.setLength(targetSize);
            if (chunk == chunks - 1) {
                randomAccessFile.seek(targetSize - srcSize);
            } else {
                randomAccessFile.seek(chunk * srcSize);
            }
            byte[] buf = new byte[1024];
            int len;
            while (-1 != (len = src.read(buf))) {
                randomAccessFile.write(buf, 0, len);
            }
            randomAccessFile.close();
        }

        /**
         * 生成随机文件名
         *
         * @return
         */
        public static String generateFileName() {
            return UUID.randomUUID().toString();
        }

        /**
         * 创建目录
         * @param path
         * @return
         */
        public static void mkdir(String path){
            File file = new File(path);
            if (!file.exists()) {
                //boolean created = file.mkdir();
                file.mkdirs();
            }
        }

        /**
         * 获取文件名
         * @param fileName
         * @return
         */
        public static String getExtName(String fileName) {
            String fullName = fileName.toLowerCase();
            int dotIndex = fullName.lastIndexOf(".");
            return dotIndex == -1 ? "" : fileName.substring(dotIndex + 1);
        }



}
