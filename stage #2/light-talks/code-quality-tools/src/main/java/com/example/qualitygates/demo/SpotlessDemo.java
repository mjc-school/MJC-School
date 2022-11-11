package com.example.qualitygates.demo;

/*
 * ./gradlew spotlessJavaCheck
 * 
 * ./gradlew spotlessApply
 */
public class SpotlessDemo {    private String bar;    public void baz() {        System.out.println(bar);    }  
  public SpotlessDemo(String bar) {        this.bar = bar;    }    public SpotlessDemo() {    }    public String getBar() {   
  return bar;    }    public void setBar(String bar) {        this.bar = bar;    }}
