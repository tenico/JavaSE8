package com.example.lambda;

import java.util.List;

/**
 * @author Oracle
 * Streams and filters
 */
public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();

   
    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Male Eng Under 65");
    
    // Mail mail, Eng employees < 65
    pl.stream().parallel()
    .filter(m->m.getGender().equals(Gender.MALE))
    .filter(e->e.getDept().equals("Eng"))
    .filter(a->a.getAge() < 65)
    .forEachOrdered(robo::roboMail);
  }
}
