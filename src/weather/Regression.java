package weather;

/*
 *  How to use WEKA API in Java 
 *  Copyright (C) 2014 
 *  @author Dr Noureddin M. Sadawi (noureddin.sadawi@gmail.com)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ... 
 *  I ask you only, as a professional courtesy, to cite my name, web page 
 *  and my YouTube Channel!
 *  
 */


//import required classes


import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.*;
//import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
//import weka.classifiers.functions.LinearRegression;
//import weka.classifiers.functions.SMOreg;
public class Regression{
	public static void main(String args[]) throws Exception{
		
	
		DataSource source = new DataSource("c:\\datafortraining.csv");
		Instances dataset = source.getDataSet();
		//set class index to the last attribute
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		//build model
		LinearRegression lr = new LinearRegression();
		lr.buildClassifier(dataset);
		//output model
		System.out.println(dataset.numAttributes());
		System.out.println(lr);
		
		
		/*
		//build model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(dataset);
		//output model
		System.out.println(smo);
		*/		
	}
}







/*************************************************
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;


public class Regression
{ public static void main(String args[]) throws Exception
	{
		
	
	String str1=new String();
		String str2=new String();
		String str3=new String();
		String str4=new String();
		String str5=new String();
  //load dataset
		DataSource source = new  DataSource("jdbc:mysql://localhost/weather","root","");
		Instances dataset=Source.getDataSet();
	//set class index to the lasst attribute
		dataset.setClassIndex(dataset.numAttributes()-1);
	//build model
		LinearRegression lr=new LinearRegression();
		lr.buildClassifier(dataset);
	//output model
		System.out.println(dataset.numAttributes());
		System.out.println(lr);
		str1=lr.tostring();
		System.out.println(str2);
		str2=str1.replaceAll("\\S","");
		System.out.println(str2);
		str3=str2.replace("LinearRegressionModel","");
		System.out.println(str3);
		
	}
}
***********************************************************/
