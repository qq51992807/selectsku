package com.yang.selectsku.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;


public class RecodeUtil {


    public static String  creatRrCode(String contents, int width, int height) {
        String binary=null;
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); //容错级别最高
        hints.put( EncodeHintType.CHARACTER_SET, "utf-8");  //设置字符编码
        hints.put(EncodeHintType.MARGIN, 1);//二维码空白区域,最小为0也有白边,只是很小,最小是6像素左右
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints); // 1、读取文件转换为字节数组
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedImage image = toBufferedImage(bitMatrix);
            //转换成png格式的IO流
            ImageIO.write(image, "png", out);
//            byte[] bytes = out.toByteArray();
////            // 2、将字节数组转为二进制
//            BASE64Encoder encoder = new BASE64Encoder();
//            binary = encoder.encodeBuffer(bytes).trim();
            binary=Base64.encodeBase64String(out.toByteArray());
        } catch (WriterException e) { // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return binary;
    }
    /**
     * image流数据处理
     *
     * @author ianly
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }

    private static char[] codec_table = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '+', '/' };
    public static String encode(byte[] a) {
        int totalBits = a.length * 8;
        int nn = totalBits % 6;
        int curPos = 0;// process bits
        StringBuffer toReturn = new StringBuffer();
        while (curPos < totalBits) {
            int bytePos = curPos / 8;
            switch (curPos % 8) {
                case 0:
                    toReturn.append(codec_table[(a[bytePos] & 0xfc) >> 2]);
                    break;
                case 2:

                    toReturn.append(codec_table[(a[bytePos] & 0x3f)]);
                    break;
                case 4:
                    if (bytePos == a.length - 1) {
                        toReturn
                                .append(codec_table[((a[bytePos] & 0x0f) << 2) & 0x3f]);
                    } else {
                        int pos = (((a[bytePos] & 0x0f) << 2) | ((a[bytePos + 1] & 0xc0) >> 6)) & 0x3f;
                        toReturn.append(codec_table[pos]);
                    }
                    break;
                case 6:
                    if (bytePos == a.length - 1) {
                        toReturn
                                .append(codec_table[((a[bytePos] & 0x03) << 4) & 0x3f]);
                    } else {
                        int pos = (((a[bytePos] & 0x03) << 4) | ((a[bytePos + 1] & 0xf0) >> 4)) & 0x3f;
                        toReturn.append(codec_table[pos]);
                    }
                    break;
                default:
                    //never hanppen
                    break;
            }
            curPos+=6;
        }
        if(nn==2)
        {
            toReturn.append("==");
        }
        else if(nn==4)
        {
            toReturn.append("=");
        }
        return toReturn.toString();

    }


}
