package main;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class ImageDownload {
    public static void main(String[] args) {
        String urlString = "https://tbweb.iimzt.com/thumbs/2020/08/244604_450.jpg";
        String savePath = "E:/download2/i.jpg";
        download(urlString,savePath);
    }
    public static void download(String urlString, String savePath) {
        File file = new File(savePath);
        if (file.exists()) {
            return;
        }
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
            urlConnection.setRequestProperty("Connection", "Keep-Alive");
            urlConnection.setRequestProperty("Referer", "https://www.mzitu.com/");
            urlConnection.setRequestProperty("server", "nginx");
            urlConnection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/x-ms-application, application/x-ms-xbap, application/vnd.ms-xpsdocument, application/xaml+xml, application/QVOD, application/QVOD, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
//            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("GET");
//            urlConnection.connect();

            DataInputStream dataInputStream = new DataInputStream(urlConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            System.out.printf("Download Success: {}", savePath);
            dataInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Download Error: {}", e.getMessage());
        }
    }
}
