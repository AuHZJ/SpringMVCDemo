package com.briup.test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/**
 * maven�ֿ��ַ
 * https://mvnrepository.com/
 * @author 26503
 *
 */
public class HanyuPinyinHelper {

    /** 
     * ������תΪ����ƴ��
     * @param chineselanguage Ҫת��ƴ��������
     */
    public String toHanyuPinyin(String ChineseLanguage){
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// ���ƴ��ȫ��Сд
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// ��������
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V) ;
        try {
            for (int i=0; i<cl_chars.length; i++){
                if (String.valueOf(cl_chars[i]).matches("[\u4e00-\u9fa5]+")){// ����ַ�������,������תΪ����ƴ��
                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0];
                } else {// ����ַ���������,��ת��
                    hanyupinyin += cl_chars[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("�ַ�����ת�ɺ���ƴ��");
        }
        return hanyupinyin;
    }
    
    public static String getFirstLettersUp(String ChineseLanguage){
        return getFirstLetters(ChineseLanguage ,HanyuPinyinCaseType.UPPERCASE);
    }
    
    public static String getFirstLettersLo(String ChineseLanguage){
        return getFirstLetters(ChineseLanguage ,HanyuPinyinCaseType.LOWERCASE);
    }
    
    public static String getFirstLetters(String ChineseLanguage,HanyuPinyinCaseType caseType) {
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(caseType);// ���ƴ��ȫ����д
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// ��������
        try {
            for (int i = 0; i < cl_chars.length; i++) {
                String str = String.valueOf(cl_chars[i]);
                if (str.matches("[\u4e00-\u9fa5]+")) {// ����ַ�������,������תΪ����ƴ��,��ȡ��һ����ĸ
                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0].substring(0, 1);
                } else if (str.matches("[0-9]+")) {// ����ַ�������,ȡ����
                    hanyupinyin += cl_chars[i];
                } else if (str.matches("[a-zA-Z]+")) {// ����ַ�����ĸ,ȡ��ĸ
                    hanyupinyin += cl_chars[i];
                } else {// ����ת��
                    hanyupinyin += cl_chars[i];//����Ǳ����ŵĻ�������
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("�ַ�����ת�ɺ���ƴ��");
        }
        return hanyupinyin;
    }
    
    public static String getPinyinString(String ChineseLanguage){
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// ���ƴ��ȫ����д
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// ��������
        try {
            for (int i = 0; i < cl_chars.length; i++) {
                String str = String.valueOf(cl_chars[i]);
                if (str.matches("[\u4e00-\u9fa5]+")) {// ����ַ�������,������תΪ����ƴ��,��ȡ��һ����ĸ
                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(
                            cl_chars[i], defaultFormat)[0];
                } else if (str.matches("[0-9]+")) {// ����ַ�������,ȡ����
                    hanyupinyin += cl_chars[i];
                } else if (str.matches("[a-zA-Z]+")) {// ����ַ�����ĸ,ȡ��ĸ

                    hanyupinyin += cl_chars[i];
                } else {// ����ת��
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("�ַ�����ת�ɺ���ƴ��");
        }
        return hanyupinyin;
    }
    /**
     * ȡ��һ�����ֵĵ�һ���ַ�
    * @Title: getFirstLetter 
    * @Description: TODO 
    * @return String   
    * @throws
     */
    public static String getFirstLetter(String ChineseLanguage){
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);// ���ƴ��ȫ����д
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// ��������
        try {
            String str = String.valueOf(cl_chars[0]);
            if (str.matches("[\u4e00-\u9fa5]+")) {// ����ַ�������,������תΪ����ƴ��,��ȡ��һ����ĸ
                hanyupinyin = PinyinHelper.toHanyuPinyinStringArray(
                cl_chars[0], defaultFormat)[0].substring(0, 1);;
            } else if (str.matches("[0-9]+")) {// ����ַ�������,ȡ����
                hanyupinyin += cl_chars[0];
            } else if (str.matches("[a-zA-Z]+")) {// ����ַ�����ĸ,ȡ��ĸ

                hanyupinyin += cl_chars[0];
            } else {// ����ת��

            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("�ַ�����ת�ɺ���ƴ��");
        }
        return hanyupinyin;
    }
    
    public static void main(String[] args) {
        HanyuPinyinHelper hanyuPinyinHelper = new HanyuPinyinHelper() ;
        System.out.println(hanyuPinyinHelper.toHanyuPinyin("123�෢�ķ����ؿշ�������򷢵�����"));
    }
}