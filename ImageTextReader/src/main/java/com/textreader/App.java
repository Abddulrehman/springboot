package com.textreader;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



public class App 
{
//	public static String crackImage(String filePath) {  
//	    File imageFile = new File(filePath);  
//	    ITesseract instance = new Tesseract();  
//	    try {  
//	        String result = instance.doOCR(imageFile);  
//	        return result;  
//	    } catch (TesseractException e) {  
//	        System.err.println(e.getMessage());  
//	        return "Error while reading image";  
//	    }  
//	} 
	
	
	
	public static int binarySearch(int arr[], int ele,int s,int e) {
		
		while(s<e) {
		int m=(s+e)/2;
		
		if(ele == arr[m])
		{
			return m;
		}else if(ele > arr[m]) 
		{
 			return binarySearch(arr,ele,m+1,e);
		}else
		{
			return binarySearch(arr,ele,s,m-1);
		}
		}
		return -1;
		
	}
	
	
	public static int  factorial(int num) {
		int res=0;
		if(num==0)
			return 1;
		else {
			
			return (num*factorial(num-1));
			
		}

		
	}
	
	public static int[] sortAsscending(int arr[]) {
	
		
		int temp=0;
		for(int x=0; x<arr.length;x ++)
		{
			temp=x;
			
			for(int y=x+1; y<arr.length;y++)
			{
				if(arr[y] < arr[x])
				{
					temp=arr[x];
					arr[x]=arr[y];
					arr[y]=temp;
				}}}
		return arr;
	}
    public static void main( String[] args )
    {
    	 System.out.println("testing ...... ");
    	 
    	 int a[]= {4,5,2,1,8,9,4,9,4,3,6,7,88,22};
    	 int e=2;
    	 
    	// int i=binarySearch(a,e,0,a.length);
    	 
       	//int i= factorial(5);
    	// System.out.println("fact of 5 "+i);
    	  a=sortAsscending(a);
    	 
    	  int ele=7;
    	  int numb=binarySearch(a,ele,0,a.length-1);
    	  
    	  System.out.println(numb);
    	 for(int i1=0;i1<a.length; i1++)
 		{
 			System.out.print(a[i1]+" ");
 		}
    }
}