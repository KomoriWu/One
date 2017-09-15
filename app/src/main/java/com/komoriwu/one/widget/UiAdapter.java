package com.komoriwu.one.widget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class UiAdapter {
    // 竖屏文件的输出路劲
    private final static String rootPathPort = "/F:/studio/project/One/app/src/main/res/values-port-{0}dpi-{1}x{2}/";
    // 横屏文件的输出路劲
    private final static String rootPathLand = "/Users/Sing/Desktop/res/values-land-{0}dpi-{1}x{2}/";
    // 水平方向（X）的值
    private final static String templateX = "    <dimen name=\"dp_{0}_x\">{1}dp</dimen>\n";
    // 垂直方向（Y）的值
    private final static String templateY = "    <dimen name=\"dp_{0}_y\">{1}dp</dimen>\n";
    // 默认模板信息，及参照尺寸，这里用的是1280x720 320dpi
    private static int defaultDpi = 320;
    private static int defaultWidth = 720;
    private static int defaultHeight = 1280;
    private static double defaultScale = 2.0;

    // 将double类型的数据保留两位小数
    public static String twoDemal(double num) {
        DecimalFormat dFormat = new DecimalFormat("##0.00");
        String result = dFormat.format(num);
        return result;
    }

    // 传入宽、高、DPI生成
    public static void makeString(int w, int h, int dpi) {
        makeValue(w,h,dpi,0);// 竖屏X
        makeValue(w,h,dpi,1);// 竖屏Y
        makeValue(w,h,dpi,2);// 横屏X
        makeValue(w,h,dpi,3);// 横屏Y
    }

    // type 0-3 分别为 竖屏X、竖屏Y、横屏X、横屏Y
    private static void makeValue(int w, int h, int dpi, int type) {
        double scale = ((double) dpi / 160); // 缩放比例
        double totalWidthDp = defaultWidth / defaultScale; // 机型水平方向总共有多少个DP
        double totalHeightDp = defaultHeight / defaultScale; // 机型垂直方向总共有多少个DP

        double portWidthValue = (double) w / scale / totalWidthDp; // 竖屏情况下，参考模板水平方向(X) 每1dp对应的适配机型的值
        double portHeightValue = (double) h / scale / totalHeightDp;// 竖屏情况下，参考模板垂直方向(Y) 每1dp对应的适配机型的值
        double landWidthValue = ((double) h / w) * portWidthValue;// 横屏情况下，参考模板水平方向(X) 每1dp对应的适配机型的值
        double landHeightValue = ((double) w / h) * portHeightValue;// 横屏情况下，参考模板垂直方向(Y) 每1dp对应的适配机型的值

        String rootPath = "";// 实际输出的路径
        File layFile = null;
        String fileName = "";

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");// 文件头
        sb.append("<resources>\n");// 文件头

        if (type == 0) { // 竖屏 X
            for (int i = 1; i <= 200; i++) {
                sb.append(templateX.replace("{0}", i + "").replace("{1}", twoDemal(portWidthValue * i) + ""));
            }
            rootPath = rootPathPort;
            fileName = "dimens_x.xml";
        } else if (type == 1) {// 竖屏 Y
            for (int i = 1; i <= 200; i++) {
                sb.append(templateY.replace("{0}", i + "").replace("{1}", twoDemal(portHeightValue * i) + ""));
            }
            rootPath = rootPathPort;
            fileName = "dimens_y.xml";
        } else if (type == 2) {// 横屏 X
            for (int i = 1; i <= 200; i++) {
                sb.append(templateX.replace("{0}", i + "").replace("{1}", twoDemal(landWidthValue * i) + ""));
            }
            fileName = "dimens_x.xml";
            rootPath = rootPathLand;
        } else if (type == 3) {// 横屏 Y
            for (int i = 1; i <= 200; i++) {
                sb.append(templateY.replace("{0}", i + "").replace("{1}", twoDemal(landHeightValue * i) + ""));
            }
            rootPath = rootPathLand;
            fileName = "dimens_y.xml";
        }
        sb.append("</resources>");// 文件尾

        String path = rootPath.replace("{0}", dpi + "").replace("{1}", h + "").replace("{2}", w + "");
        File rootFile = new File(path);
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        layFile = new File(path + fileName);
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(layFile));
            pw.print(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 入口在这里，想生成什么机型就传入什么机型的信息，
    public static void main(String[] args) {
        makeString(480, 800, 160);
        makeString(720, 1280, 320);
        makeString(1080, 1920, 480);
        makeString(1440, 2560, 560);
        // 这里可以输出你想要适配的机型
    }
}
