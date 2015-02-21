package Tools;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GetColor {
	 /**
     * ȡ��ͼ����ָ��λ�����ص� rgb ��ɫ����,�����浽����rgb���档
     * @param image Դͼ��
     * @param x ͼ����ָ������λ�õ� x ���ꡣ
     * @param y ͼ����ָ������λ�õ� y ���ꡣ
     * @return ���ذ��� rgb ��ɫ����ֵ�����顣Ԫ�� index ��С����ֱ��Ӧ r��g��b��
     */
    public static int[] getImageRGB(BufferedImage image, int x, int y){
        int[] rgb = new int [3];
        int pixel = image.getRGB(x, y);
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        
        return  rgb;
    }
    /**
     * ȡ��JFrame��ָ��λ�����ص� rgb ��ɫ����,�����浽����rgb���档
     * @param obj JFrame ʵ�塣
     * @param x JFrame��ָ������λ�õ� x ���ꡣ
     * @param y JFrame��ָ������λ�õ� y ���ꡣ
     * @return ���ذ��� rgb ��ɫ����ֵ�����顣Ԫ�� index ��С����ֱ��Ӧ r��g��b��
     */
    public static int[] getJframeRGB(JFrame obj, int x, int y){
    	int[] rgb = new int [3];
        int pixel = obj.getPixelColor(x, y);
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        
        return  rgb;
    }
}
