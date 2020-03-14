package com.automation.test.day09;




import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {


        String reversed = "";



    }
    public static String  reverse(String str){
        String re = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            re+=""+str.charAt(i);
        }
        return re;
    }


    // annotation  @Test
    @Test
    public void test(){

        String expected = "elppa";
        String actual = reverse("apple");
        Assert.assertEquals(expected,actual);
    }


    @Test(description = "check if it same ")
    public void test2(){
        String expected = "reac";
        String actual = reverse("caer");
        Assert.assertEquals(expected,actual);
    }
}
