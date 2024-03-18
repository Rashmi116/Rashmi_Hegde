package com.wiley.sort;

public class DRY {
	  
    public void CSE()
    {
        System.out.println("This is computer science");
        college();
    }
  
    public void ECE()
    {
        System.out.println("This is electronics");
        college();
    }
  
    public void IT()
    {
        System.out.println(
            "This is Information Technology");
        college();
    }
  
    public void college()
    {
        System.out.println("Wiley-India");
    }
  
    public static void main(String[] args)
    {
        DRY s = new DRY();
  
        s.CSE();
        s.ECE();
        s.IT();
    }
}