package com.cloud.springboot.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description: HttpUtil
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2018/12/24 0024
 * @Version 1.0
 */
public class HttpUtil {
    private static final String UTF8_STR = "utf-8";
    private static Logger logger = LoggerFactory.getLogger("HttpUtil");

    private HttpUtil() {
    }

    public static String urlGet(String url, String data) {
        try {
            URL urlConn = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)urlConn.openConnection();
            if (StringUtils.isNotEmpty(data)) {
                conn.setRequestMethod("POST");
            }

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", "charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            if (StringUtils.isNotEmpty(data)) {
                IOUtils.write(data.getBytes("UTF-8"), out);
            }

            out.flush();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String string = IOUtils.toString(br);
            conn.disconnect();
            return string;
        } catch (Exception var8) {
            logger.debug(var8.getMessage());
            return null;
        }
    }

    public static String httpRequest(String requestUrl, MultipartFile file) {
        StringBuilder buffer = new StringBuilder();

        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpUrlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.getSize() + "\";filename=\"" + file.getOriginalFilename() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
            Throwable var9 = null;

            try {
                InputStream inputStream = httpUrlConn.getInputStream();
                Throwable var11 = null;

                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                    Throwable var13 = null;

                    try {
                        BufferedReader br = new BufferedReader(inputStreamReader);
                        Throwable var15 = null;

                        try {
                            DataInputStream in = new DataInputStream(file.getInputStream());
                            Throwable var17 = null;

                            try {
                                outputStream.write(head);
                                IOUtils.write(IOUtils.toByteArray(in), outputStream);
                                byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");
                                outputStream.write(foot);
                                outputStream.flush();
                                String string = IOUtils.toString(br);
                                buffer.append(string);
                                httpUrlConn.disconnect();
                            } catch (Throwable var130) {
                                var17 = var130;
                                throw var130;
                            } finally {
                                if (in != null) {
                                    if (var17 != null) {
                                        try {
                                            in.close();
                                        } catch (Throwable var129) {
                                            var17.addSuppressed(var129);
                                        }
                                    } else {
                                        in.close();
                                    }
                                }

                            }
                        } catch (Throwable var132) {
                            var15 = var132;
                            throw var132;
                        } finally {
                            if (br != null) {
                                if (var15 != null) {
                                    try {
                                        br.close();
                                    } catch (Throwable var128) {
                                        var15.addSuppressed(var128);
                                    }
                                } else {
                                    br.close();
                                }
                            }

                        }
                    } catch (Throwable var134) {
                        var13 = var134;
                        throw var134;
                    } finally {
                        if (inputStreamReader != null) {
                            if (var13 != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable var127) {
                                    var13.addSuppressed(var127);
                                }
                            } else {
                                inputStreamReader.close();
                            }
                        }

                    }
                } catch (Throwable var136) {
                    var11 = var136;
                    throw var136;
                } finally {
                    if (inputStream != null) {
                        if (var11 != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable var126) {
                                var11.addSuppressed(var126);
                            }
                        } else {
                            inputStream.close();
                        }
                    }

                }
            } catch (Throwable var138) {
                var9 = var138;
                throw var138;
            } finally {
                if (outputStream != null) {
                    if (var9 != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable var125) {
                            var9.addSuppressed(var125);
                        }
                    } else {
                        outputStream.close();
                    }
                }

            }
        } catch (Exception var140) {
            logger.debug(var140.getMessage());
        }

        return buffer.toString();
    }

}
